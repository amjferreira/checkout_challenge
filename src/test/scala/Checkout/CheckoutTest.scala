package Checkout

import org.scalatest.FunSuite

class CheckoutTest extends FunSuite {

  test("format normal checkout value") {
    val checkout = Checkout(Nil)
    assert(checkout.formatPrice(500) === "5.00€")
  }

  test("format a low value checkout ") {
    val checkout = Checkout(Nil)
    assert(checkout.formatPrice(10) === "0.10€")
  }

  test("format 0 checkout") {
    val checkout = Checkout(Nil)
    assert(checkout.formatPrice(0) === "0.00€")
  }


}
