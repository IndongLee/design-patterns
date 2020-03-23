package Behavior

class Quack : QuackBehavior {
    override fun quack() {
        println("꽥꽥!!")
    }
}

class Squack : QuackBehavior {
    override fun quack() {
        println("찍찍!")
    }
}

class MuteQuack : QuackBehavior {
    override fun quack() {
        println("...")
    }
}