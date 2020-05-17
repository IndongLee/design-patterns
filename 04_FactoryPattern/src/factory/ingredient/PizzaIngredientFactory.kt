package factory.ingredient

import ingredient.cheese.Cheese
import ingredient.clams.Clams
import ingredient.dough.Dough
import ingredient.pepperoni.Pepperoni
import ingredient.sauce.Sauce
import ingredient.veggies.Veggies

interface PizzaIngredientFactory {
    fun createDough(): Dough

    fun createSauce(): Sauce

    fun createCheese(): Cheese

    fun createVeggies(): Array<Veggies>

    fun createPepperoni(): Pepperoni

    fun createClam(): Clams
}