package Checkout

import Products.BaseProduct

case class Checkout(rules: List[List[BaseProduct] => Int]) {
  private var productList = List[BaseProduct]()

  def scan(product: String): Unit = {

    val p = BaseProduct.getProduct(product)
    productList = p :: productList
  }


  def total: String = {
    val bulkTotal = productList.map(_.price).sum
    val discount = rules.map(_(productList)).sum
    val finalPrice = bulkTotal - discount

    formatPrice(finalPrice)
  }

  def formatPrice(total: Int): String = {
    var originalTotal = total.toString

    while (originalTotal.length < 3) {
      originalTotal = '0' + originalTotal
    }
    val decimalSpot = originalTotal.length - 2


    originalTotal.substring(0, decimalSpot) + '.' + originalTotal.substring(decimalSpot) + '€'
  }
}
