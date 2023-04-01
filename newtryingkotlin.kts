// https://developer.android.com/kotlin/learn
// https://kotlinlang.org
// https://khan.github.io/kotlin-for-python-developers

// Code tested as is at https://play.kotlinlang.org/

fun main() {
    
	// Hello World

	println("Hello, world!")

	// val, var and const

	// const can only be used at the top level of a file or inside an object declaration (but not inside a class declaration):
	// const val g = 9.81 // acceleration due to gravity
	// val is a constant variable that cannot be assigned multiple times (immutable)

	val x = 5

	var y = 6

	// Inference of type

	// We can assign types but Kotlin can also infer the types
	var count: Int = 1
	var count1 = 5

	val languageName: String = "Kotlin"
	val languageName1 = "Kotlin"

    println("** uppercase demo")
	val upperCaseName = languageName1.uppercase()
	println(upperCaseName)
    
    // String interpolation

	// You can use string interpolation with $ and use curly braces for expressions evaluation
	println("** String interpolation demo")
	val name = "Anne"
	val yearOfBirth = 1985
	val yearNow = 2023
	val message = "$name is ${yearNow - yearOfBirth} years old"
    
    println(message)
   
	// Null safety

	var languageName2: String? = null
	languageName2 = null // languageName2 can be set to null
    
    var languageName3: String = "abc"
	//languageName3 = null // languageName3 cannot be set to null, compilation error
	// var languageName4: String = null // compilation error too

	// Conditionals

    println("** Conditionals demo")
    
	// if else
	println("** ifelse")
	if (count == 42) {
    	println("I have the answer.")
	} else {
    	println("The answer eludes me.")
	}

	// assignment with if else
	println("** Assignment with if else")
	val answerString: String = if (count == 42) {
    		"I have the answer."
		} else if (count > 35) {
    		"The answer is close to the correct answer."
		} else {
    		"The answer eludes me."
		}
	println(answerString)

	// assignment with when
	println("** Assignment with when")
	val answerString1 = when {
    	count == 42 -> "I have the answer."
    	count > 35 -> "The answer is close."
    	else -> "The answer eludes me."
	}
	println(answerString1)
    
	// Functions

    println("** Functions")
    
    println("sum demo")
    
    // With return
	fun sum(a: Int, b: Int): Int {
    	return a + b
	}
	println(sum(1, 5))

    // Without return but with =
	fun sum1(a: Int, b: Int): Int = a + b
	println(sum1(1, 7))

    println("square demo")
	fun square(number: Int) = number * number
    println(square(10))

	// 1 No parameters, with return
	println("** generateAnswerString demo 1")
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

	// 2 same function name, with a parameter and return
	// function overloading
	println("** generateAnswerString demo 2")
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
	println("** generateAnswerString1 demo")
	fun generateAnswerString1(countThreshold: Int): String {
    	return if (count > countThreshold) {
        	"I have the answer."
    	} else {
        	"The answer eludes me."
    	}
	}

	val answerString4 = generateAnswerString1(42)
	println(answerString4)

	// 4 Simplification without return and with =
	println("** generateAnswerString2 demo")
	fun generateAnswerString2(countThreshold: Int): String = 
    	if (count > countThreshold) {
    		"I have the answer"
		} else {
    		"The answer eludes me"
		}

	val answerString5 = generateAnswerString2(42)
	println(answerString5)

	// Optional parameters
	// count and separator are optional
	// count has a default value
	println("** showOptional demo")
	fun showOptional(str: String, count: Int = 3, separator: String = "!") {
    	println("Hello " + str + " " + count + " " + separator)
	}
	showOptional("John")
	showOptional("Bill", 5)
    showOptional("Bill", 5, ".")
    showOptional("Bill", separator=";")

	// Anonymous functions

    println("** Anonymous function demo")
	val stringLengthFunc: (String) -> Int = 
    	{ input -> input.length}

	val stringLength: Int = stringLengthFunc("Android")
	println("Android has " + stringLength + " characters")

	// Higher order function - function that takes a function as a parameter - here mapper

	// callAndPrint

	fun callAndPrint(myfunction: (Int, Int) -> Int) {
    	println("callAndPrint ${myfunction(2, 0)}")
	}

	callAndPrint({x,y -> x + y + 5})
    
    // stringMapper

    println("** stringMapper demo")
    
    fun stringMapper(str: String, mapper: (String) -> Int): Int {
    	// Invoke function
    	return mapper(str)
	}

	// 1 calling stringMapper - 1 parameter that is a pair
	println("Android is so so!")
	val sm1 = stringMapper("Android is so so!", {input -> input.length})
	println(sm1)
   
    // 1a with 1 paramater and a function returning 5
   	val sm1a = stringMapper("Android is so so!", {input -> 5})
   	println(sm1a)

	// 2 calling stringMapper - 2 parameters - curried function
	println("Android is great!")
	val sm2 = stringMapper("Android is great!!!!"){ input -> input.length }
	println(sm2)
    
    // Collections

    println("** Collections demo")
	
    // Immutables
    
    // Generics
	
    val listNames = listOf("Anne", "Karen", "Peter") 		// List<String>
	val mapLetters = mapOf("a" to 1, "b" to 2, "c" to 3)  	// Map<String, Int>
	val setLetters = setOf("a", "b", "c")                 	// Set<String>

	println(listNames)
	println(mapLetters)
	println(setLetters)
    
	// Mutables

	val listNamesMutable = mutableListOf("Anne", "Karen", "Peter")
	val mapLettersMutable = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
	val setLettersMutable = mutableSetOf("a", "b", "c")

    println(listNamesMutable)
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

    println("** Loops demo")
    
    println("Loop 1")
	for (x in 0..10) println(x) // Prints 0 through 10 (inclusive)

    println("Loop 2")
	for (x in 0 until 10) println(x) // Prints 0 through 9

    println("Loop 3")
	for (x in 0 until 10 step 2) println(x) // Prints 0, 2, 4, 6, 8

	val numbers = (0..9).toList()

	// Iterate over the entries as separate key and value objects
	// Shows pattern matching
	// Tuple unpacking
	println("Loop 4")
	val mapStates = mutableMapOf(1 to "NY", 2 to "NJ")
	for ((key, value) in mapStates) {
    	println("$key: $value")
	}
   
   // Vararg

   println("** vararg demo")
   fun countAndPrintArgs(vararg numbers: Int) {
       println(numbers.size)
       for (number in numbers) println(number)
   }

   println("vararg 1")
   countAndPrintArgs(1, 2)
   println("vararg 2")
   countAndPrintArgs(1, 5, 19, 13)
   
   // Map

   println("** map demo")
   
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

   	println("** Classes demo")
   
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

	println("Object person: " + p)

	// Person with a constructor and initializer block

	class Person1(firstName: String, lastName: String, yearOfBirth: Int) {
    	val fullName = "$firstName $lastName"
    	var age: Int

    	init {
        	age = 2023 - yearOfBirth
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
	val c = Person2(1995, "Lynne")
    
    // Inheritance
    // class Derived: Base
    // An open class is extentadable in Kotlin. open instances and functions carn be overriden
    
    open class Shape {
    	open val vertexCount: Int = 0
	}

	class Rectangle : Shape() {
    	override val vertexCount = 4
	}

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

    println("** Generics demo")
	class ListNode<T>(val value: T?, val next: ListNode<T>? = null){
    	fun firstNode():T? {
        	return value
    	}
	}

	val t1 = ListNode<Int>(6, null)
	val t = ListNode<Int>(5, t1)
	println(t.firstNode())
}
