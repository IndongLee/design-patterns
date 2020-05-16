package pizza

class NYStyleVeggiePizza : Pizza() {
    override val name: String
        get() = "NY Style Sauce and Veggie Pizza"
    override val dough: String
        get() = "Thin Crust Dough"
    override val sauce: String
        get() = "Marinara Sauce"

    init {
        toppings.add("Grated Reggiano Cheese")
    }
}