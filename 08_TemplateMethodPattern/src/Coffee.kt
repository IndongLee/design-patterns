class Coffee : CaffeineBeverage() {
    override fun brew() {
        println("필터를 통해서 커피 우려내는 중")
    }

    override fun addCondiments() {
        println("설탕과 우유를 추가하는 중")
    }
}