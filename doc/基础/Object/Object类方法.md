Object类有12个成员方法
> 
    protected Object clone()            //创建并返回此对象的一个副本。
    boolean equals(Object obj)          //指示某个其他对象是否与此对象“相等”。
    protected void finalize()           //当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
    Class<? extends Object> getClass()  //返回一个对象的运行时类。
    int hashCode()                      //返回该对象的哈希码值。
    void notify()                       //唤醒在此对象监视器上等待的单个线程。
    void notifyAll()                    //唤醒在此对象监视器上等待的所有线程。
    String toString()                   //返回该对象的字符串表示。
    void wait()                         //导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。
    void wait(long timeout)             //导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或notifyAll() 方法，或者超过指定的时间量。
    void wait(long timeout, int nanos)  //导致当前的线程等待，直到其他线程调用此对象的notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量。
    
equals方法
> 
    public boolean equals(Object obj) {  
      return (this == obj);
    } 

Java语言对equals方法的要求如下:

     1. 对称性：如果x.equals(y)返回是“true”，那么y.equals(x)也应该返回是“true”。<br/>
     2. 反射性：x.equals(x)必须返回是“true”。<br/>
     3. 类推性：如果x.equals(y)返回是“true”，而且y.equals(z)返回是“true”，那么z.equals(x)也应该返回是“true”。<br/>
     4. 一致性：如果x.equals(y)返回是“true”，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是“true”。<br/>
     5. 任何情况下，x.equals(null)，永远返回是“false”；x.equals(和x不同类型的对象)永远返回是“false”。<br/>


eqauls方法和hashCode方法

      1. 如果两个对象相同，那么它们的hashCode值一定要相同；<br/>
      2. 如果两个对象的hashCode相同，它们并不一定相同（这里说的对象相同指的是用eqauls方法比较）。<br/>
      
      
[参考文章](http://bijian1013.iteye.com/blog/1972404)