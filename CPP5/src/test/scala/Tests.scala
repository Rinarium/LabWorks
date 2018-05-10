import main.scala.Function
import org.scalatest._
//{FlatSpec, Matchers, Assertion}

class Tests extends FlatSpec with Matchers {
  val array = Array[Double] (10.5, 5.12, 32.1, 245.3, 24.0, 42.23, 78.6, 100.2, 28.03)

  it should "find index of element in list" in {
    Function.find(42.23, array) should be (5)
  }

  it should "find index of element in list by tailrec" in {
    Function.findTail(78.6, array) should be (6)
  }

  it should "find index of not-element in list" in {
    Function.find(0, array) should be (-1)
  }

  it should "find index of not-element in list by tailrec" in {
    Function.findTail(25, array) should be (-1)
  }

  val emptyArray = new Array[Double](0)

  it should "find index of element in empty list" in {
    Function.find(42.23, emptyArray) should be (-1)
  }

  it should "find index of element in empty list by tailrec" in {
    Function.findTail(5, emptyArray) should be (-1)
  }

  it should "sum elements of list" in {
    Function.sumFun((x: Int) => x, (x: Int) => 5 * x , 5, 10) should be (1775)
  }

  it should "sum elements of list by tailrec" in {
    Function.sumFunTail((x: Int) => x, (x: Int) => 5 * x , 5, 10) should be (1775)
  }

  it should "divide by zero counting sum" in {
    Function.sumFun((x: Int) => x * x, (x: Int) => 1/x , 0, 100) should be (-1)
  }

  it should "divide by zero counting sum by tailrec" in {
    Function.sumFunTail((x: Int) => 5 * x + 7 , (x: Int) => 1/x , 0, 100) should be (-1)
  }
}