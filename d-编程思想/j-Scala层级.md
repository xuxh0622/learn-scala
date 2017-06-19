## 层级

##### Scala的类层级

```scala
//顶级类Any包含如下方法
final def ==(that: Any): Boolean 
final def !=(that: Any): Boolean 
def equals(that: Any): Boolean 
def hashCode: Int 
def toString: String
```

> 有两个子类`AnyVal`和`AnyRef`，其中`AnyVal`是每个内建值类的父类，有如下九个之类：Byte、Short、Char、Int、Long、Float、Double、Boolean和Unit，前八个对应Java原始值，不能用new创建类实例，定义为抽象final类。Unit实例()。

##### 底层类型

> 两个类`scala.Null`和`Scala.Nothing`，`Null`是每个继承自`AnyRef`类的子类，不兼容值类型。类型`Nothing`是最底层。

```scala
//error返回Nothing对象
def divide(x:Int, y:Int) : Int =
	if(y != 0) x/y
	else error("can not divide by zero")
```

