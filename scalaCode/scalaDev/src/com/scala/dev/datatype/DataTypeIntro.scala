package com.scala.dev.datatype
/**
 * 数据类型介绍
 * scala可以省略不带参数的方法调用的空括号
 */
object DataType {
  
  def main(args: Array[String]){
    /**
     * 中缀操作符，等价于(1).+(2)，调用Int类型的+方法
     * 算术运算符+、-、*、/
     * 关系和逻辑运算符>、<、>=、<=、!等
     * 逻辑运算符||、&&
     * 位操作符&、|、^、~
     * 对象恒等比较==、!=，比较值是否相同，引用比较eq、ne
     */
    var centerRes = 1+2
    
    /**
     * 前缀操作符，只能使用+、-、！、~四个符号
     */
    var preRes = -7 
    
    /**
     * 前缀操作符
     * 后缀操作符在不使用.和括号调用时不带任何参数
     */
    var lastRes = 7 toLong
  }
  
}