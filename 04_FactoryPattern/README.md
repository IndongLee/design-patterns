## Factory Pattern

#### 팩토리 패턴이란

- 

### 피자 가게 구현 예시

---
```kotlin
class PizzaStore() {
    fun orderPizza(type: String): Pizza? {
        // 바뀌는 부분
        val pizza = when(type) {
            "cheese" -> CheesePizza()
            "greek" -> GreekPizza()
            "pepperoni" -> PepperoniPizza()
            else -> null
        }

        // 바뀌지 않는 부분
        return pizza?.apply {
            prepare()
            bake()
            cut()
            box()
        }
    }
}
```

- 피자 가게에서 신제품을 출시하거나 메뉴가 사라진다면 바뀔 때마다 메소드가 변경되어야 한다. 인스턴스를 만드는 구상 클래스 부분이 가장 문제가 된다.

<br />

##### 간단한 팩토리 : 피자(객체)를 생성하는 일만 처리하는 객체(팩토리)를 만들어 분리하기.

```kotlin
class SimplePizzaFactory() {
    fun createPizza(type: String): Pizza? {
        return when(type) {
            "cheese" -> CheesePizza()
            "greek" -> GreekPizza()
            "pepperoni" -> PepperoniPizza()
            else -> null
        }
    }
}

class PizzaStore(val factory: SimplePizzaFactory) {
    fun orderPizza(type: String): Pizza? {
        return factory.createPizza(type)?.apply {
            prepare()
            bake()
            cut()
            box()
        }
    }
}
```

- 피자를 생성하는 작업을 한 클래스에 캡슐화시켜 놓으면 구현을 변경해야 하는 경우에 여기저기 다 들어가서 고칠 필요 없이 이 팩토리 클래스 하나만 고치면 된다.
-  PizzaStore의 생성자에 팩토리 객체를 전달해 팩토리에서 피자 객체를 생성하도록 한다. 이제 더 이상 구상 클래스의 인스턴스를 만들 필요가 없다.

<br />

<br />

### 팩토리 메소드 패턴

##### 피자 사업이 커져 프랜차이즈가 된다면...?

```kotlin

```

<br />

##### 

```kotlin

```

<br />

##### 

```kotlin

```

