package menu

import iterator.Iterator

interface Menu {
    fun createIterator(): Iterator
}