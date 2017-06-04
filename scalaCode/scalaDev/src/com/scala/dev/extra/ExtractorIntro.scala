package com.scala.dev.extra

abstract class ExtractorIntro {
  def isEmail(s:String):Boolean
  def domain(s:String):String
  def user(s:String):String
  
  def printNameDomain(s:String){
    if(isEmail(s))
      println(user(s) + " AT " + domain(s))
    else
      println("not email")
      
      
    s match{
      case EMail(user,domain) => println(user + "AT" + domain)
      case _ => println("not an email")
    }
  }
}

object EMail{
  def apply(user:String, domain:String) = user + "@" + domain
  
  //EMai对象编程一个Extractor
  def unapply(str:String):Option[(String,String)] = {
    val parts = str split "@"
    if(parts.length == 2)
      Some(parts(0),parts(1))
    else
      None
  }
  
  def main(args: Array[String]): Unit = {
    println(EMail.unapply("james@guidebee.com"))
  }
}