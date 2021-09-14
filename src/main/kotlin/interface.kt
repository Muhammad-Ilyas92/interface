import java.util.*

fun main ()
{
    dragObject(arrayOf(Circle(4.0), Square(4.0), Triangle(2.0,3.0),Player("smile")))

}

fun dragObject (objects: Array<Draggable>) {    //is m hm n object bnaya or paramter mein object he rkha
    //is m polymorphism apply ho rha.q k reference hamara parent ka h or us m onject child class k hein
    //POLYMORPHISM : parent can hold a reference to its child and can call method of its child classes which are common
    //yahan common metho DRAG tha
    for(obj in objects)
    {
        obj.drag()
    }
}

// shape ki child class sbka behavior same h
// jb k player ki class ka behavior different h
//set of behavior define krne k lye k class m kn kn se behavior hongay to wo hm INTERFACE mein define krengay
//jin class m hamein wo behavior chaye hoga us class m hm wo interface m implement krengay
//aik bnday k different behavior hote hien , to hm different interface b bana skte hein
//is m y b hota h k hm classes ko group kr skte hein  based on their behavior
interface Draggable {
    fun drag()
}
//interface Cloneable {
//    fun clone()
//}




//Shape parent clas hai or bqi circle, square or triangle iski child class hein.. hm n drag ka function bnaya us k aray m Shape pass kr diya . q k inherit ho
// rha . or usse ka object bana k hm n main function m call b kr diya.........
// IS A relation h in m q k circle h to shape he

// abstract class Shape : Draggable, Cloneable {  //is trhan hm dusra interface b jaise cloneable or draggable

abstract class Shape : Draggable {
  //  fun area(): Double  //is p error a rha k area() function jo k empty h must be ABSTRACT, q k iski koi body nh hai
    abstract fun area(): Double
   // abstract fun drag() // Y DELETE KR DENGAY JB INTERFACE K LYE KAM KRENGAY
}

class Circle (val radius: Double) : Shape()
{
    override fun area(): Double = Math.PI * radius * radius
    override fun drag() = println("Circle is drag")
}

class Square (val side: Double) : Shape()
{
    override fun area(): Double = side * side
    override fun drag() = println("Square is drag")
}

class Triangle (val base: Double, val height: Double): Shape()
{
    override fun area(): Double = 0.5 * base * height
    override fun drag() = println("Triangle is drag")
}


class Player (val name: String): Draggable
{
    override fun drag() = println("$name is dragging " )
}