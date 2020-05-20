abstract class CaffeineBeverage {
    fun prepareRecipe() {
        boilWater()
        brew()
        pourInCup()
        addCondiments()
    }

    abstract fun brew()

    abstract fun addCondiments()

    private fun boilWater() {
        println("물 끓이는 중")
    }

    private fun pourInCup() {
        println("컵에 따르는 중")
    }
}