package iterator

import menu.MenuItem

class PancakeHouseMenuIterator(private val items: ArrayList<MenuItem>) : Iterator {
    var position = 0

    override fun hasNext(): Boolean {
        return position < items.size
    }

    override fun next(): Any {
        return items[position++]
    }
}
