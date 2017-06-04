package com.scala.dev.extend

class LineElement(s:String) extends ArrayElement(Array(s)) {
  //使用override修饰重载父类的非抽象成员，抽象成员无需修饰
  override def width = s.length
  
  override def height = 1
}