package factory.pizza

import PizzaStore
import factory.ingredient.ChicagoPizzaIngredientFactory
import pizza.*

class ChicagoPizzaStore : PizzaStore() {
    private val ingredientFactory = ChicagoPizzaIngredientFactory()

    override fun createPizza(type: String): Pizza? = when (type) {
        "cheese" -> CheesePizza(ingredientFactory).apply { name = "Chicago Style Cheese Pizza" }
        "pepperoni" -> PepperoniPizza(ingredientFactory).apply { name = "Chicago Style Pepperoni Pizza" }
        "clam" -> ClamPizza(ingredientFactory).apply { name = "Chicago Style Clam Pizza" }
        "veggie" -> VeggiePizza(ingredientFactory).apply { name = "Chicago Style Veggie Pizza" }
        else -> null
    }
}