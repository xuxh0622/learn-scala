package navigation{
  class Navigator{
    
    protected[navigation] def useStarChar(){}
    
    class LegOfJourneg{
      private[Navigator] val distance = 1000
    }
    //只允许在定义该成员的类型中访问
    private[this] var speed = 200
  }
}

package launch{
  import navigation._
  object Vehicle{
    private[launch] val guide = new Navigator
  }
}