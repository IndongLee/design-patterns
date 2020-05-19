package adapter

import Duck
import Turkey

class TurkeyAdapter(val turkey: Turkey) : Duck {
    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        for (i in 1..5) {
            turkey.fly()
        }
    }
}