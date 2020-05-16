package factory

import pizza.ChicagoStyleCheesePizza
import pizza.ChicagoStyleClamPizza
import pizza.ChicagoStylePepperoniPizza
import pizza.Pizza

class SimplePizzaFactory() {
    fun createPizza(type: String): Pizza? {
        return when(type) {
            "cheese" -> ChicagoStyleCheesePizza()
            "greek" -> ChicagoStyleClamPizza()
            "pepperoni" -> ChicagoStylePepperoniPizza()
            else -> null
        }
    }
}