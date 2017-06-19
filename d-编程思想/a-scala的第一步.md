##### 第一步：学习使用scala解释器

```scala
[alice@ ~]$ scala
scala> 1+2
//计算的值：表达式类型(Int) = 表达式结果
res0: scala.Int = 3  
```

##### 第二步：定义一些变量

> 格式：`val 变量名:类型 = 值`

> Scala有两种变量，有val和var，val类似于Java中的final变量，一旦初始化就不能再赋值，例子如下：

```scala
//类型推定type inference，自动理解
scala> val msg = "hello, world!"  
msg: java.lang.String = hello, world!
//显示指定类型
scala> val msg: java.lang.String = "hello, world!"  
msg: java.lang.String = hello, world  
//备注：按两次回车可以取消本次输入
```

##### 第三步： 定义一些函数

> 格式：`def funName(arg:argType):returnType={funBody} `
>
> 函数体只有一句话可以不写外面的{}括号，参数默认val类型不能重新赋值，例子如下：

```scala
//函数标识 函数名(参数:类型, 参数:类型): (返回值) = {函数体}
scala> def max(x:Int, y:Int):Int = {if(x > y) x else y} 
max: (Int, Int) Int
//不带参数和返回值
scala> def greet() = println("hello, world!")  
greet: () Unit
//备注：:quit或:q退出解释器
```

##### 第四步： 编写一些Scala脚本

```scala
[alice@ ~]$ vi hello.scala
println("hello, " + args(0)) 
[alice@ ~]$ scala hello.scala planet
hello, planet
```

##### 第五步： 用while循环，用if判断

```scala
[alice@ ~]$ vi printargs.scala
var i = 0
while(i < args.length){
  print(args(i) + " ")
  i += 1
}
[alice@ ~]$ scala printargs.scala Scala is fun
Scala is fun
```

##### 第六步： 用foreach`=>`和for`<-`枚举

> 格式：`foreach(参数 : (参数:类型, 参数:类型) => {函数体})`
>
> 函数文本中参数类型可推定可省略，只有一个参数可省略，例子如下：

```scala
[alice@ ~]$ vi printargs.scala
//args调用foreach方法，把参数arg传入函数文本print(arg+" ")
args.foreach(arg => print(arg + " "))  //推定arg为String类型，因为args是String类型
args.foreach((arg: String) => print(arg + " "))  //显示指定类型
args.foreach(print(arg + " "))  //只有一个参数，可以省略
```

> 格式：`for(参数 <- 数组)`
>
> 其中`arg`默认是`val`类型，例子如下：

```scala
[alice@ ~]$ vi printargs.scala
for(arg <- args)
	print(arg + " ")
```

