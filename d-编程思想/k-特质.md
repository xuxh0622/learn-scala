## 特质Trait

> 特质封装了方法和字段的定义，是代码复用的基础单元，可以通过`extends`或`with`混入类中重用它们。不像继承只能单继承，特质可以混入任意个。特质不能有类参数，然后super调用时动态的。

##### 瘦接口对胖接口

> java里面接口不能有方法定义，所以大多是瘦接口，但是特质可以写字段和方法定义，推荐胖接口方式。

##### Ordered特质

```scala
class RationalOrder(n:Int, d:Int) extends Ordered[RationalOrder]{
  val number = n
  val denom = d
  //负数小于，0等于，正数大于
  def compare(that: RationalOrder) = 
    this.number * that.denom - that.number * this.denom
}
```

##### 特质用来做可堆叠的改变

```scala
//靠右边的特质先执行
class MyQueue extends BasicIntQueue with Doubling with Incrementing
```

#####  特质线性化
![特质序列](https://github.com/xuxh0622/learn-scala/blob/master/image/traint.png)
```scala
class Animal
trait Furry extends Animal
trait HasLegs extends Animal
trait FourLegged extends HasLegs
class Cat extends Animal with Furry with FourLegged
```

##### 特质，用还是不用？

> java运行能让类成员的虚方法快了接口方法，特质被编译成接口，微小性能损失。`多个不相关类重用`推荐接口。

