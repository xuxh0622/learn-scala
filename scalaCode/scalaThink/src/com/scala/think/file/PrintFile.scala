package com.scala.think.file

import scala.io.Source
import java.io.File

/**
 * 格式化打印文件内容
 */
object PrintFile {
  
  def getFile(args:Array[File]):Unit = {
    if(args.length > 0){
      var lines = Source.fromFile(args(0)).getLines().toList
      var longestLine = lines.reduceLeft((a,b) => if(a.length()>b.length()) a else b)
      var maxWidth = widthOfLength(longestLine)
      for(line <- lines){
        var numSpaces = maxWidth - widthOfLength(line)
        var padding = " " * numSpaces
        println(padding + line.length() + "|" + line)
      }
    }else
      Console.err.println("Please enter fileName")
  }
  
  def widthOfLength(s:String) = s.length().toString().length()
  
  def main(args: Array[String]): Unit = {
    getFile(Array(new File("src/com/scala/think/two/PrintFile.scala")));
  }
}