package com.scala.dev.Trait

class Animal {
  
}

/**
 * 不能有类参数
 */
trait Philosophical {
   def Philosophical()
}

trait HasLegs {
  
}

class Frog extends Animal with Philosophical with HasLegs{
  override def toString = "green"
  
  def Philosophical(){
    println("Frog")
  }
}