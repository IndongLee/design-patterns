package Behavior

class FlyWithWings : FlyBehavior {
    override fun fly() {
        println("날개로 날아다닙니다.")
    }
}

class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("날 수 없습니다.")
    }
}