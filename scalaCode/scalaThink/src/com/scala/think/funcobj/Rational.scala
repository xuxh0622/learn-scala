package com.scala.think.funcobj
/**
 * n和d是类参数，也是成员变量
 * 没有函数体可以省略大括号
 * 编译器会自动床罩一个带两个参数的主构造器
 * 编译器会将任何类内部不是成员的部分编译进主构造器
 * 缺省继承java.lang.Object类
 */
class Rational(n:Int, d:Int) {
  //检查先决条件
  require(d != 0)
  
  //私有字段,abs获取绝对值
  private val g = gcd(n.abs, d.abs)
  
  //字段默认缺省public可以访问
  val number:Int = n / g
  val denom:Int = d / g
  
  def this(n:Int) = this(n,1)
  
  //override重载
  override def toString = n + " " + d
  
  def add(that:Rational): Rational = 
    new Rational(number * that.denom + that.number * denom,denom*that.denom)
  
  //私有方法有最大公约数
  private def gcd(a:Int, b:Int) :Int =
    if(b == 0) a else gcd(b, a%b)
    
  //定义操作符
  def +(that:Rational):Rational = 
    new Rational(number*that.denom + that.number*denom,denom*that.denom)
  
  //重载修饰符方法+
  def +(i:Int):Rational =
    new Rational(number+i*denom,denom)

}

object testRational{
  def main(args: Array[String]): Unit = {
    val x = new Rational(1,2)
    val y = new Rational(3,4)
    println(x + y)
    println(x + 2)
    //隐式转换
    implicit def intToRational(x:Int) = new Rational(x)
    println(2 + x)
  }
}