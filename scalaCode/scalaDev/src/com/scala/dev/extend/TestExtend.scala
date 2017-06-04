package com.scala.dev.extend

object testExtend {
  def main(args: Array[String]): Unit = {
    val e1:Element = new ArrayElement(Array("hello","world"))
    val e2:ArrayElement = new LineElement("hello")
    e1.demo()
    e2.demo()
  }
}