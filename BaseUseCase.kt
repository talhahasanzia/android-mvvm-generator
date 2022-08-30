package <YOUR_PACKAGE_NAME>

interface BaseUseCase<Input, Output> {
    suspend fun execute(input: Input): Output
}