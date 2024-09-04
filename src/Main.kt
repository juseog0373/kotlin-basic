import java.util.Scanner
import javax.security.auth.callback.Callback
import kotlin.math.max
import kotlin.random.Random

//TIP Press <shortcut raw="SHIFT"/> twice to open the Search Everywhere dialog and type <b>show whitespaces</b>,
// then press <shortcut raw="ENTER"/>. You can now see whitespace characters in your code.
fun main() {
    val i : Int = 10
    var l = 20L
    var name: String = "준석"
    var point = 3.3

    // 상수 = final
    val num = 20
    l = i.toLong()

    println("제 이름은 ${name + l} 입니다")

    var j = 20
    println("$i,$j 중 큰 숫자는 ${max(i, j)}입니다")

    // 0~99 from: 포함 until: 미포함
    val random = Random.nextInt(0, 100)
    println(random)

    // 스캐너 사용법
    var reader = Scanner(System.`in`)
    reader.nextInt()
    reader.next()

    var num1 = 5
    var result = when {
        i > 10 -> {
            println("10보다 크다")
        }
        i < 5 -> {
            println("5보다 작다")
        }
        else -> {
            println("")
        }
    }

    // boolean result = i > 10 ? true : false;
    var num2 = 5
    val result1 = if (i>10) true else false

    var items = mutableListOf(1,2,3,4,5)
    items.forEach { item ->
        println(item)
    }

    // for (int i = 0; i < items.length; i++)
    for (i in 0..items.size-1) {
        println(items[i])
    }

    items.add(6)
    items.remove(3)
    items.removeAt(1)

    // 배열 (자주 사용하진 않음. list 를 사용해라)
    val array = arrayOf(1,2,3)

    // null safety

    var name1 : String? = null
    name1 = "준석"
    name1 = null

    var name2: String = ""

    name2 = name1.toString()
    println(name2)

    val sum = sum(1, 2, 40)
    println(sum)

    val kim = Person("kim", 20)
    val kim2 = Person("kim", 20)
    println(kim == kim2)

    val box = Box(10)
    val box2 = Box("string")
    println(box.value)

    // 코루틴 안에서 동작해야함
    // 멀티 쓰레딩 문제를 간소화된 비동기 작업 방식
    // 코루틴이 시작된 스레드를 중단하지 않으면서 비동기적으로 실행되는 코드
    // 비동기: 여러개의 작업을 동시에 하는 것
    myFunc(10) {
        println("함수 호출")
    }
}

// 함수 작성 a,b: Int 반환 타입: Int
fun sum(a: Int, b: Int) = a + b
// 일반적인 오버로딩(자바기준)
// fun sum(a: Int, b: Int, c: Int) = a + b + c
// 코틀린의 오버로딩
fun sum(a: Int, b: Int, c: Int = 0) = a + b + c

data class Person(
    val name: String,
    var age: Int,
) {
    var hobby = "축구"
        // private setter
        private set
        // getter 는 $field 키워드를 통해 반환한다
        get() = "취미 : $field"

    fun some() {
        hobby = "농구"
    }
}

// 추상 클래스가 아닌 일반 클래스는 open 키워드를 붙혀야 상속이 가능하다.
// 자바는 열려있지만, 코틀린은 반대로 모든 것이 다 닫혀있다.
open class Person1
class SuperMan : Person1() {
}

// 인터페이스 생성
interface Drawable {
    fun draw()
}

// 추상 클래스는 open 키워드 없이 abstract 키워드만으로도 상속이 가능하다
abstract class Animal() {
    // 메서드 오버라이딩을 할 경우 open을 해둬야 열린다.
    open fun move() {
        println("이동")
    }
}

// 인터페이스 상속 ',' 키워드로 상속받는다
class Dog : Animal(), Drawable {
    override fun move() {
        println("껑충")
    }

    // 인터페이스에 정의된 메서드는 무조건 오버라이딩을 해야 에러가 안난다
    override fun draw() {
        TODO("Not yet implemented")
    }
}

// 제네릭
class Box<T>(var value: T)

// 콜백함수
suspend fun myFunc(a: Int, callback: () -> Unit) {
    println("$a 함수 시작!")
    callback()
    println("$a 함수 끝!")
}



