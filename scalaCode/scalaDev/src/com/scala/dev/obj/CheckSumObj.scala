package com.scala.dev.obj

/**
 * ① 定义一个对象，类似java中Singleton单例对象
 * ② 对象定义不能带参数
 */
object CheckSumAcculator {
   private var sum = 0
  
  def calculate(b:Byte) : Unit = {
    sum += b
  }
   
   /**
    * object定义main函数，作为应用的入口点
    */
   def main(args: Array[String]){
     println("Hello Scala")
   }
}