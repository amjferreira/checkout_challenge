package Rules

import Products._

object ProductRules {


  val f1 = new PartialFunction[List[BaseProduct], Int] {
    override def isDefinedAt(products: List[BaseProduct]): Boolean = products != Nil

    override def apply(products: List[BaseProduct]): Int = {
      val count = products.count {
        case Hoodie() => true
        case _ => false
      }
      if (count >= 3) count * 100 else 0
    }
  }

  val f2 = new PartialFunction[List[BaseProduct], Int] {
    override def isDefinedAt(products: List[BaseProduct]): Boolean = products != Nil

    override def apply(products: List[BaseProduct]): Int = {
      val count = products.count {
        case _: Ticket => true
        case _ => false
      }
      (count / 2) * 500
    }
  }

  val ruleList = List(f1, f2)


}