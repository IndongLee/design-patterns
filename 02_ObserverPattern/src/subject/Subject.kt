package subject

import observer.Observer

interface Subject {
    fun registerObserver(o: Observer)

    fun removeObserver(o: Observer)

    fun notifyObservers()
}