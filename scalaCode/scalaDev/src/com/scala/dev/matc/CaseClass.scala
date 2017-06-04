package com.scala.dev.matc

/**
 * case classes
 * 编译器自动生成同名对象构造器，可以使用Var("x")==new Var("x")
 * 构造函数的参数创建以参数名为名称的属性var.name
 * 构造更自然的toString、hashCode和equals实现
 * 添加一个copy方法，通过构造类对象一个可以修改的拷贝op.copy(operator="-")
 */
abstract class Expr

//变量
case class Var(name:String) extends Expr

//数值
case class Number(num:Double) extends Expr

//单操作符
case class UnOp(operator:String, arg:Expr) extends Expr

//双操作符
case class BinOp(operator:String, left:Expr, right:Expr) extends Expr

object testExpr{
  def simplfyTop(expr:Expr):Expr = {
    expr match{
      //变量模式e可以匹配任意的值
      case UnOp("-",UnOp("-",e)) => e
      case BinOp("+",e,Number(0)) => e
      case BinOp("*",e,Number(1)) => e
      case _ => expr
    }
  }
  
  def main(args: Array[String]): Unit = {
    println(simplfyTop(UnOp("-",UnOp("-",Var("x")))))
  }
}