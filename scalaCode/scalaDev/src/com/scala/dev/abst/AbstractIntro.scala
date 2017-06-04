package com.scala.dev.abst

trait AbstractIntro {
  //抽象类型
  type T
  
  //抽象方法
  def transform(x:T):T
  
  //抽象成员常量
  val initial:T
  
  //抽象成员变量
  var current:T
}

class Concrete extends AbstractIntro{
  type T = String
  
  def transform(x:String) = x + x
  
  val initial = "hi"
  
  var current = initial
}