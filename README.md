# WeatherForecast
### Comment 2024
I've created this app in 2019 for an interview. It had to be a simple app showing weather forecast for ten hardcoded cities.

Nowadays I would probably use Jetpack Compose to create a new app like this. I would also use Hilt instead of Dagger, Kotlin Coroutines Flow instead of LiveData etc. It it was a bigger app I would use repositories and domain layer, but for this simple app it would be a huge overkill.

Room database could be used to cache the data fetching from the API.

### Original text from 2019
App showing weather forecast for ten hardcoded cities (PRague, London, Vienna, Paris, Wellington, New York, Berlin, Zlin, Barcelona, Tokyo). Purpose of this app is to show how I create the apps. Which patterns do I use, the structure of the app, architecture, etc.

The app is written in Kotlin with a couple of third party libraries (Retrofit, Coroutines, Dagger, Android Architecture Components). It implements MVVM architecture/pattern. My approach is probably little bit too complicated for that task, however, I have used the opportunity to learn something new and try the concepts and patterns in Kotlin (which I usually use in Java). I have not had the luck to use Kotlin that much before, only smaller projects for fun.

I am pretty sure, that the app could be improved in some ways. It could have more sophisticated error handling, it could have better UI with some transitions and animations, few images would make it probably better too. On the other hand, the app has been created in a few days from scratch. I have focused on the code and architecture/structure more than on the app icon and so on, so forgive me please that these parts are missing. I suppose that you know how easy it is to change these things.

I hope you will enjoy looking at the code :-)

Thank you!
