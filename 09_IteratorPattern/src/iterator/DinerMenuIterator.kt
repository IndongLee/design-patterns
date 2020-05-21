package iterator

import menu.MenuItem

class DinerMenuIterator(private val items: Array<MenuItem?>) : Iterator {
    var position = 0

    override fun hasNext(): Boolean {
        return !(position >= items.size || items[position] == null)
    }

    override fun next(): Any {
        return items[position++]!!
    }
}