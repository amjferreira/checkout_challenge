package Products

abstract class BaseProduct {
  //using an Int instead of a Double to avoid potential rounding problems
  val price: Int
}

object BaseProduct {
  def getProduct(product: String): BaseProduct = {

    product match {
      case "TICKET" =>  Ticket()
      case "HOODIE" =>  Hoodie()
      case "HAT" =>  Hat()
      case _ => throw new Exception(s"$product is not a valid product")
    }
  }
}


case class Ticket() extends BaseProduct {
  val price = 500
}

case class Hoodie() extends BaseProduct {
  val price = 2000
}

case class Hat() extends BaseProduct {
  val price = 750
}
