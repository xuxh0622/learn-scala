package com.scala.dev.abst
/**
 * 抽象类型type定义
 */
class Food

abstract class Animal{
  type SuitableFood <: Food
  
  def eat(food:SuitableFood)
}

class Grass extends Food

class Cow extends Animal{
  type SuitableFood = Grass
  override  def eat(food:Grass){}
}

class Fish extends Food

