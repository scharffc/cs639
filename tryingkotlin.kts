// https://developer.android.com/kotlin/learn
// https://kotlinlang.org
// https://khan.github.io/kotlin-for-python-developers

// Hello World

println("Hello, world!")

// Val, var and const

// const can only be used at at the top level of a file or inside an object declaration (but not inside a class declaration):
// const val g = 9.81 // acceleration due to gravity

val x = 5

var y = 6

// Inference of type

var count: Int = 10
count = 15

val languageName: String = "Kotlin"

// No need to write the type of languageName1
val languageName1 = "Kotlin"
val upperCaseName = languageName1.toUpperCase()
println(upperCaseName)

// String interpolation

// You can do string interpolation with $, and use curly braces for expressions:
val name = "Anne"
val yearOfBirth = 1985
val yearNow = 2018
val message = "$name is ${yearNow - yearOfBirth} years old"

// Null safety

var languageName2: String? = null
languageName2 = null

// Conditionals

// if else
if (count == 42) {
    println("I have the answer.")
} else {
    println("The answer eludes me.")
}

// assignment with if else
val answerString: String = if (count == 42) {
    "I have the answer."
} else if (count > 35) {
    "The answer is close."
} else {
    "The answer eludes me."
}
println(answerString)

// assignment with when
val answerString1 = when {
    count == 42 -> "I have the answer."
    count > 35 -> "The answer is close."
    else -> "The answer eludes me."
}
println(answerString1)

// Functions

fun sum(a: Int, b: Int): Int {
    return a + b
}
println(sum(1, 5))

fun sum1(a: Int, b: Int): Int = a + b
println(sum1(1, 7))

fun square(number: Int) = number * number

// 1
fun generateAnswerString(): String {
    val answerString = if (count == 42) {
        "I have the answer."
    } else {
        "The answer eludes me"
    }
    return answerString
}

val answerString2 = generateAnswerString()
println(answerString2)

// 2 with a parameter
fun generateAnswerString(countThreshold: Int): String {
    val answerString = if (count > countThreshold) {
        "I have the answer."
    } else {
        "The answer eludes me."
    }
    return answerString
}

val answerString3 = generateAnswerString(42)
println(answerString3)

// 3 Simplifying by using return directly
fun generateAnswerString1(countThreshold: Int): String {
    return if (count > countThreshold) {
        "I have the answer."
    } else {
        "The answer eludes me."
    }
}

val answerString4 = generateAnswerString1(42)
println(answerString4)

// 4 Simplification without return
fun generateAnswerString2(countThreshold: Int): String = if (count > countThreshold) {
    "I have the answer"
} else {
    "The answer eludes me"
}

val answerString5 = generateAnswerString2(42)
println(answerString5)

// Optional parameters
// count and separator are optional
// count has a default value
// They are required to be used in the function
fun showOptional(str: String, count: Int = 3, separator: String = "!") {
    println("Hello " + str + " " + count + " " + separator)
}
showOptional("John")
showOptional("Bill", 5)

// Anonymous functions

val stringLengthFunc: (String) -> Int = { input ->
    input.length
}
val stringLength: Int = stringLengthFunc("Android")
println("Android has " + stringLength + " characters")

// Higher order function - function that takes a function as a parameter - here mapper

// callAndPrint

fun callAndPrint(function: (Int, Int) -> Int) {
    println("callAndPrint ${function(2, 0)}")
}

callAndPrint({x,y -> x+y + 5})

// stringMapper

fun stringMapper(str: String, mapper: (String) -> Int): Int {
    // Invoke function
    return mapper(str)
}

// 1 calling stringMapper - 1 parameter that is a pair
println("Android is so so!")
val sm1 = stringMapper("Android is so so!", {input -> input.length})
println(sm1)

// 2 calling stringMapper - 2 parameters
println("Android is great!")
val sm2 = stringMapper("Android is great!!!!") { input ->
    input.length
}
println(sm2)

// Collections

// Immutables

val listNames = listOf("Anne", "Karen", "Peter") // List<String>
val mapLetters = mapOf("a" to 1, "b" to 2, "c" to 3)  // Map<String, Int>
val setLetters = setOf("a", "b", "c")                 // Set<String>

println(listNames)
println(mapLetters)
println(setLetters)

