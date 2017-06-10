package com.scala.think.contabstract

import java.io.File

object FileMatch {
  var filesHere = new File("src/com/scala/think/contabstract").listFiles()
  
  def filesMatching(query:String, matcher:(String,String) => Boolean) = {
    for(file <- filesHere if matcher(file.getName, query)) yield file.getName
  }
  
  /**
   * 函数文本_.endsWith(_)等价(fileName:String, query:String)=>fileName.endsWith(query)
   */
  def filesEnding(query:String) =
    filesMatching(query,_.endsWith(_))
    
  def filesContaining(query:String) =
    filesMatching(query,_.contains(_))
  
  def filesRegex(query:String) =
    filesMatching(query,_.matches(_))
  
  def main(args: Array[String]): Unit = {
    for(fileName <- filesEnding(".scala")) 
      println(fileName)
  }
}

