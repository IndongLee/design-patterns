package pizza

class NYStylePepperoniPizza : Pizza() {
    override val name: String
        get() = "NY Style Sauce and Pepperoni Pizza"
    override val dough: String
        get() = "Thin Crust Dough"
    override val sauce: String
        get() = "Marinara Sauce"

    init {
        toppings.add("Grated Reggiano Cheese")
    }
}