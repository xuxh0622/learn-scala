package com.scala.combat
/**
 * 实现加减乘除
 */
trait BinaryOp {
  val op:String 
  
  //在某个值后面使用()解析为调用该对象apply方法
  def apply(expr1:String, expr2:String) = expr1 + expr2
  
  //Option元祖
  def unapply(str:String) : Option[(String,String)] = {
    val index = str indexOf(op)
    if(index> 0)
      Some(str substring(0,index), str substring(index+1))
    else
      None
  }
  
  def eval(str:String):Int = str match{
    case Add(expr1,expr2) => eval(expr1) + eval(expr2)
    case Subtract(expr1,expr2) => eval(expr1) - eval(expr2)
    case Multiply(expr1,expr2) => eval(expr1) * eval(expr2)
    case Divide(expr1,expr2) => eval(expr1) / eval(expr2)
    case _ => str toInt
  }
  
  def main(args: Array[String]): Unit = {
    println(Add.unapply("3+2"))
    println(eval("3+5+3"))
  }
}

object Multiply extends {val op="*"} with BinaryOp

object Divide extends {val op="/" } with BinaryOp

object Add extends {val op="+" } with BinaryOp

object Subtract extends {val op="-" } with BinaryOp

