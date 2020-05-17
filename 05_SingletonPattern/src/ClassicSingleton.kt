class ClassicSingleton private constructor() {
    companion object {
        private var uniqueInstance: ClassicSingleton? = null

        fun getInstance(): ClassicSingleton {
            if (uniqueInstance == null) {
                uniqueInstance = ClassicSingleton()
            }

            return uniqueInstance!!
        }
    }
}