package bobsrockets{
  
  package navigation{
    class Navigator{
      //访问同一个包中定义的类型，无须使用前缀
      var map = new StarMap
    }
    
    class StarMap
  }
  
  class Ship{
    //嵌套的包可以在其父包中被同级别的其他类型直接访问
    val nav = new navigation.Navigator
  }
  
  class Fleets{
    class Fleet{
      def addShip(){
        //内层类型可以直接访问外层定义的累心
        new Ship
      }
    }
  }
}

