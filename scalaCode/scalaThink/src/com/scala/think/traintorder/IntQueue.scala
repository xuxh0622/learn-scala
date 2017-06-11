package com.scala.think.traintorder

import scala.collection.mutable.ArrayBuffer

/**
 * 队列
 */
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x}
}

/**
 * 继承IntQueue，只能混入其扩展类中
 * abstract override特质必须混入到某个具有期待方法的具体定义类中
 * super动态绑定到具体类中
 */
trait Doubling extends IntQueue{
  abstract override def put(x:Int){super.put(2*x)}
}

trait Incrementing extends IntQueue{
  abstract override def put(x:Int){super.put(x+1)}
}

//靠右边的特质先执行
class MyQueue extends BasicIntQueue with Doubling with Incrementing

object TestBasicIntQueue{
  def main(args: Array[String]): Unit = {
    val queue = new MyQueue
    queue.put(10)
    queue.put(20)
    println(queue.get())
  }
}