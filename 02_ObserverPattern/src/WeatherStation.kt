import observer.CurrentConditionsDisplay
import subject.WeatherData

fun main() {
    val weatherData = WeatherData()

    val currentDisplay = CurrentConditionsDisplay(weatherData)

    weatherData.setTemperature(80F, 65F, 30.4F)
    weatherData.setTemperature(82F, 70F, 29.2F)
}