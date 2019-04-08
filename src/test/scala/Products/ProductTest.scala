package Products

import org.scalatest.FunSuite

class ProductTest extends FunSuite {

  test("get hoodie class") {
    val hoodie = BaseProduct.getProduct("HOODIE")

    assert(hoodie.equals(Hoodie()))

  }
  test("get ticket class") {
    val ticket = BaseProduct.getProduct("TICKET")

    assert(ticket.equals(Ticket()))

  }
  test("get hat class") {
    val hat = BaseProduct.getProduct("HAT")
    assert(hat.equals(Hat()))
  }

  test("no product for that string") {

    val thrown = intercept[Exception] {
      BaseProduct.getProduct("test")
    }
    assert(thrown.getMessage === "test is not a valid product")
  }

  test("lower case product name") {

    val thrown = intercept[Exception] {
      BaseProduct.getProduct("hat")
    }
    assert(thrown.getMessage === "hat is not a valid product")
  }


  test("test hoodie price") {

    val hoodie = Hoodie()
    assert(hoodie.price === 2000)

  }

  test("test hat price") {

    val hat = Hat()
    assert(hat.price === 750)

  }

  test("test ticket price") {

    val ticket = Ticket()

    assert(ticket.price === 500)

  }
}
