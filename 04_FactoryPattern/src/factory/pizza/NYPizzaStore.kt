package factory.pizza

import PizzaStore
import factory.ingredient.NYPizzaIngredientFactory
import pizza.*

class NYPizzaStore : PizzaStore() {
    private val ingredientFactory = NYPizzaIngredientFactory()

    override fun createPizza(type: String): Pizza? = when (type) {
        "cheese" -> CheesePizza(ingredientFactory).apply { name = "New York Style Cheese Pizza" }
        "pepperoni" -> PepperoniPizza(ingredientFactory).apply { name = "New York Style Pepperoni Pizza" }
        "clam" -> ClamPizza(ingredientFactory).apply { name = "New York Style Clam Pizza" }
        "veggie" -> VeggiePizza(ingredientFactory).apply { name = "New York Style Veggie Pizza" }
        else -> null
    }
}