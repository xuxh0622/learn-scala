package com.scala.think.traitintro

trait Rectangular {
  
  def topLeft: Point
  
  def bottomRight: Point 
  
  def left = topLeft.x
  
  def right = bottomRight.x
  
  
}