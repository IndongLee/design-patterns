package factory.ingredient

import ingredient.cheese.Cheese
import ingredient.cheese.ReggianoCheese
import ingredient.clams.Clams
import ingredient.clams.FreshClams
import ingredient.dough.Dough
import ingredient.dough.ThinCrustDough
import ingredient.pepperoni.Pepperoni
import ingredient.pepperoni.SlicedPepperoni
import ingredient.sauce.MarinaraSauce
import ingredient.sauce.Sauce
import ingredient.veggies.*

class ChicagoPizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough {
        return ThinCrustDough()
    }

    override fun createSauce(): Sauce {
        return MarinaraSauce()
    }

    override fun createCheese(): Cheese {
        return ReggianoCheese()
    }

    override fun createVeggies(): Array<Veggies> {
        return arrayOf(Garlic(), Onion(), Mushroom(), RedPepper())
    }

    override fun createPepperoni(): Pepperoni {
        return SlicedPepperoni()
    }

    override fun createClam(): Clams {
        return FreshClams()
    }
}