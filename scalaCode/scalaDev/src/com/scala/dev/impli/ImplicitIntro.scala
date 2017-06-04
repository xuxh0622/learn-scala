package com.scala.dev.impli

object ImplicitIntro {
  implicit def intToString(x:Int) : String = x.toString()
  
  implicit def doubleToInt(x:Double) = x toInt
 
  def main(args: Array[String]): Unit = {
    //因为implicit转换才能赋值
    val i:Int = 3.5
  }
}

 