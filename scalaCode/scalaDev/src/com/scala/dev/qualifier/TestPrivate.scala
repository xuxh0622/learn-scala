package com.scala.dev.qualifier

class Outer {
  class Inner{
    //私有的只能在该类或对象中访问
    private def f(){
      println("f")
    }
    
    class InnerMost{
      f()
    }
  }
}