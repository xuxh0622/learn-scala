package com.scala.think.traitintro

object TestTraint {
  def main(args: Array[String]): Unit = {
    val rect = new Rectangle(new Point(1,1),new Point(10,10))
    println(rect.left)
  }
}