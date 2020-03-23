class DarkRoast : Beverage() {
    override val description = "하우스 블렌드 커피"

    override fun cost() = 0.89
}

class Espresso : Beverage() {
    override val description = "에스프레소"

    override fun cost() = 1.99
}