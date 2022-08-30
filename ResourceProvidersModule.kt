package <YOUR_PACKAGE_NAME>

import <YOUR_PACKAGE_NAME>.DefaultStringResourceProvider
import <YOUR_PACKAGE_NAME>.StringResourceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Dependencies that help in managing Android based resources or other common logic providers.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class ResourceProvidersModule {
    @Binds
    abstract fun bindStringResourceProvider(instance: DefaultStringResourceProvider): StringResourceProvider
}