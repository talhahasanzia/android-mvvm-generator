# Android MVVM Generator
![mvvm](https://github.com/talhahasanzia/android-mvvm-generator/blob/main/mvvm.gif)

## Pre-requisites
- Project assumes that you use Hilt, Retrofit, Kotlin, Flows, Jetpack ViewModel and MVVM with UseCase layer.
- Import `file_templates.zip` as intelliJ settings file. It only imports file templates, so rest of your settings remaing intact. [(How to)](https://www.jetbrains.com/help/idea/sharing-your-ide-settings.html#import-export-settings)
- Copy some base files in your desired directory, which include:
  - `NetworkProvider` sets up `retrofit` instance, you can replace with your own
  - `BaseUseCase` interface enforces SRP by providing 1 method that works on 1 input and 1 output. 
  - `BaseService` has api call boilerplate, including default error messages mapped to http codes
  - `Resource` sealed class to map network response to `Data` for success else `Error`
  - `StringResourceProvider` is wrapper around `strings.xml` resource that is declared in its module
  - `dependencies.gradle` file has all the dependencies needed, this is then imported in `build.gradle (app)`
  - Setup some dependencies project wide using `build.gradle (project)` and module wide `build.gradle (app)`
  
  You can always replace/edit these as per your requirements.
  
## Usage
- Create a package for feature in your desired package e.g. `login`
- Right click on target feature package, goto `New` then click `New Feature`, enter name when prompt appears
- Name in `New Feature` is case sensitive, e.g. `Login`, generated classes will be case sensitive with capital `L`- `LoginApi`, `LoginUseCase` etc.
- You will get all the classes generated! 

Few more steps:

- Since base classes are completely subjective to their creation and placement, you will have to add some import statements.
- Goto generated `ViewModel`, `UseCase` and `ApiService` classes and add imports for base/common classes. (takes <10 seconds).
- Voila !  You have a feature skeleton ready to work on.

## Generated Classes
_`<>` replaces your generated feature name_
- `<>Api` - Retrofit API end point class
- `<>Service` - Network call logic, uses `<>Api`
- `<>UseCase` - Use case to contain pure logic for data transformation/manipulation
- `<>ViewModel` - ViewModel with basic structure having reference to use case and some livedata declared
- `<>Fragment` - Empty Fragment 
- `<>Request` - Model for UseCase input, there is room for better naming convention here.
- `<>State` - Model for UseCase output, again, there is room for better naming convention here.
- `<>RequestDto` - Model for request data in API call. This is json annotated to be used with Moshi.
- `<>Response` - Model for response object, this is json annotated to be used with Moshi.

## Extensibility


## Disclaimer

