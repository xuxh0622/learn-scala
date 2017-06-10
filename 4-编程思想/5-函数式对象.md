## 函数式对象

没有任何可变状态的对象的类

##### 类Rational的式样书

```scala
class Rational(n:Int, d:Int){
  println(n + d)
}
object testRational{
  def main(args: Array[String]): Unit = {
    val x = new Rational(1,2)
    val y = new Rational(3,4)
  }
}
```

##### 重新实现toString方法

```scala
override def toString = n + "" + d  //override重载
```

##### 检查先决条件

```scala
require(d != 0)  //检查先决条件
```

##### 添加字段

```scala
class Rational(n:Int, d:Int) {
  //字段默认缺省public可以访问
  val numer:Int = n
  val denom:Int = d
}
```

##### 自指向

```scala
//返回指定分数和参数中较大者
def max(that:Rational) =
	if(this.lessThan(that)) that else this
```

##### 从构造器

> 格式`def this(...)`调用主构造器

```scala
def this(n:Int) = this(n,1)
```

##### 私有字段和方法

##### 定义操作符

```scala
def +(that:Rational):Rational = 
  new Rational(numer*that.denom + that.numer*denom,denom*that.denom)
```

##### Scala标识符

> 字母数字标识符：起始于一个字母或下划线，之后跟字母、数字或下划线
>
> 操作符标识符：+ : ? ~等
>
> 混合标识符：unary_+
>
> 文本标识符：反引号括起来

##### 方法重载

```scala
//定义操作符
def +(that:Rational):Rational = 
  new Rational(number*that.denom + that.number*denom,denom*that.denom)
//重载修饰符方法+
def +(i:Int):Rational =
  new Rational(number+i*denom,denom)
println(y + x)
```

##### 隐式转换

```scala
//隐式转换定义在作用范围之内
implicit def intToRational(x:Int) = new Rational(x)
println(2 + x)
```

