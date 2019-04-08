import Checkout.Checkout
import Rules.ProductRules
import org.scalatest.FunSuite

class StoreTest extends FunSuite {


  test("test the discount with an even number of tickets") {
    val c = Checkout(ProductRules.ruleList)
    for (_ <- 1 to 4) {
      c.scan("TICKET")
    }
    assert(c.total === "10.00€")
  }

  test("test the discount with an odd number of tickets") {
    val c = Checkout(ProductRules.ruleList)
    for (_ <- 1 to 7) {
      c.scan("TICKET")
    }
    assert(c.total === "20.00€")
  }


  test("test empty checkout") {
    val c = Checkout(ProductRules.ruleList)
    assert(c.total.equals("0.00€"))
  }

  test("test the discount on hoodies") {
    val c = Checkout(ProductRules.ruleList)
    for (_ <- 1 to 4) {
      c.scan("HOODIE")
    }
    assert(c.total === "76.00€")
  }

  test("test hoodies without discount") {
    val c = Checkout(ProductRules.ruleList)
    c.scan("HOODIE")
    c.scan("HOODIE")

    assert(c.total === "40.00€")
  }
}


class TriggeriseExamplesTests extends FunSuite {

  test("first example") {
    val c = Checkout(ProductRules.ruleList)
    c.scan("HOODIE")
    c.scan("TICKET")
    c.scan("HAT")

    assert(c.total === "32.50€")
  }

  test("second example") {
    val c = Checkout(ProductRules.ruleList)
    c.scan("TICKET")
    c.scan("HOODIE")
    c.scan("TICKET")

    assert(c.total === "25.00€")
  }
  test("third example") {
    val c = Checkout(ProductRules.ruleList)
    c.scan("HOODIE")
    c.scan("HOODIE")
    c.scan("HOODIE")
    c.scan("TICKET")
    c.scan("HOODIE")

    assert(c.total === "81.00€")
  }
  test("forth example") {
    val c = Checkout(ProductRules.ruleList)
    c.scan("TICKET")
    c.scan("HOODIE")
    c.scan("TICKET")
    c.scan("TICKET")
    c.scan("HAT")
    c.scan("HOODIE")
    c.scan("HOODIE")

    assert(c.total === "74.50€")
  }

}
