package com.scala.dev.Trait

class Frog extends Animal with Philosophical with HasLegs{
  override def toString = "green"
  
  def Philosophical(){
    println("Frog")
  }
}