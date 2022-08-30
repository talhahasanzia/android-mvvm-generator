# Android MVVM Generator
![mvvm](https://github.com/talhahasanzia/android-mvvm-generator/blob/main/mvvm.gif)

## Pre-requisites
- Project assumes that you use Hilt, Retrofit, Kotlin, Flows, Jetpack ViewModel and MVVM with UseCase layer.
- Import `file_templates.zip` as intelliJ settings file. It only imports file templates, so rest of your settings remaing intact. [(How to)](https://www.jetbrains.com/help/idea/sharing-your-ide-settings.html#import-export-settings)
- Copy some base files in your desired directory these include:
  - `NetworkProvider` sets up `retrofit` instance, you can replace with your own
  - `BaseUseCase` interface enforces SRP by providing 1 method that works on 1 input and 1 output. 
  - `BaseService` has api call boilerplate, including default error messages mapped to http codes
  - `Resource` sealed class to map network response to `Data` for success else `Error`
  - `StringResourceProvider` is wrapper around `strings.xml` resource that is declared in its module
  - `dependencies.gradle` file has all the dependencies needed, this is then imported in `build.gradle (app)`
  - Setup some dependencies project wide using `build.gradle (project)` and `build.gradle (app)`
  
  You can always replace/edit these as per your requirements.
