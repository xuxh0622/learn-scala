package com.scala.dev.matc

object MatchLimit {
  
  //模式限定修饰
  def simplifyAdd(e:Expr) = e match{
    case BinOp("+",x,y) if x==y => BinOp("*",x,Number(2))
    case _ =>
  }
  
  //重叠模式定义
  def simplifyTop(expr:Expr):Expr = expr match{
    case UnOp("-",UnOp("-",e)) => e
    case BinOp("+",e,Number(0)) => e
    case BinOp("*",e,Number(1)) => e
    case _ => expr
  }
  
  def main(args: Array[String]): Unit = {
    //输出BinOp(*,Var(x),Number(2.0))
    println(simplifyAdd(BinOp("+",Var("x"),Var("x"))))
  }
}