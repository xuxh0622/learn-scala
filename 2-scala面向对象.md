##### 对象

###### 继承

> 1. 重写一个非抽象方法必须使用override修饰符
> 2. 只有主构造函数才可以往基类的构造函数里写参数
> 3. 在子类中重写超类的抽象方法时，不需要override关键字

```java
class Person {
  var name = ""
  override def toString = getClass.getName + "[name=" + name + "]"
}

class Employee extends Person {
  var salary = 0.0
  override def toString = super.toString + "[salary=" + salary + "]"
}
object Test extends App {
  val fred = new Employee
  fred.name = "Fred"
  fred.salary = 50000
  println(fred)
}
```

###### 单例模式

> 定义一个类和一个同名的object对象，object对象不能带参数。

***

##### Trait

> 相当于java中接口，可以多个继承

```java
trait Equal {
  def isEqual(x: Any): Boolean
}
class Point(xc: Int, yc: Int) extends Equal {
  var x: Int = xc
  def isEqual(obj: Any) = obj.asInstanceOf[Point].x == x
}
```



##### 模式匹配

> 匹配了一个就不往下找了

```java
def matchTest(x: Any): Any = x match {  //match类型java中switch
      case 1 => "one"
      case "two" => 2
      case y: Int => "scala.Int"
      case _ => "many"  // _全配选项，类似java中default
   }
```

##### 正则表达式

```java
import scala.util.matching.Regex;
object Test{
  def main(args: Array[String]){
    val pattern = "Scala".r;  //r方法构造一个Regex对象
    val str = "Scala is Scalable and cool";
    println(pattern findFirstIn str);
  }
}
[**@** /]$ scalac Test.scala  //编译
[**@** /]$ scala Test  //执行
```

##### 异常

> 通过模式匹配处理

```java
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

object Test {
   def main(args: Array[String]) {
      try {
         val f = new FileReader("input.txt")
      } catch {
         case ex: FileNotFoundException => {
            println("Missing file exception")
         }
         case ex: IOException => {
            println("IO Exception")
         }
      } finally {
         println("Exiting finally...")
      }
   }
}
```

