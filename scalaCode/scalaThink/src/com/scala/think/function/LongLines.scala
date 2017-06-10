package com.scala.think.function

import scala.io.Source

/**
 * 给定文件名读取打印长度超过给定字符的行
 */
object LongLines {
  def processFile(fileName:String, width:Int){
    val source = Source.fromFile(fileName);
    for(line <- source.getLines())
      processFile(fileName, width, line)
  }
  
  def processFile(fileName:String, width:Int, line:String){
    if(line.length() > width)
      println(line.trim())
  }
}

object FindLongLines{
  def main(args: Array[String]): Unit = {
    LongLines.processFile("src/com/scala/think/function/LongLines.scala", 10);
  }
}