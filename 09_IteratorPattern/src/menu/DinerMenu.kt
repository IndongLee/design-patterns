package menu

import iterator.DinerMenuIterator
import iterator.Iterator

class DinerMenu : Menu {
    private val maxItems = 6
    private var numberOfItems = 0
    val menuItems = Array<MenuItem?>(maxItems) { null }

    init {
        addItem("채식주의자용 BLT",
            "통밀 위에 (식물성) 베이컨, 상추, 토마토를 얹은 메뉴",
            true,
            2.99)
        addItem("BLT",
            "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴",
            false,
            2.99)
        addItem("오늘의 스프",
            "감자 샐러드를 겪은 오늘의 스프",
            false,
            3.29)
        addItem("핫도그",
            "사워 크라우트, 갖은 양념, 양파, 치즈가 들어간 핫도그",
            false,
            3.05)
    }

    private fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        val menuItem = MenuItem(name, description, vegetarian, price)
        if (numberOfItems >= maxItems) {
            error("죄송합니다. 메뉴가 꽉 찼습니다. 더 이상 추가할 수 없습니다.")
        } else {
            menuItems[numberOfItems++] = menuItem
        }
    }

    override fun createIterator(): Iterator {
        return DinerMenuIterator(menuItems)
    }
}