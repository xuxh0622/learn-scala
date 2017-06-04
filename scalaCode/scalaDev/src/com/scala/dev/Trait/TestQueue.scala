package com.scala.dev.Trait

import scala.collection.mutable.ArrayBuffer
/**
 * 队列实现
 */
abstract class IntQueue{
  def get():Int
  
  def put(x:Int)
}

class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]
  
  def get() = buf.remove(0)
  
  def put(x:Int){
    buf += x
  }
}

trait Doubling extends IntQueue{
  /**
   * trait继承自某个类，可以使用override关键字重写其方法
   * abstract override关键字组合保证混入这个trait对象实现了这个方法，因为要调用super动态绑定
   */
  abstract override def put(x:Int){
    super.put(2*x)
  }
}

trait Incrementing extends IntQueue{
  abstract override def put(x:Int){
    super.put(x+1)
  }
}
object testQueue{
  def main(args: Array[String]): Unit = {
    var queue = new BasicIntQueue
    queue.put(1)
    queue.put(2)
    println(queue.get())
    
    //混合trait，增强方法
    queue = new BasicIntQueue with Doubling
    queue.put(3)
    println(queue.get())
    
    //混合trait，越往后作用越大，先加然后再乘
    queue = new BasicIntQueue with Doubling with Incrementing
    queue.put(3)
    println(queue.get())
  }
}