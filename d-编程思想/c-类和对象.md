## 类和对象

##### 类，字段和方法

> 类通过class定义，里面可以放置`字段`和`方法`，统称为`成员`member，字段指向对象的变量，实例化对象内存会保留对象的镜像也就是实例变量。字段public缺省访问级别。

```scala
class CheckSumAccumulator {
  private var sum = 0
  /**
  * 某个方法最后一行值作为返回值不需要return
  * 只有一行表达式可以去掉大括号
  * 没有返回值可以去掉Unit,类似void
  */
  def add(b:Byte) {sum += b}
  def checkSum():Int = ~(sum & 0xFF) +1
}
```

##### Singleton对象

> scala没有静态成员，但是又单例对象，用object替换class。单例对象与类同名时，称为伴生对象，类称为伴生类，可互相访问私有成员。单例对象不能带参数，没有与伴生类共名的单例对象称为孤立对象。

```scala
object CheckSumAccumulator{
  val cache = Map[String,Int]()
}
CheckSumAccumulator.cache
```

##### Scala程序

> 在一个孤立单例对象名中提供一个main方法，作为程序入口

```scala
object Summer{
  def main(args: Array[String]){
    for(arg <- args)
    	println(arg)
  }
}
```

