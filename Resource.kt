package <YOUR_PACKAGE_NAME>

sealed class Resource<T>{
    data class Data<T>(val data : T) : Resource<T>()
    data class Error(val errorMessage : String, val errorCode : Int) : Resource<Nothing>()
}