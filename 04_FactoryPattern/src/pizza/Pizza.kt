package pizza

abstract class Pizza {
    abstract val name: String
    abstract val dough: String
    abstract val sauce: String
    val toppings = arrayListOf<String>()

    open fun prepare() {

    }

    open fun bake() {

    }

    open fun cut() {

    }

    open fun box() {

    }
}