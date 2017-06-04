package com.scala.dev.qualifier

class P {
  class Super{
    //protected定义的成员只能由定义该成员和其派生类型访问
    protected def f(){
      println("f")
    }
  }
  
  class Sub extends Super{
    f()
  }
}