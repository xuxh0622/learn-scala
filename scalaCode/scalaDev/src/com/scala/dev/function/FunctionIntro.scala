package com.scala.dev.function
import scala.io.Source
/**
 * 1. 类成员函数
 * 2. 局部函数
 * 3. 函数字面量
 * 4. 闭包
 * 5. 可变参数、命令参数和缺省参数
 */
class FunctionIntro {
  
  //类成员函数
  def processFile(fileName: String){
    //局部函数，可以访问外部函数的变量
    def printLine(line: String){
      println(line)
    }
    var source = Source.fromFile(fileName)
    for(line <- source.getLines())
      printLine(line)
  }
  
  def funcArg{
    //函数字面量，功能是加1
    var increase = (x: Int) => x + 1
  
    //foreach参数也是一个函数
    val someNumbers = List(-11, -10, -5)
    someNumbers.foreach { x => print(x) }
    someNumbers.foreach ( x => print(x) )
    //_作为参数占位符，一个参数出现一次
    someNumbers.filter( _ > 0)
  }
  
  //addMore成为一个闭包，引用函数外面定义的变量
  var more = 1
  val addMore = (x:Int) => x + more
  
  //变长参数
  def echo(args: String*) = {
    for(arg <- args)
      println(arg)
  }
  val arr = Array("What's", "up", "doc")
  //_*逐个传递参数
  echo(arr:_*)
  
  //缺省参数：time:Float=10
  def speed(distance:Float, time:Float=10):Float = {
    distance/time
  }
  //命名参数
  speed(time=10,distance=100)
}

