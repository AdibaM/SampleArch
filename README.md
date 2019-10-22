# SampleArch

The app contains two basic screens
  - a launch screen which lives within its own module  
  - a feed screen which can be accessed via the launch screen.

The feed screen loads chart data from the LastFm Api.

Each component is unit tested. 

Modules:

There are 3 modules in the project

- App: A simple launcher module, an entry point into the app
- Core: As the name suggests, it contains things specific to business logic which can be potentially shared across many modules
- Feed: A Feed which loads artist data from the LastFm. Api.

Other notable mentions:

- The project uses MVVM , RxJava2 , Retrofit2 , Android Jetpack components , MockK , Junit , Gson
- There isn't a strong focus on UI here
