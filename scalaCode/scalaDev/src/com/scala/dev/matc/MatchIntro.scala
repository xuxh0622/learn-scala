package com.scala.dev.matc

object MatchIntro {
  
  //常量模式，第一个字母大写N
  def describe(x:Any) = {
    x match {
      case 5 => "five"
      case true => "truth"
      case "hello" => "hi!"
      case Nil => "empty list"
      case _ => "something else"
    }
  }
  
  //变量模式，小写变量开头
  def isZero(x:Any) = {
    x match{
      case 0 => "zero"
      case somethingElse => "not zero"
    }
  }
  
  //构造器模式
  def deep(expr:Expr) = {
    expr match{
      case BinOp("+",e,Number(0)) => "a deep match"
      case _ =>
    }
  }
  
  //数组列表匹配
  def isList(list:List[Int]){
    List(0,2,4) match{
      case List(0,_,_) => print("found it")
      //_*匹配任意数目的元素
      case List(0,_*) => print("found it")
      case _ =>
    }
  }
  
  //匹配多元组
  def tupleDemo(expr:Any){
    expr match{
      case (a,b,c) => print("match")
      case _ =>
    }
  }
  
  //类型匹配，数组支持匹配元素类型，map不支持匹配元素类型
  def generalSize(x:Any) = {
    x match{
      case s:String => s.length()
      case m:Map[_,_] => m.size
      case _ => -1
    }
  }
  
  //变量绑定模式
  def variMatch(expr:Expr) = {
    expr match{
      //匹配成功，e赋值为UnOp("abs",_)
      case UnOp("abs", e @ UnOp("abs",_)) => e
      case _ => 1
    }
  }
  
  def main(args: Array[String]): Unit = {
    print(variMatch(UnOp("abs",Number(5.0))))
  }
}