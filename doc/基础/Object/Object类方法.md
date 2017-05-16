> java
    protected Object clone() //创建并返回此对象的一个副本。<br/>
    boolean equals(Object obj) //指示某个其他对象是否与此对象“相等”。<br/>
    protected void finalize() //当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。<br/>
    Class<? extends Object> getClass() //返回一个对象的运行时类。<br/>
    int hashCode() //返回该对象的哈希码值。<br/>
    void notify() //唤醒在此对象监视器上等待的单个线程。<br/>
    void notifyAll() //唤醒在此对象监视器上等待的所有线程。<br/>
    String toString() //返回该对象的字符串表示。<br/>
    void wait() //导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。<br/>
    void wait(long timeout) //导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或notifyAll() 方法，或者超过指定的时间量。<br/>
    void wait(long timeout, int nanos) //导致当前的线程等待，直到其他线程调用此对象的notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量。<br/>