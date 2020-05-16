package pizza

class ChicagoStyleCheesePizza : Pizza() {
    override val name: String
        get() = "Chicago Style Deep Dish Cheese Pizza"
    override val dough: String
        get() = "Extra Thick Crust Dough"
    override val sauce: String
        get() = "Plum Tomato Sauce"

    init {
        toppings.add("Shredded Mozzarella Cheese")
    }

    override fun cut() {
        println("Cutting the pizza into square slices")
    }
}