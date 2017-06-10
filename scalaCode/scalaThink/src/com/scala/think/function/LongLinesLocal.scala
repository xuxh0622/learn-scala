package com.scala.think.function

import scala.io.Source

/**
 * 给定文件名读取打印长度超过给定字符的行，本地函数
 */
object LongLinesLocal {
  def processFile(fileName:String, width:Int){
    val source = Source.fromFile(fileName);
    
    def processFile(line:String){
    if(line.length() > width)
      println(line.trim())
    }
      
    for(line <- source.getLines())
      processFile(line)
  }
}

object FindLongLinesLocal{
  def main(args: Array[String]): Unit = {
    LongLinesLocal.processFile("src/com/scala/think/function/LongLines.scala", 10);
  }
}