package com.scala.think.basecla

import CheckSumAccumulator.calculate
//孤立对象通过main作为程序入口执行测试
object Summer {
  def main(args: Array[String]): Unit = {
    var args = Array("hello","world")
    //引入calculate方法，可以简单调用
    for(arg <- args)
      println(arg + ":" + calculate(arg))
  }
}