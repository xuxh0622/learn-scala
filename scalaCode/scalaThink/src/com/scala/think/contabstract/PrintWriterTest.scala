package com.scala.think.contabstract

import java.io.File
import java.io.PrintWriter

object PrintWriterTest {
  //贷出模式，打开资源然后贷出函数
  def withPrintWriter(file:File)(op:PrintWriter => Unit){
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
  }
  
  def main(args: Array[String]): Unit = {
    val file =new File("src/com/scala/think/contabstract/PrintWriter.scala")
    //这个方法第一个参数file，第二个参数是单个可以用大括号替代，里面放函数文本
    PrintWriterTest.withPrintWriter(file){
      writer:PrintWriter => println("1111")
    }
  }
}