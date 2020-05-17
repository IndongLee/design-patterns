package pizza

import ingredient.cheese.Cheese
import ingredient.clams.Clams
import ingredient.dough.Dough
import ingredient.pepperoni.Pepperoni
import ingredient.sauce.Sauce
import ingredient.veggies.Veggies

abstract class Pizza {
    var name: String = ""
    lateinit var dough: Dough
    lateinit var sauce: Sauce
    lateinit var veggies: Array<Veggies>
    lateinit var cheese: Cheese
    lateinit var pepperoni: Pepperoni
    lateinit var clam: Clams

    abstract fun prepare()

    open fun bake() {
        println("Bake for 25 minutes at 350")
    }

    open fun cut() {
        println("Cutting the pizza into diagonal slices")
    }

    open fun box() {
        println("Place pizza in official PizzaStore box")
    }
}