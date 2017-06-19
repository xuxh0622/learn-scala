## 控制抽象

##### 减少代码重复

> 高阶函数：函数文本表达的函数对象作为参数传递，然后通过闭包省略绑定参数自由变量query。

```scala
def filesMatching(matcher:(String) => Boolean) = {
  for(file <- filesHere if matcher(file.getName)) yield file.getName
}
//函数文本_.endsWith(_)等价(fileName:String, query:String)=>fileName.endsWith(query)
def filesEnding(query:String) =
  filesMatching(_.endsWith(query))
```

##### 简化客户代码

```scala
def containsNeg(nums:List[Int]) = nums.exists(_ < 0)
```

##### Curry化

```scala
def curriedSum(x:Int)(y:Int) = x+y
```

##### 编写新的控制结构

```scala
object PrintWriterTest {
  //贷出模式，打开资源然后贷出函数
  def withPrintWriter(file:File)(op:PrintWriter => Unit){
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
  }
  
  def main(args: Array[String]): Unit = {
    val file =new File("src/com/scala/think/contabstract/PrintWriter.scala")
    //这个方法第一个参数file，第二个参数是单个可以用大括号替代，里面放函数文本
    PrintWriterTest.withPrintWriter(file){
      writer:PrintWriter => println("1111")
    }
  }
}
```