// Mutables

val listNamesMutable = mutableListOf("Anne", "Karen", "Peter")
val mapLettersMutable = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
val setLettersMutable = mutableSetOf("a", "b", "c")

listNamesMutable.add("Vidya")
println(listNamesMutable)

// Different types in a list

val mixed = listOf("a", 2, 3.14)               // List<Any>
val mixedWithNull = listOf("a", 2, 3.14, null) // List<Any?>

// Empty collections
// Need to put the type explicitely

val noInts: List<Int> = listOf()
val noStrings = listOf<String>()
val emptyMap = mapOf<String, Int>()

// Loops

for (x in 0..10) println(x) // Prints 0 through 10 (inclusive)

for (x in 0 until 10) println(x) // Prints 0 through 9

for (x in 0 until 10 step 2) println(x) // Prints 0, 2, 4, 6, 8

val numbers = (0..9).toList()

// Iterate over the entries as separate key and value objects
// Shows pattern matching
val mapStates = mutableMapOf(1 to "NY", 2 to "NJ")
for ((key, value) in mapStates) {
    println("$key: $value")
}

// Vararg

fun countAndPrintArgs(vararg numbers: Int) {
    println(numbers.size)
    for (number in numbers) println(number)
}
countAndPrintArgs(1, 2)
countAndPrintArgs(1, 5, 19, 13)

// Map

val myNumbers = setOf(1, 2, 3)
println(myNumbers)

// map applies the same function to all elements of the set
println(myNumbers.map { it * 3 })

// mapIndexed in addition uses the index of the elements in the set
println(myNumbers.mapIndexed { idx, value -> value * idx })

val peopleToAge = mapOf("Alice" to 20, "Bob" to 21)
println(peopleToAge.map { (name, age) -> "$name is $age years old" }) // [Alice is 20 years old, Bob is 21 years old]
println(peopleToAge.map { it.value }) // [20, 21]

// Classes

// Person

// The type of a property must be explicitly specified
// Declaring a property directly inside the class does not create a class-level property, but an instance-level one:
// Every instance of Person will have its own name and age
// Their values will start out in every instance as "Anne" and 32, respectively, but the value in each instance
// can be modified independently of the others:

class Person {
    var name = "Anne"
    var age = 32

    // equals, toString, hasCode are built-in functions
    override fun toString(): String {
        return name + " " + age
    }
}

val p = Person()
p.age = 23

println(p.age)

println(p)

// Person with a constructor and initializer block

class Person1(firstName: String, lastName: String, yearOfBirth: Int) {
    val fullName = "$firstName $lastName"
    var age: Int

    init {
        age = 2021 - yearOfBirth
    }
}

val p1 = Person1("Vidya", "Jones", 2000 )
println("p1 ${p1.fullName} ${p1.age} ")

// Person with different constructors

class Person2(val name: String, var age: Int) {
    constructor(name: String) : this(name, 0)
    constructor(yearOfBirth: Int, name: String)
            : this(name, 2018 - yearOfBirth)

    // adding a member function
    fun beOver18():Boolean{
        return age > 18
    }

    // another one
    fun greet(other: Person) = println("Hello, ${other.name}, I'm $name!")

}

val a = Person2("Jaime", 20)
println(a.beOver18().toString())
val b = Person2("Jack") // age = 0
val c = Person2(1995, "Lynne") // age = 23

// Car

class Wheel{
    var brand: String = "MyBrand";
}

class Car {
    var wheels = listOf<Wheel>()
}

val w1 = Wheel()
val w2 = Wheel()

val wl = listOf(w1,w2)

val car = Car() // construct a Car
car.wheels = wl

val wheels = car.wheels // retrieve the wheels value from the Car

println(wheels.size)

class Car1(val wheels: List<Wheel>) {
    var doorLock: Boolean = true;

    fun unlockDoor() {
        doorLock = false;
    }
}

val c1 = Car1(wl)
println(c1.doorLock)
c1.unlockDoor()
println(c1.doorLock)

// Generics

class TreeNode<T>(val value: T?, val next: TreeNode<T>? = null){
    fun firstNode():T? {
        return value
    }
}

val t1 = TreeNode<Int>(6, null)
val t = TreeNode<Int>(5, t1)
println(t.firstNode())



