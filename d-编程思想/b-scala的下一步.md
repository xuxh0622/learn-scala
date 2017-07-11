##### 第七步： 带类型的参数化数组

> 数组声明初始化，几个默认方法调用`apply、update`

```scala
//类型参数化,val指定的值不能重新赋值，但是对象仍可暗自改变
val greetStrings = new Array[String](3)
greetStrings:Array[String] = new Array[String](3)
//带括号访问,等价于调用greetStrings.applye(0)
greetStrings(0)
//0 to 2等价于(0).to(2),如果方法只有一个参数可以不带点和括号访问
for(i <- 0 to 2)
	print(greetStrings(i))
//带括号里参数和等号右边对象，等价于greetStrings.update(0,"hello")调用
greetStrings(0) = "hello"
//等价var numNames = Array.apply("zero","one","two")初始化数组，推定类型是String，在Array伴生对象中定义了apply带可变数量参数的方法，伴生对象中方法类似Apply调用静态方法
var numNames = Array("zero","one","two")
```

##### 第八步： 使用List

> List声明初始化，scala.List是不可变对象类型java中String，只能包含一种类型对象

```scala
//初始化列表，类似调用伴生对象中List.apply(1, 2, 3)
var oneTwo = List(1, 2) 
oneTwo:List[Int] = Lits(1,2) 
var threeFour = List(3, 4)
//以冒号结尾方法时右操作数调用，等价oneThree.::(3)，结果List(3,1,2)
var oneThree = 3 :: oneThree
var oneTwo = 1 :: 2 :: Nil  //其中Nil是空类，包含List中Apply方法
//以冒号结尾方法时右操作数调用，threeFour.:::(oneTwo)，结果List(1,2,3,4)
var oneFour = oneTwo ::: threeFour
```

##### 第九步： 使用Tuple

> 元祖也是不可变类型，但是可以包含不同类型的元素

```scala
//元祖初始化
var pair = (99, "Luftballons")
pair:(Int, String) = (99,Luftballons)
//点调用访问_1字段，不同通过括号访问因为返回值不同，
print(paif._1)
```

##### 第十步： 使用Set和Map

> set集合分可变和不可变类型，包路径不同

![特质序列](https://github.com/xuxh0622/learn-scala/blob/master/image/set.png)

```scala
//默认不可变集合
var jetSet = Set("Boeing", "Airbus")
jetSet:Set[String] = Set("Boeing", "Airbus")
//赋值，方法等价jetSet.+=("Shrek")
jetSet += "Shrek"
//可变集合
import scala.collection.mutable.Set
val movieSet = Set("Hitch", "Poltergeist")
//不可变显示的集类
import scala.collection.immutable.HashSet
val hashSet = HashSet("Tomatoes", "Chilies")
```

> Map也分为可变不可变

![特质序列](https://github.com/xuxh0622/learn-scala/blob/master/image/map.png)

```scala
import scala.collection.mutable.Map
//声明Map
val treasureMap = Map[Int,String]()
//1 -> "Go to island"二元操作等价(1).->"Go to island"，返回二元数组
treasureMap += (1 -> "Go to island")
print(treasureMap(0))
//默认不可变Map，传入工厂方法2个键/值元祖
var romanNumeral = Map(1 -> "I", 2 -> "II")
```

##### 第十一步： 学习识别函数式风格

> 少用var和有副作用的函数

```scala
//可枚举集合类型Iterator（包括数组、列表、集合和映射）都可调用mkString方法，传入字符串间隔
def formatArgs(args: Array[String]) = args.mkString("\n")
formatArgs: (args: Array[String])String
```

##### 第十二步： 从文件里读取信息行

```scala
def getFile(args:Array[File]):Unit = {
    if(args.length > 0){
      var lines = Source.fromFile(args(0)).getLines().toList
      var longestLine = lines.reduceLeft((a,b) => if(a.length()>b.length()) a else b)//获取最长行
      var maxWidth = widthOfLength(longestLine)
      for(line <- lines){
        var numSpaces = maxWidth - widthOfLength(line)
        var padding = " " * numSpaces //获取numSpaces个空格字符串
        println(padding + line.length() + "|" + line)
      }
    }else
      Console.err.println("Please enter fileName")
  }
  
  def widthOfLength(s:String) = s.length().toString().length()
```

