package com.scala.dev.statement

class Statement {
  
  //if
  def ifCase(fileName:String):String = {
    if(fileName.isEmpty)
      "empty"
    else
      fileName
  }
  
  //while 计算最小公约数
  def whileCase(x:Long, y:Long):Long = {
    var a = x
    var b = y
    while(a != 0){
      var temp = a
      a = b%a
      b = temp
    }
    b
  }
  
  //do while循环
  def doWhileCase(x:Int) = {
    var a = x
    do{
      a += 1
    }while(a < 0)
  }
  
  def fileLines(file : java.io.File) = 
    scala.io.Source.fromFile(file).getLines().toList
  
  //for
  def foCase() = {
    //files类型是Array[file]
    var files = (new java.io.File(".")).listFiles()
    //枚举数组，添加过滤天剑，分号隔开两重迭代
    for(file <- files if file.isFile; line <- fileLines(file))
      println(file)
    //枚举Range类型
    for(i <- 1 to 4)
      print("Interation" + i)
  }
  
  //捕获异常
  def catchExceptionCase(x:Int){
    try{
      exceptionCase(x)
    }catch{
      case ex: RuntimeException => println("excepiton")
    }finally{
      println("finally")
    }
  }
  
  //异常处理
  def exceptionCase(x:Int){
    if(x % 2 == 0)
      x/2
    else
      throw new RuntimeException("n must be even")
  }
  
  //match类似java中switch语句
  def matchCase(args : String){
    args match{
      case "salt" => println("salt")
      case "eggs" => println("eggs")
      //_缺省匹配，piint这段可以作为返回值表达式
      case _ => print("hub?")
    }
  }
}