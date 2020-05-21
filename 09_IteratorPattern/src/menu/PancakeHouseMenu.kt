package menu

import iterator.DinerMenuIterator
import iterator.Iterator
import iterator.PancakeHouseMenuIterator
import menu.MenuItem

class PancakeHouseMenu : Menu{
    val menuItems: ArrayList<MenuItem> = arrayListOf()

    init {
        addItem("K&B 팬케이크 세트",
        "스크램블드 에그와 토스트와 곁들여진 팬케이크",
        true,
        2.99)
        addItem("레귤러 팬케이크 세트",
        "달걀 후라이와 소시지 곁들여진 팬케이크",
        false,
        3.49)
        addItem("블루베리 팬케이크",
        "신선한 블루베리와 블루베리 시럽으로 만든 팬케이크",
        true,
        3.49)
        addItem("와플",
        "와플, 취향에 따라 블루베리나 딸기를 얹을 수 있습니다.",
        true,
        3.59)
    }

    private fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        val menuItem = MenuItem(name, description, vegetarian, price)
        menuItems.add(menuItem)
    }

    override fun createIterator(): Iterator {
        return PancakeHouseMenuIterator(menuItems)
    }
}