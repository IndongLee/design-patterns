import Behavior.FlyBehavior
import Behavior.FlyWithWings
import Behavior.Quack
import Behavior.QuackBehavior

abstract class Duck {
    abstract val quackBehavior: QuackBehavior
    abstract val flyBehavior: FlyBehavior

    fun swim() {}

    abstract fun display()

    fun performQuack() {
        quackBehavior.quack()
    }

    fun performFly() {
        flyBehavior.fly()
    }

}

class MallardDuck() : Duck() {
    override val quackBehavior: QuackBehavior = Quack()
    override val flyBehavior: FlyBehavior = FlyWithWings()

    override fun display() {
        println("저는 물오리입니다.")
    }
}