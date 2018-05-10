package main.scala

object Function {
  def main(args: Array[String]): Unit = {
    val first = List(5, 3, 2, 1, 2)
    val second = List(2, 10, 4, 5, 13, 0, 6)
    val third = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 0), List(10, 11, 12), List(3, 7, 4))

    transform(first, second,(x: Int, y: Int) => x + y)
    transform(first, second,(x: Int, y: Int) => x - y)

    sum(first)
    sum(second)

    productRow(third)
  }

  def transform(first: List[Int], second: List[Int], f: (Int, Int) => Int): List[Int] = {
    val pair = (first, second)
    pair match {
      case (Nil, Nil) => Nil
      case cond if first == Nil => f(0, second.head) :: transform(first, second.tail, f)
      case cond if second == Nil => f(first.head, 0) :: transform(first.tail, second, f)
      case (_, _) => f(first.head, second.head) :: transform(first.tail, second.tail, f)
    }
  }

  def sum(list: List[Int]): Int = {
    list.foldRight(0)((x: Int, y: Int) => x + y)
  }

  def productRow(list: List[List[Int]]): List[Int] = {
    def product(row: List[Int]): Int = {
      def step(row: List[Int], count: Int): Int = {
        row match {
          case Nil => count
          case x :: xs => step(xs, x * count)
        }
      }
      step(row, 1)
    }

    val listIndex = list.zipWithIndex
    val evenList = listIndex.filter(_._2 % 2 == 0).map(_._1).map(product(_))
    evenList
  }
}
