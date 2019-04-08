import Rules.ProductRules
import Checkout.Checkout

object Store extends App {

  val c = Checkout(ProductRules.ruleList)

  c.scan("TICKET")
  c.scan("TICKET")
  c.scan("HOODIE")
  c.scan("HOODIE")
  c.scan("HOODIE")

  println(s"Total: ${c.total}")


}
