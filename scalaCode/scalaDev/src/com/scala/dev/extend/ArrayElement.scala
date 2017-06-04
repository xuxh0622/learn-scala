package com.scala.dev.extend
/**
 * 继承所有父类的非私有成员
 * 建立父子类关系
 * conts为参数化成员变量，可用override、private、protected修饰
 */
class ArrayElement(private val conts: Array[String]) extends Element {
  //成员变量实现基类中不带参数的抽象函数
  val contents: Array[String] = conts
  
  //final修饰不希望成员被子类重载
  final override def demo(){
    println("ArrayElement")
  }
}