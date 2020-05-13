package factory

import pizza.CheesePizza
import pizza.GreekPizza
import pizza.PepperoniPizza
import pizza.Pizza

class SimplePizzaFactory() {
    fun createPizza(type: String): Pizza? {
        return when(type) {
            "cheese" -> CheesePizza()
            "greek" -> GreekPizza()
            "pepperoni" -> PepperoniPizza()
            else -> null
        }
    }
}