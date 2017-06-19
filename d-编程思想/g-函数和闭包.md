## 函数和闭包

##### 方法

> 定义函数最通用就是作为某个对象的成员，称为方法。

#####　本地函数

> 函数中包括函数

```scala
def processFile(fileName:String, width:Int){
    val source = Source.fromFile(fileName);
    
    def processFile(line:String){
    if(line.length() > width)
      println(line.trim())
    }
      
    for(line <- source.getLines())
      processFile(line)
  }
```

##### 函数的第一类值

```scala
//(x:Int) => x+1这个函数值也是对象，也是函数
var increase = (x:Int) => x+1
increase(10)
//用处,foreach带一个函数做参数，对每个元素调用该函数
var someNumbers = List(-11, -10)
someNumbers.foreach((x:Int) => println(x))
someNumbers.filter((x:Int) => x>0)
```

##### 函数文本的短格式

> 去除参数类型

```scala
someNumbers.filter((x) => x>0)
```

#####　占位符语法

```scala
//用_当做参数，每个参数出现一次
someNumbers.filter(_>0)
```

##### 偏应用函数

```scala
//生成只有一个参数的函数
var b = sum(1, _:Int, 3)
b:(Int) => Int = <function>
```

##### 闭包

> 函数需要访问外部变量

```scala
var more = 1
val addMore = (x:Int) => x + more
```

##### 重复参数

```scala
//实际参数
def echo(args:String*) =
	for(arg <- args) println)arg
echo:(String*)Unit
echo("hello","world")
echo(Array("hello","world"):_*)
```

