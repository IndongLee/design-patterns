class ChocolateBoiler private constructor() {
    private var empty = true
    private var boiled = false

    companion object {
        private val uniqueInstance by lazy { ChocolateBoiler() }

        fun getInstance(): ChocolateBoiler {
            return uniqueInstance
        }
    }

    fun fill() {
        if (empty) {
            empty = false
            boiled = false
        }
    }

    fun drain() {
        if (!empty && boiled) {
            empty = true
        }
    }

    fun boil() {
        if (!empty && !boiled) {
            boiled = true
        }
    }
}