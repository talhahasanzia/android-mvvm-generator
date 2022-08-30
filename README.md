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
- `<>Bindings` - DI bindings for `Service` and `UseCase` classes/interfaces
- `<>Module` - DI module method to create `<>Api` instance using `retrofit` instance discussed in Pre-requisites.

## Extensibility
While this is pretty specific, it very easy to edit or update templates
- Goto `Preferences` in you IntelliJ (dependending on the OS, options may change), select `File and Code Templates` and scroll down in `Files` section.
- You will see there custom templates as mentioned in the image.
- You can add, edit, remove or even create an entirely new set of templates from this.
- This uses [Apache Velocity](https://velocity.apache.org/engine/1.7/user-guide.html) langauage which is also mentioned in this prompt as `VTL`.
- This is fairly simple, declarative, yet very powerful templating language. You can almost achieve everything that a code generator can using this tempalting engine.

## Disclaimer
- This does not in any way, ask you to implement or design apps/solutions with a preference. This might be 1 out of many ways to do things.
- Do not expect this project to work 100% perfectly 100% of the time.
- This is licensed with [Apache 2.0](https://github.com/talhahasanzia/android-mvvm-generator/blob/main/LICENSE)
