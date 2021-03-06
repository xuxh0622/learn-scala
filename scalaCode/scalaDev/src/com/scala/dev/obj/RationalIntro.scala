package com.scala.dev.obj

/**
 * 定义类参数n、d,仅限定义类方法本身可以访问类参数
 */
class Rational(n:Int, d:Int) {
  //添加成员变量
  val number = n
  val denom = d
  
  //私有成员变量
  private val g = gcd(n,d)
  
  //私有方法
  private def gcd(a:Int,b:Int):Int = 
    if(b == 0) a else b
  
  //先决条件：Predef对象定义的方法，自动载入
  require(d!=0)
    
  //方法重写：基类定义的方法
  override def toString = n + "/" +d 
  
 	//主构造函数：定义任何不属于类成员和类方法的其他代码
  println("Created " + n + "/" + d)
  
  //自身引用：this
  def add(that:Rational) : Rational = {
     new Rational(this.denom + that.number, d + that.denom)
  }

  //辅助构造函数:最终会调用主构造函数
  def this(n:Int) = this(n,1)
 
  //定义运算符
  def +(that:Rational) =
    new Rational(this.number+that.number,this.denom+that.denom)
  
  //方法重载：参数类型不同但是方法名相同
  def + (i:Int) = 
    new Rational(this.number+i,this.denom)

}
object Rational{
    def main(args: Array[String]): Unit = {
      val oneRational = new Rational(1,2)
      val towRatinal = new Rational(1,4)
      oneRational.add(towRatinal)
      oneRational + towRatinal
      towRatinal + 3
      //隐式类型转换:实现3 + Rational(2,3)方法
      implicit def intToRational(x:Int) = new Rational(x)
      3 + towRatinal
  }
}
