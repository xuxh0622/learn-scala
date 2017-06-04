package com.scala.dev.matc

class MatchOption {
  var capitals = Map("France"->"Paris")
  
  //解决NULL值类型
  def show(x:Option[String]) = x match{
    case Some(s) => s
    case None => "?"
  }
  
  val withDefault: Option[Int] => Int ={
    case Some(x) => x
    case None => 0
  }
  
  //for表达式循环
  def printMap{
    for((country,city) <- capitals)
    println("captical" + country + "is" + city)
  }

}

object MatchOption{
  def main(args: Array[String]): Unit = {
    var matchOption = new MatchOption()
    println(matchOption.show(matchOption.capitals get "France"))
    matchOption.printMap
    
  }
}