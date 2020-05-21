import iterator.Iterator
import menu.Menu
import menu.MenuItem

class Waiter(private val menus: ArrayList<Menu>) {

    fun printMenu() {
        val menuIterator = menus.iterator()
        while (menuIterator.hasNext()) {
            val menu = menuIterator.next()
            printMenu(menu.createIterator())
        }
    }

    fun printMenu(iterator: Iterator) {
        while (iterator.hasNext()) {
            val menuItem = iterator.next() as MenuItem
            println("${menuItem.name}, ${menuItem.price} -- ${menuItem.description}")
        }
    }
}