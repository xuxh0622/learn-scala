package com.scala.think.traintorder

class Rational(n:Int, d:Int) {
  
  val number = n
  
  val denom = d
  
  def < (that: Rational) = 
    this.number * that.denom > that.number * this.denom
    
  def > (that: Rational) = that < this
  
  def <= (that: Rational) =
    (this < that) || (this == that)
    
  def >= (that: Rational) =
    (this > that) || (this == that)
}