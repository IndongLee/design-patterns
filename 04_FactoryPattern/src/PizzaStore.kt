import factory.SimplePizzaFactory
import pizza.CheesePizza
import pizza.GreekPizza
import pizza.PepperoniPizza
import pizza.Pizza

class PizzaStore(val factory: SimplePizzaFactory) {
    fun orderPizza(type: String): Pizza? {
        return factory.createPizza(type)?.apply {
            prepare()
            bake()
            cut()
            box()
        }
    }
}