##### 运行

```bash
[**@** /]$ scalac HelloWorld.scala  #生成class文件
[**@** /]$ scala HelloWorld  #调用执行main函数
[**@** /]$ scala  #进入scala解释器环境
[**@** /]$ :help  #列出常用scala解释器命令
[**@** /]$ :quit  #退出环境
```

##### 变量

> var变量声明，val常量声明。

```java
//var VariableName : DataType [= Initial Value]声明格式，多行编写shift+enter换行
scala> var myVar :Int;  //带类型声明
scala> var myVar = 10;  //带值声明
scala> var xmax, ymax = 100;  //多个变量声明
```

##### 访问修饰符

> private带有此标记的成员仅在包含了成员定义的类和对象内部可见，同样规则适合内部类。protected保护成员在定义了该成员的类的子类中被访问。public任何地方都可以访问。private[x]表明这个成员对[...]中的类或[...]中的包的类及伴生对象可见。

```java
package bobsrockets{
  package navigation{
    private[bobsrokets] class Navigator{  //Navigator对bobsrokets包中类和对象可见
      protected[navigation] def useStarChart(){
        class LegOfJourney{
          private[Navigator] val distance = 100;
        }
      }
    }
  }
}
```

##### 函数

> 类里面的是方法，单独定义的是函数，可以赋给一个变量。

```java
//def functionName ([参数列表]) : [return type]  函数声明
//函数定义
Object Hello{
  def printMe(a:Int, b:Int) : Unit = {  //传入参数逗号分割，返回空Unit
    priln("Hello, Scala!")
  }
}
//函数调用，方法调用和实例调用
[instance.]funcationName(参数列表)
```

##### 闭包

> 闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量。

```java
var factor = 3;
var multiplier = (i:Int)  => i * factor  //(i:Int)是一个函数，然后依赖外部变量factor
```

##### 数组

```java
//声明数组
var z:Array[String] = new Array[String](3);
var z = new Array[String](3);
var z= Array("Runoob", "Baidu", "Google");
z(0) = "Alice";  //赋值
//数组循环操作
object Test{
  def main(args: Array[String]){
    var myList = Array(1.9, 2.9, 3.9);
    for( x <- myList){
      println(x);
    }
  }
}
//多维数组
var myMatrix = ofDim[Int](3,3);
```

##### 集合

> 元组是不同类型的值的集合，Option[T] 表示有可能包含值的容器，也可能不包含值。

```java
// 定义整型 List
val x = List(1,2,3,4)
// 定义 Set
var x = Set(1,3,5,7)
// 定义 Map
val x = Map("one" -> 1, "two" -> 2, "three" -> 3)
// 创建两个不同类型元素的元组
val x = (10, "Runoob")
// 定义 Option
val x:Option[Int] = Some(5)
```

##### 迭代器

```java
object Test {
   def main(args: Array[String]) {
      val it = Iterator("Baidu", "Google", "Runoob", "Taobao")
      while (it.hasNext){
         println(it.next())
      }
   }
}
```

