package factory

import PizzaStore
import pizza.*

class NYPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza? = when (type) {
        "cheese" -> NYStyleCheesePizza()
        "pepperoni" -> NYStylePepperoniPizza()
        "clam" -> NYStyleClamPizza()
        "veggie" -> NYStyleVeggiePizza()
        else -> null
    }
}