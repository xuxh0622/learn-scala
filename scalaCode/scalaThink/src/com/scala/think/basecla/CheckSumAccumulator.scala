package com.scala.think.basecla

import scala.collection.mutable.Map
/**
 * 伴生类和对象客户互相访问私有成员
 * 伴生对象有点像静态集合
 */
//伴生类
class CheckSumAccumulator {
  private var sum = 0
  def add(b: Byte){ sum += b }
  def checkSum():Int = ~(sum & 0xFF) + 1
}
//伴生对象
object CheckSumAccumulator{
  private val cache = Map[String,Int]()
  
  def calculate(s:String):Int = {
    if(cache.contains(s))
        cache(s)
    else{
      val acc = new CheckSumAccumulator
      for(c <- s)
        acc.add(c.toByte)
      val cs = acc.checkSum()
      cache += (s -> cs)
      cs
    }
  }
}

