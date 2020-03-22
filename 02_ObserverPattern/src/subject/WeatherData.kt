package subject

import observer.Observer

class WeatherData : Subject {
    private val observers: ArrayList<Observer> = arrayListOf()
    private var temperature: Float = 0F
    private var humidity: Float = 0F
    private var pressure: Float = 0F

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        val index = observers.indexOf(o)
        if (index >= 0) observers.removeAt(index)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(temperature, humidity, pressure) }
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    fun setTemperature(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}