import main.scala.Function
import org.scalatest._

class Tests extends FlatSpec with Matchers {
  val firstEmpty = List()
  val secondEmpty = List()
  val first = List(5, 6, 2, 0, 1)
  val second = List(10, 2, 5, 3, 4, 6)
  val third = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 0), List(10, 11, 12), List(3, 7, 4))


  it should "find sum by elements of two empty lists" in {
    Function.transform(firstEmpty, secondEmpty, (x: Int, y: Int) => x + y) should be (List())
  }

  it should "find difference by elements of two empty lists" in {
    Function.transform(firstEmpty, secondEmpty, (x: Int, y: Int) => x - y) should be (List())
  }

  it should "find sum by elements of two lists" in {
    Function.transform(first, second, (x: Int, y: Int) => x + y) should be (List(15, 8, 7, 3, 5, 6))
  }

  it should "find difference by elements of two lists" in {
    Function.transform(first, second, (x: Int, y: Int) => x - y) should be (List(-5, 4, -3, -3, -3, -6))
  }

  it should "find sum by elements of two lists where one is empty" in {
    Function.transform(first, secondEmpty, (x: Int, y: Int) => x + y) should be (List(5, 6, 2, 0, 1))
  }

  it should "find sum of all elements of the list" in {
    Function.sum(first) should be (14)
  }

  it should "find sum of all elements of the empty list" in {
    Function.sum(firstEmpty) should be (0)
  }

  it should "find sum of big elements of the list" in {
    Function.sum(List(Integer.MIN_VALUE, 1)) should be (Integer.MIN_VALUE + 1)
  }

  it should "find product of even lines of the list" in {
    Function.productRow(third) should be (List(6, 0, 84))
  }

  it should "find product of even lines of the empty list" in {
    Function.productRow(firstEmpty) should be (List())
  }

  it should "find product of even lines of list with two rows" in {
    Function.productRow(List(List(1, 5), List(2, 12))) should be (List(5))
  }

  it should "find product of even lines of list with zero elements" in {
    Function.productRow(List(List(0, 0), List(0, 0), List(0, 0, 0, 0))) should be (List(0, 0))
  }
}
