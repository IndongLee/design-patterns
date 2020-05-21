package iterator

interface Iterator {
    fun hasNext(): Boolean

    fun next(): Any
}