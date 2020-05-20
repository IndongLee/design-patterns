class Tea : CaffeineBeverage() {
    override fun brew() {
        println("필터를 통해서 홍차 우려내는 중.")
    }

    override fun addCondiments() {
        println("레몬을 추가하는 중")
    }
}