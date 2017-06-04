package com.scala.dev.extra

import scala.util.matching.Regex

class RegexIntro {
  
  //两种方式创建正则表达式
  var Decimal = new Regex("""(-)?(\d+)""")
  Decimal = """(-)?(\d+)""".r
  
  def findStrNum{
    val input = "for -1.0 to 99 by 3"
    /**
     * regex findFirstIn Str ：查找第一个匹配的字符串，返回 Option 类型
     * regex findAllIn str ：查找所有匹配的字符串，返回 Interator 类型
     * regex findPrefixOf str：从字符串开头检查是否匹配正则表达式，返回 Option 类型
     */
    for(s <- Decimal findAllIn input)
      println(s)
  }
}