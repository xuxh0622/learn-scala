package com.scala.dev.Trait

/**
 * 通过接口处理重复代码
 */
class Point(val x:Int, val y:Int) {
  
}


trait Rectangular {
  def topLeft : Point
  def bottomRight : Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

class Rectangle(val topLeft:Point, val bottomRight:Point) extends Rectangular{

}


abstract class Component extends Rectangular{

}

object TestConsole {
  def main(args: Array[String]): Unit = {
    val rect = new Rectangle(new Point(1,1), new Point(10,10))
    println(rect.left)
  }
}