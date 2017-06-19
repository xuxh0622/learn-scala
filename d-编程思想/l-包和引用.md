## 包和引用

##### 包

##### 引用

> 包和其成员可以用import子句来引用，引用之后可以通过简单名来访问

- 简单名x。把x包含进引用名集。
- 重命名子句x => y。让名为x的成员以名称y出现。
- 隐藏子句x => _。把x排除在引用名集之外。 _
- _ 全包括‘_’。引用除了前面子句提到的之外的全体成员。如果存在全包括，那么必须是引用选择的最后一个。

```scala
import Fruits._  //引用Fruits下面成员
import Fruits.{Apple => McIntosh, Orange}  //引用Apple、Orange成员，并重命名Apple
import Fruits.{Apple => _, _}   //Apple => _隐藏
```

##### 隐式引用

```scala
import java.lang._ // java.lang包的所有东西 
import scala._ // scala包的所有东西 
import Predef._ // Predef对象的所有东西
```

##### 访问修饰符

###### 私有成员

> 类里面访问

###### 保护成员

> 成员的类和子类中可以访问，严于java里面同一个包就可以

###### 公开成员

> 未标记的都是公开，可以在任何地方被访问。格式为private[X]或protected[X]的修饰符表示“直到”X的私有或保护，这里X指代某些外围的包，类或单例对象。

```scala
package bobsrockets{
  package navigation{
    //这就是说Navigator这个类对包含在bobsrockets包的所有的类和对象可见
    private[bobsrockets] class Navigator{
      //useStarChart方法在Navigator所有子类以及包含在navigation包里的所有代码能够被访问
      protected[navigation] def useStarChar(){}
      class LegOfJourney{
        //distance在类Navigator的任何地方都可见
        private[Navigator] val distance = 100
      }
      //仅能在包含了定义的同一个对象中被访问
      private[this] var speed = 200
    }
  }
  
  package launch{
    import navigation._
    object Vehicle{
      private[launch] val guide = new Navigator
    }
  }
}
```



##### 可见度和伴生对象

> 访问修饰符统一于半生对象，伴生对象没有任何子类

