abstract class Beverage {
    open val description: String = "제목 없음"
      get(): String = field

    abstract fun cost(): Double
}