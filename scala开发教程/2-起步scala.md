#### 介绍

- 变量、函数的定义
- 循环、迭代的实现
- 数组的参数化
- List、元祖、Set和Map的使用
- 读取文件

***

#### 1.  变量、函数的定义

##### 1.1 变量

>  var代表变量，val常量类似final。下面输出信息`msg`参数名，`String`变量类型，`=`等于后面变量结果`Hello Scala`。

变量声明格式如下：

```java
var VariableName : DataType [=  Initial Value]
```

```java
[**@** /]$ scala
scala> var msg:String = "Hello Scala"
msg: String = Hello World
```

##### 1.2 函数

###### 函数声明

格式如下（abstract）：

```java
def functionName([参数列表]) : [return type]
```

> 参数列表用逗号分割，返回任意合法Scala数据类型，如果没有返回Unit。

###### 函数定义

格式如下：

```java
def functionName([参数列表]) : [return type]{
  function body
  return [expr]
}
```

实际例子：

```java
def max(x:Int, y:Int) : Int = {
  if(x > y){
     x  //函数最后一个表达式可以作为返回值
  }else{
     y
  }
}
max: (x:Int, y:Int)Int
def print() : Unit = {  //Unit没有返回值，类似java中void
  println("Hello Scala")
}
```

###### 函数调用

标准格式：

```
functionName(参数列表)
```

实例对象调用：

```
[instance.]functionName(参数列表)
```

***

#### 2. 循环、迭代的实现

##### 2.1 循环

###### 循环类型

- `while`：运行一系列语句，如果条件为true，会重复运行，直到条件变为false。
- `do...while`：类似 while 语句区别在于判断循环条件之前，先执行一次循环的代码块。
- `for`：重复执行一系列语句直到达成特定条件达成，通过计数器实现退出。

实际例子：

```java
var i=0
while(i < args.length){
  println(args(i))  //数组通过()访问值
  i+=1
}
```

##### 2.2 迭代

> 通过foreach和for来实现迭代

```java
args.foreach(arg => println(arg))
```

```java
for(arg <- args)
 println(arg) 
```

***

#### 3. 数组的参数化

###### 声明数组

> 使用`[]`为数组致命类型化参数，`()`指明数组的索引

```java
var greetStrings = new Array[String](3)
for(i <- 0 to 2)
  print(greetStrings(i))
```

> 这里面`0 to 2`其实是`(0).to(2)`整数类型to方法，如果方法只有一个参数，可以省略`.和()`
>
> 在某个值后面使用`()`解析为调用该对象`apply`方法
>
> 对某个使用`()`对象赋值，转换为该对象`update`方法

```java
0 to 2 === (0).to(2)
greetStrings(i) === greetStrings.apply(i)
greetStrings(i)="Hello"  ===  greetStrings.update(i,"Hello")
var greetStrings = Array("Hello","World")  === Array.apply("Hello","World")
```

#### 4. List、元祖、Set和Map的使用

##### 4.1 List

包含同类型的数据，不可以修改内容。

> `::`添加元素，右边对象调用
>
> `:::`拼接列表

```java
var oneTwo = List(1,2)
var threeFour = List(3,4)
var oneFour = oneTwo ::: threeFour
var oneThree = 1 :: 2 :: 3  === (3).::(2).::(1)
```

##### 4.2 元祖Tuples

可以包含不同类型的数据，通过`._`或`索引`来访问，索引从1开始。

```java
var pair = (99,"alice")
println(pair._1)
println(pair(2))
```

##### 4.3 使用Set和Map

###### Set

`collection.mutable.Set`可以修改Set和不可修改`collection.immutable.Set`对象，默认是不可修改。

```java
var jetSet = Set("Boeing","Airbus")
jetSet += "Lear"
println(jetSet.contains("Cessna"))
```

###### Map

`collection.mutable.Map`可以修改Set和不可修改`collection.immutable.Map`对象，默认是不可修改。

```
val romanNumberal = Map(1 -> "i", 2 -> "II")
println(romanNumberal(2))
```

#### 5. 读取文件

```java
import java.io._
object Test {
   def main(args: Array[String]) {
      println("文件内容为:" )
      Source.fromFile("test.txt" ).foreach{ 
         print 
      }
   }
}
```

