package main.scala

object Main {
  def main(args: Array[String]): Unit = {
    val list = List(10, 1, 5, 8, -8, 15, -3)
    println(sumProd(list))
//
//    val rect = Rectangle(10, 20)
//    val parall = Parallelepiped(10, 20, 30)

    //println(rect.unapply())
    //println(parall.unapply())
    //println(area(rect))
   // println(area(parall))
    println(list.partition((x: Int) => x > 2))
  }

  def sumProd(list: List[Int]): (Int, Int) = {
    def op(ints: List[Int]): Int = {
      ints match {
        case x::_ if x < 0 => ints.foldRight(1)((x: Int, y: Int) => x * y)
        case _ => ints.foldRight(0)((x: Int, y: Int) => x + y)
      }
    }
    val divided = list.partition(x => x < 0)
    (op(divided._1), op(divided._2))
  }

//  abstract class Figure(val first: Int, val second: Int, val third: Int = 0) {
//    def unapply(): (Int, Int, Int) = (first, second, third)
//  }
//
//  case class Rectangle(override val first: Int, override val second: Int) extends Figure(first, second) {
//    override def unapply(): (Int, Int) = (first, second)
//  }
//
//  case class Parallelepiped(override val first: Int, override val second: Int, override val third: Int) extends Figure(first, second)
//
//  def area(fig: Figure): Int = {
//    fig match {
//      case Rectangle(x, y) => x * y
//      case Parallelepiped(x, y, z) => x * y * z
//    }
//  }
}
