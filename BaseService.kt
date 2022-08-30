package <YOUR_PACKAGE_NAME>

import <YOUR_PACKAGE_NAME>.R
import <YOUR_PACKAGE_NAME>.StringResourceProvider
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.HttpException
import java.io.EOFException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

abstract class BaseService(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val stringResourceProvider: StringResourceProvider
) {

    protected suspend fun <T> requestApiResource(apiCall: suspend () -> T): Resource<out T> {
        return try {
                val result = apiCall.invoke()
            Resource.Data(result)
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> handleHttpExceptions(throwable)
                    is TimeoutException -> handleTimeOut()
                    is EOFException -> handleEmptyResult()
                    is IOException -> handleNetworkError(throwable)
                    else -> createUnexpectedError(throwable)
                }
            }

    }

    private fun handleNetworkError(throwable: IOException): Resource.Error {
        return when (throwable) {
            is SocketTimeoutException -> createDefaultResponseError(
                stringResourceProvider.getString(
                    R.string.internet_issue_message
                )
            )
            is UnknownHostException -> createDefaultResponseError(stringResourceProvider.getString(R.string.server_not_responding))
            else -> createDefaultResponseError(stringResourceProvider.getString(R.string.internet_issue_message))
        }
    }

    private fun handleTimeOut(): Resource.Error {
        return Resource.Error(
            stringResourceProvider.getString(R.string.internet_issue_message),
            DEFAULT_ERROR_CODE
        )
    }

    private fun handleEmptyResult(): Resource.Error {
        return Resource.Error(
            stringResourceProvider.getString(R.string.no_data_found),
            DEFAULT_ERROR_CODE
        )
    }

    private fun handleHttpExceptions(throwable: HttpException): Resource.Error {
        return when (throwable.code()) {
            502 -> createDefaultResponseError(stringResourceProvider.getString(R.string.bad_gateway_message))
            500 -> createDefaultResponseError(stringResourceProvider.getString(R.string.internal_server_error))
            404 -> createDefaultResponseError(stringResourceProvider.getString(R.string.url_not_responding))
            else -> {
                createUnexpectedError(throwable)
            }
        }
    }

    private  fun  createUnexpectedError(throwable: Throwable) : Resource.Error =
        Resource.Error(
            throwable.message ?: stringResourceProvider.getString(R.string.unexpected_error),
            DEFAULT_ERROR_CODE
        )

    private fun createDefaultResponseError(
        userMessage: String
    ): Resource.Error {
        return Resource.Error(
            userMessage,
            DEFAULT_ERROR_CODE
        )
    }

    companion object {
        private const val DEFAULT_ERROR_CODE = -1
    }
}