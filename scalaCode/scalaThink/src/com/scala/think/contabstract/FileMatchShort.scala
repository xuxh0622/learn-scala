package com.scala.think.contabstract

import java.io.File

object FileMatchShort {
  var filesHere = new File("src/com/scala/think/contabstract").listFiles()
  
  def filesMatching(matcher:(String) => Boolean) = {
    for(file <- filesHere if matcher(file.getName)) yield file.getName
  }
  
  /**
   * 函数文本_.endsWith(_)等价(fileName:String, query:String)=>fileName.endsWith(query)
   * query作为自由变量，因为闭包模式绑定到函数中
   */
  def filesEnding(query:String) =
    filesMatching(_.endsWith(query))
    
  def filesContaining(query:String) =
    filesMatching(_.contains(query))
  
  def filesRegex(query:String) =
    filesMatching(_.matches(query))
  
  def main(args: Array[String]): Unit = {
    for(fileName <- filesEnding(".scala")) 
      println(fileName)
  }
}