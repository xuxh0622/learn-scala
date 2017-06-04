package com.scala.dev.matc
/**
 * sealed匹配完善检查
 */
sealed abstract class SealExpr

case class SealVar(name:String) extends SealExpr

case class SealNumber(num:Double) extends SealExpr

case class SealUnOp(operator:String, arg:SealExpr) extends SealExpr

case class SealBinOp(operator:String, left:SealExpr, right:SealExpr) extends SealExpr

object MatchSealOption{
  def describe(e:SealExpr):String = e match{
    case SealNumber(_) => "a number"
    case SealVar(_) => "a variable"
    case _ => throw new RuntimeException
  }
}