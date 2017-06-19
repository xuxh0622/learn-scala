## 组合和继承

##### 定义参数化字段

```scala
class Cat{
  val dangerous = false
}
//类参数通过val修改的参数，作为当前类成员，可以继承父类字段
class Tiger(
  override val dangerous : Boolean	
  private var age: Int
) extends Cat
```

##### 例子

```scala
package com.scala.think.comextend
import Element.elem
/**
 * 具有抽象成员的类必然是抽象类，用abstract修饰 
 * Element类隐式扩展AnyRef类似java里面object
 */
abstract class Element {
  //字符串数组
  def contents:Array[String]
  //调用不带参数方法可以省略括号，如果有副作用最好不省略
  val height:Int = contents.length
  val width:Int = if(height == 0) 0 else contents(0).length
  
  //++数组串联
  def above(that: Element) :Element =
    elem(this.contents ++ that.contents) 
  
  //Array(1,2,3) zip Array("a","b")生成Array((1,"a"),(2,"b"))
  def beside(that:Element):Element = {
    val contents = new Array[String](this.contents.length)
    for((line1,line2) <- this.contents zip that.contents)
      yield line1 + line2
    elem(contents)
  }
}

//通过伴生对象，生成工厂方法的工厂对象
object Element{
  def elem(contents: Array[String]): Element = 
    new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)
  def elem(line: String):Element = 
    new LineElement(line)
  
  /**
   * ArrayElement类扩展了Element
   * 超类所有成员都是子类成员，除了私有的和具有相同名称或参数的，称为重载
   * 如果子类中成员是具体实现，可以说成员实现
   * ArrayElement和Array[String]之间形成组合
   * 字段和方法属于相同的命名空间，所以字段可以重载无参数化方法
   * scala命名空间，值（字段、方法、包和单例对象），类型（类和特质名），java中是字段、方法、类型和包
   */
  private class ArrayElement(conts:Array[String]) extends Element{
    //重载方法变成字段
    override val contents : Array[String] = conts
    //final修饰的成员不能被重载
    final def demo(){
      print("implementation invoked")
    }
  }
  
  //当行字符串
  private class LineElement(s:String) extends ArrayElement(Array(s)){
    override val width = s.length()
    override val height = 1
  }
  
  //继承抽象类，必须实现里面的抽象方法
  private final class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  )extends Element{
    private val line = ch.toString() * width
    override val contents = Array("hello","world")
  }
}

object Spiral{
  val space = elem(" ")
  val corner = elem("+")
  def spiral(nEdges:Int, direction:Int): Element = {
    if(nEdges == 1)
      elem("+")
    else
      elem("-")
  }
  
  def main(args: Array[String]): Unit = {
    println(spiral(1,0))
  }
}
```



