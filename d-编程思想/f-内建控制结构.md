## 内建控制结构

> 有结果类型

##### if表达式

```scala
if(!args.isEmpty) args(0) else "default.txt"
```

##### while循环

> 没有结果类型

```scala
//计算最大公约数
def gcd(x:Long, y:Long):Long = 
	if(y == 0) x else gcd(y, x%y)
```

##### for表达式

> 有结果类型

```scala
//枚举集合类
for(file <- filesHere) 
	println(file)
for(i <- 1 to 2)
for(i <- 1 until 3)
```

##### 过滤

```scala
//多个过滤用分号分隔,或使用大括号
for(file <- filesHere if file.getName,endsWith(.scala))
	println(file)
for{file <- filesHere
   if file.getName.endsWith(".scala")
   line <- fileLines(file)
   trimmed = line.trim
   if trimmed.matches(pattern)
} println(file + trimmed)
```

##### 创造新集合

> 格式：`for {子句} yield {循环体} `，只有一个参数用大括号为了写函数文本

```scala
def scalaFiles = 
	for{
      file <- filesHere
      if file.getName.endsWith(".scala")
	} yield file
def scalaFiles:Array[File]
```

##### 使用try表达式处理异常

###### 抛出异常

> 有结果类型

```scala
//抛出异常Nothing类型，所有类子类
var half = 
	if(n%2 == 0)
		n / 2
	else
		throw new RuntimeException("n must be even")
```

###### 捕获异常

```scala
//通过模式匹配处理异常,在try或catch中返回值，finally仅处理清理工作
try{
  new URL(path)
}catch{
  case ex: FileNotFoundException => new URL("")
  case ex: IOException => new URL("")
}finally{
  f.close()
}
```

##### match表达式

> 有结果类型，模式匹配，缺省用下划线_说明，隐藏break实现

```scala
val firstArg = if(args.length > 0) args(0) else ""
val friend = firstArg match{
  case "salt" => "pepper"
  case _ => "huh?"
}
println(friend)
```

