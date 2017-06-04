package com.scala.dev.impli

class PreferredPrompt(val preference:String)

class PreferredDrink(val preference:String)

object JamesPrefs{
  implicit val prompt = new PreferredPrompt("relax>")
  implicit val drink = new PreferredDrink("coffed")
}

object Greeter {
  def greet(name:String)(implicit prompt: PreferredPrompt,drink:PreferredDrink){
    println("welcom:" + name)
    println(prompt.preference)
    println(drink.preference)
  }
  
  def main(args: Array[String]): Unit = {
    val bobsPrompt = new PreferredPrompt("relax>")
    //隐含参数的使用
    import JamesPrefs._
    Greeter.greet("Bob")
  }
}