import pizza.Pizza

abstract class PizzaStore {
    fun orderPizza(type: String): Pizza? {
        return createPizza(type)?.apply {
            prepare()
            bake()
            cut()
            box()
        }
    }

    // 팩토리 역할을 하는 메소드
    abstract fun createPizza(type: String): Pizza?
}