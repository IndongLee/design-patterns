package factory

import PizzaStore
import pizza.*

class ChicagoPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza? = when (type) {
        "cheese" -> ChicagoStyleCheesePizza()
        "pepperoni" -> ChicagoStylePepperoniPizza()
        "clam" -> ChicagoStyleClamPizza()
        "veggie" -> ChicagoStyleVeggiePizza()
        else -> null
    }
}