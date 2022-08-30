package <YOUR_PACKAGE_NAME>

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface StringResourceProvider {
    fun getString(@StringRes id: Int): String
    fun getString(@StringRes id: Int, valueToFormat: Int): String
    fun getString(@StringRes id: Int, valueToFormat: String): String
}

class DefaultStringResourceProvider @Inject constructor(@ApplicationContext private val context: Context) :
    StringResourceProvider {

    override fun getString(id: Int): String {
        return context.getString(id)
    }

    override fun getString(id: Int, valueToFormat: Int): String {
        return context.getString(id, valueToFormat)
    }

    override fun getString(id: Int, valueToFormat: String): String {
        return context.getString(id, valueToFormat)
    }
}
