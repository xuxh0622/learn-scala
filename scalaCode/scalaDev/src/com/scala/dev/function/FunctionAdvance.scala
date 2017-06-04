package com.scala.dev.function
import java.io._
/**
 * 函数进阶
 * 尾递归
 * 减低代码重复
 * 柯里化函数
 * 创建新的控制结构
 * 传名参数
 */
object FunctionAdvance {
  
  //尾递归
  def boom(x:Int):Int = {
    if(x == 0)
      throw new Exception("boom")
    else
      boom(x-1)
  }
  
  //高阶函数，第二个参数matcher为函数
  def filesHere = (new java.io.File(".")).listFiles()
  def filesMatching(matcher:(String) => Boolean) = {
    for(file <- filesHere; if matcher(file.getName))
      yield file
  }
  
  def filesEnding(query:String) = 
    filesMatching(_.endsWith(query))
    
  /**
   * 柯里化函数，接受多个参数编程接受单一参数，返回接受余下参数而且返回结果的新函数的技术
   * def palinOldSum(x:Int) = (y:Int) => x + y
   */
  def plainOldSum(x:Int)(y:Int) = x + y
  
  
  //创建新的控制结构
  def withPrintWriter(file:File, op:PrintWriter => Unit){
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
    withPrintWriter(new File("data.txt"),writer => writer.println(""))
  }
  
  //传名参数
  def withHelloWorld(op: => Unit){
    println("hello world")
    op
  }
  
  withHelloWorld{
    println("hello Guidebee")
  }
  
  def main(args: Array[String]): Unit = {
    
  }
}
