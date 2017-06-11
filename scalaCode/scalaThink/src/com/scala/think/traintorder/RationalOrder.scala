package com.scala.think.traintorder
/**混入Ordered特质
 * 
 */
class RationalOrder(n:Int, d:Int) extends Ordered[RationalOrder]{
  
  val number = n
  
  val denom = d
  
  //负数小于，0等于，正数大于
  def compare(that: RationalOrder) = 
    this.number * that.denom - that.number * this.denom
}

object TestRationalOrder{
  def main(args: Array[String]): Unit = {
    val half = new RationalOrder(1,2)
    val third = new RationalOrder(1,3)
    println(half < third)
  }
}