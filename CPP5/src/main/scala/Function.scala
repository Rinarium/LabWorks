package main.scala

import scala.annotation.tailrec

object Function {
  def main(args: Array[String]): Unit = {
    val array = Array[Double] (10.5, 5.12, 32.1, 245.3, 24.0, 42.23, 78.6, 100.2, 28.03)
    val number = 245.3

    findTail(number, array)
    find(number, array)

    sumFunTail((x: Int) => x * x * x, (x: Int) => 5 * x * x + 3 * x + 8, 5, 100)
    sumFunTail((x: Int) => x, (x: Int) => 5 * x , 5, 10)

    sumFun((x: Int) => x * x * x, (x: Int) => 5 * x * x + 3 * x + 8, 5, 100)
    sumFun((x: Int) => x, (x: Int) => 5 * x , 5, 10)

//    println(findTail(number, array))
//    println(find(number, array))
//
//    println(sumFunTail((x: Int) => x * x * x, (x: Int) => 5 * x * x + 3 * x + 8, 5, 100))
//    println(sumFun((x: Int) => x * x * x, (x: Int) => 5 * x * x + 3 * x + 8, 5, 100))
//
//    println(sumFunTail((x: Int) => x, (x: Int) => 5 * x , 5, 10))
//    println(sumFun((x: Int) => x, (x: Int) => 5 * x , 5, 10))
  }


  def sumFunTail(f: Int => Int, g: Int => Int, min: Int, max: Int) : Int = {
    def product(first : Int, second: Int) : Int = {
      first * second
    }

    @tailrec
    def sum(f: Int => Int, g: Int => Int, curr: Int, max: Int, acc: Int) : Int = {
      if (curr > max)
        acc
      else
        sum(f, g, curr + 1, max, acc + product(f(curr), g(curr)))
    }

    try {
      sum(f, g, min, max, 0)
    } catch {
      case _: ArithmeticException => -1
    }
  }


  def sumFun(f: Int => Int, g: Int => Int, min: Int, max: Int) : Int = {
    def product(first : Int, second: Int) : Int = {
      first * second
    }

    def sum(f: Int => Int, g: Int => Int, curr: Int, max: Int) : Int = {
      if (curr > max)
        0
      else
        product(f(curr), g(curr)) + sum(f, g, curr + 1, max)
    }

    try {
      sum(f, g, min, max)
    } catch {
      case _: ArithmeticException => -1
    }
  }


  def findTail(number: Double, array: Array[Double]) : Int = {
    @tailrec
    def compare(number: Double, array: Array[Double], size: Int) : Int = {
      if (size < 0)
        -1
      else if (number == array(size))
        size
      else
        compare(number, array, size - 1)
    }

    compare(number, array, array.length - 1)
  }

  def find(number: Double, array: Array[Double]) : Int = {
    def compare(number: Double, array: Array[Double], size: Int): Int = {
      if (size == array.length)
        -(array.length + 1)
      else if (number == array(size))
        0
      else
        1 + compare(number, array, size + 1)
    }


    compare(number, array, 0)
  }
}