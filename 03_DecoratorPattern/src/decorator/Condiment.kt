package decorator

import Beverage

class Mocha(val beverage: Beverage) : CondimentDecorator() {
    override val description: String
        get() = "${beverage.description} 모카"


    override fun cost() = 0.2 + beverage.cost()
}