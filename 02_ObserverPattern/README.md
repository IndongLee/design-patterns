## Observer Pattern

#### 옵저버 패턴이란

- 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many) 의존성을 정의한다.
  - 데이터의 변경이 발생했을 경우 상대 클래스나 객체에 의존하지 않으면서 데이터 변경을 통보하고자 할 때 유용하다.

<br />

- 일대다 관계는 주제와 옵저버에 의해 정의된다. 
  - 옵저버는 주제에 의존한다. 
  - 주제의 상태가 바뀌면 옵저버에게 연락이 가며, 연락 방법에 따라 옵저버에 있는 값이 새로운 값으로 갱신될 수도 있다.

<br />

```kotlin
interface Subject {
    fun registerObject()
    
    fun removeObject()
    
    fun notifyObservers()
}

class ConcreteSubject() : Subject {
    override fun registerObject() {}
    
    override fun removeObject() {}
    
    override fun notifyObservers() {}
    
    // getter / setter
}
```

- 주제를 나타내는 Subject 인터페이스
  - 객체에서 옵저버를 등록하거나 옵저버 목록에서 탈퇴하고 싶을 때 이 인터페이스에 있는 메서드를 사용한다.
- 주제 역할을 하는 ConcreteSubject 구상 클래스
  - 등록 및 해지를 위한 메서드 외에 상태가 바뀔 때마다 모든 옵저버들에게 연락을 하기 위한 notifyObservers() 메서드도 구현해야 한다.
  - 주제 클래스에는 상태를 설정하고 알아내기 위한 게터, 세터 메서드가 있을 수도 있다.

<br />

```kotlin
interface Observer {
    fun update()
}

class ConcreteObserver() : Observer {
    override fun update() {}
}
```

- 옵저버를 나타내는 Observer 인터페이스
  - 옵저버가 될 가능성이 있는 객체에서는 반드시 Observer 인터페이스를 구현해야 한다.
  - 이 인터페이스에는 주제의 상태가 바뀌었을 때 호출되는 update() 메서드가 존재한다.
- 옵저버 역할을 하는 ConcreteObserver 클래스
  - 각 옵저버는 특정 주제 객체에 등록을 해서 연락을 받을 수 있다.

<br />

- 옵저버 패턴은 통보 대상 객체의 관리를 Subject 클래스와 Observer 인터페이스로 일반화한다.
  - 이를 통해 데이터 변경을 통보하는 클래스(ConcreteSubject)는 통보 대상 클래스나 객체(ConcreteObserver)에 대한 의존성을 없앨 수 있다.
  - 결과적으로 통보 대상 클래스나 대상 객체의 변경에도 통보하는 클래스(ConcreteSubject)를 수정 없이 그대로 사용할 수 있다.

<br />

#### 느슨한 결합(Loose Coupling)

옵저버 패턴에서는 주제와 옵저버가 `느슨하게 결합되어 있는 객체 디자인`을 제공한다. 느슨하게 결합되어 있다는 것은 "그 둘이 상호작용을 하긴 하지만 서로에 대해 잘 모른다는 것"을 의미한다.

<br />

- 주제가 옵저버에 대해서 아는 것은 옵저버가 특정 인터페이스(Observer 인터페이스)를 구현한다는 것 뿐이다.
- 옵저버는 언제든지 새로 추가할 수 있다.
- 새로운 형식의 옵저버를 추가하려고 할 때도 주제를 변경할 필요가 없다.
- 주제와 옵저버는 서로 독립적으로 재사용할 수 있다.
- 주제나 옵저버가 바뀌더라도 서로한테 영향을 미치지는 않는다.`

> "서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용해야 한다."

<br />

<br />

### 기상 관측값의 변경을 보여주는 디스플레이 구현 예시

---
##### 측정값 변경 메서드 구현하기

```kotlin
class subject.WeatherData {
    fun measurementsChanged() {
        val temp: Float = getTemperature()
        val humidity: Float = getHumidity()
        val pressure: Float = getPressure()
        
        currentConditionDisplay.update(temp, humidity, pressure)
        statisticsDisplay.update(temp, humidity, pressure)
        forecastDisplay.update(temp, humidity, pressure)
    }
}
```

- 구체적인 구현에 맞춰서 코딩했기 때문에 프로그램을 고치지 않고서는 다른 디스플레이 항목을 추가/제거할 수 없다.
- 디스플레이 부분은 바뀔 수 있기 때문에 캡슐화를 해야 할 것이다.

<br />

### 옵저버 패턴 적용하기

---

##### 인터페이스 작성

```kotlin
interface Subject {
    fun registerObserver(o: Observer)

    fun removeObserver(o: Observer)

    fun notifyObserver()
}

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}

