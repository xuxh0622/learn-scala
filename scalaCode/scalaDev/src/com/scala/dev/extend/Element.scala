package com.scala.dev.extend

/**
 * 含有抽象方法的类必须定义为抽象类，abstract定义
 * 不能构建抽象类的实例
 */
abstract class Element {
  //抽象方法，没有定义具体实现的方法，不需要abstract修饰
  def contents: Array[String]
 
  //无参数方法
  def height: Int = contents.length
  
  def width: Int = if(height == 0) 0 else contents(0).length()
  
  def demo(){
    println("Element")
  }
  
  //两种实现方法
  def above(that:Element) :Element = {
    new ArrayElement(this.contents ++ that.contents)
    Element.elem(this.contents ++ that.contents)
  }
  
  def beside(that:Element) :Element = {
    val contends = new Array[String](this.contents.length)
    for(i <- 0 until this.contents.length)
      contents(i) = this.contents(i) + that.contents(i)
    new ArrayElement(contents)
  }
}

/**
 * 名字一样的singleton模式实例，是类的伴随对象的实现
 * 库函数用法用来构造其他对象，好处提供统一创建对象的接口而隐藏被创建对象具体是如何表示的
 */
object Element{
  def elem(contents:Array[String]): Element = 
    new ArrayElement(contents)
  
  def elem(line:String) :Element = 
    new LineElement(line)
}