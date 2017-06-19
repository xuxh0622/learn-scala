# HelloWorld

[TOC]

## 交互方式

```bash
[**@** /]$ cd /usr/alice/java/scala-2.12.2/bin  #如果没有配置到PATH环境变量
[**@** /]$ ./scala  #打开交互环境
[**@** /]$ scala  #配置到PATH环境变量，打开交互环境
scala> object HelloWorld{  #Shift+Enter换行
scala>   def main(args: Array[String]){
scala>   	println("Hello World")	
scala> 	  }
scala> }
scala> HelloWorld.main(null)
```

## 文本方式

```bash
[**@** /]$ cd /usr/home/alice/code/scala
[**@** /]$ vi HelloWorld.scala  #编辑文件
object HelloWorld{
  def main(args: Array[String]) : Unit = {
    println("Hello World")
  }
}
[**@** /]$ scalac HelloWorld.scala -d /usr/home/alice/code/scala #当前路径下生成class文件,-d指定class文件生成目录
[**@** /]$ ls -l  #列出编译之后生成的文件
HelloWorld.class HelloWorld$.class HelloWorld.scala
[**@** /]$ scala HelloWorld  #自动调用main方法
```