interface DisplayElement {
    fun display()
}
```

<br />

##### subject 인터페이스 구현

```kotlin
class WeatherData : Subject {
    private val observers: ArrayList<Observer> = arrayListOf()
    private var temperature: Float = 0F
    private var humidity: Float = 0F
    private var pressure: Float = 0F

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        val index = observers.indexOf(o)
        if (index >= 0) observers.removeAt(index)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(temperature, humidity, pressure) }
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    fun setTemperature(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}
```

<br />

##### Observer 인터페이스 구현

```kotlin
class CurrentConditionsDisplay(private val weatherData: Subject) : Observer, DisplayElement {
    private var temperature: Float = 0F
    private var humidity: Float = 0F

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }

    override fun display() {
        println("Current conditions: ${temperature}F degrees and ${humidity}% humidity")
    }
}
```

<br />

<br />

### 디자인 원칙 적용

---

##### 애플리케이션에서 달라지는 부분을 찾아 달라지지 않는 부분으로부터 분리(캡슐화)한다.

- Duck 클래스에서 달라지는 부분은 fly()와 quack()이다.
- 이러한 행동을 Duck 클래스로부터 갈라내기 위해서 두 메서드를 모두 Duck 클래스로부터 끄집어내서 각 행동을 나타낼 클래스 집합을 새로 만든다.

<br />

##### 구현이 아닌 인터페이스에 맞춰서 프로그래밍 한다.

- 각 행동은 인터페이스로 표현하고, 행동을 구현할 때 이런 인터페이스를 구현한다.
- Duck의 서브 클래스에서는 인터페이스로 표현되는 행동을 하게 된다.
- 따라서 행동을 실제로 구현한 것은 Duck 서브 클래스에 국한되지 않는다.
- 실제 실행 시에 쓰이는 객체가 코드에 의해서 고정되지 않도록, `상위 형식(supertype)에 맞춰서 프로그래밍`함으로써 다형성을 활용하는 것이 핵심이다.

> *"`상위 형식에 맞춰서 프로그래밍 하라 `"는 말은 "변수를 선언할 때는 추상 클래스나 인터페이스 같은 상위 형식으로 선언해야 한다. 객체를 변수에 대입할 때 상위 형식을 구체적으로 구현한 형식이라면 어떤 객체든 집어넣을 수 있기 때문이다. 그렇게 하면 변수를 선언하는 클래스에서 실제 객체의 형식을 몰라도 된다."는 뜻과 같다.*

```kotlin
// 구현에 맞춘 프로그래밍
val d: Dog = Dog()
d.bark()

// 인터페이스/상위 형식에 맞춘 프로그래밍
val animal: Animal = Dog()
animal.makeSound()

// 구체적으로 구현된 객체를 실행 시에 대입하는 프로그래밍
val a = getAnimal()
a.makeSound()
```

<br />

##### 위 원칙들을 적용하여 Duck의 행동을 구현한다.

```kotlin
interface FlyBehavior {
    fun fly()
}

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
```

```kotlin
interface QuackBehavior {
    fun quack()
}

class Quack() : QuackBehavior {
    override fun quack() {
        println("꽥꽥!!")
    }
}

class Squack() : QuackBehavior {
    override fun quack() {
        println("찍찍!")
    }
}

class MuteQuack() : QuackBehavior {
    override fun quack() {
        println("...")
    }
}
```

- 이런 식으로 디자인하면 다른 형식의 객체에서도 나는 행동과 꽥꽥거리는 행동을 재사용할 수 있다. 이러한 행동이 더 이상 Duck 클래스 안에 숨겨져 있지 않기 때문이다.
- 기존 행동 클래스를 수정하거나, Duck 클래스를 전혀 건드리는 일 없이 새로운 행동을 추가할 수 있다.

<br />

<br />

### Duck 행동 통합하기

---

이제 Duck에서 나는 행동과 소리를 내는 행동을 Duck 클래스(또는 그 서브 클래스)에서 정의한 메서드를 써서 구현하지 않고 다른 클래스에 `위임`한다.

```kotlin
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
```

- Duck 클래스에 flyBehavior와 quackBehavior라는 두 개의 인터페이스 형식의 인스턴스 변수를 추가한다. 각 오리 객체는 실행 시에 이 변수에 특정 행동 양식에 대한 레퍼런스를 다형적으로 설정한다.

<br />

##### 상속보다는 구성을 활용한다.

- `A에는 B가 있다.` : 각 오리에는 FlyBehavior와 QuackBehavior가 있으며, 각각 행동을 위임받는다.
- 두 클래스를 이런 식으로 합치는 것을 `구성`을 이용하는 것이라 부른다. 오리 클래스에서는 행동을 상속받는 대신 올바른 행동 객체로 구성됨으로써 행동을 위임받게 된다.