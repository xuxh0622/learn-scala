package com.scala.dev.obj
/**
 * 创建一个类，类以class开头，缺省修饰符public
 */
class CheckSumAccumulator {
  private var sum = 0
  
  /**
   * ① 方法以def开头，参数都是val常量类型
   * ② 没有返回值类似Unit，可以省略=号
   * ③ 函数最后一行就是函数的返回值
   */
  def add(b:Byte) : Unit = sum += b
}