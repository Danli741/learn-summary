# ArrayList实现原理

## ArrayList概述
> * ArrayList是基于数组实现的，是一个动态数组。
> * ArrayList不是线程安全的，只能用在单线程环境下，多线程环境下可以考虑用Collections.synchronizedList(List   l)函数返回一个线程安全的ArrayList类，也可以使用concurrent并发包下的CopyOnWriteArrayList类。
> * ArrayList实现了Serializable接口，因此它支持序列化，能够通过序列化传输；实现了RandomAccess接口，支持快速随机访问（实际上就是通过下标序号进行快速访问）；实现了Cloneable接口，能被克隆。

## ArrayList实现

### 1. 定义
首先先来看下顶级接口Collection的定义
```java
    public interface Collection<E> extends Iterable<E> {
    	int size();
    	boolean isEmpty();
    	boolean contains(Object o);
    	Iterator<E> iterator();
    	Object[] toArray();
    	<T> T[] toArray(T[] a);
    	boolean add(E e);
    	boolean remove(Object o);
    	boolean containsAll(Collection<?> c);
    	boolean addAll(Collection<? extends E> c);
    	boolean removeAll(Collection<?> c);
    	boolean retainAll(Collection<?> c);
    	void clear();
    	boolean equals(Object o);
    	int hashCode();
    }
```
然后是接口List的定义
``` java
	public interface List<E> extends Collection<E> {
         int size();
         boolean isEmpty();
         boolean contains(Object o);
         Iterator<E> iterator();
         Object[] toArray();
         <T> T[] toArray(T[] a);
         boolean add(E e);
         boolean remove(Object o);
         boolean containsAll(Collection<?> c);
         boolean addAll(Collection<? extends E> c);
         boolean addAll( int index, Collection<? extends E> c);
         boolean removeAll(Collection<?> c);
         boolean retainAll(Collection<?> c);
         void clear();
         boolean equals(Object o);
         int hashCode();
         E get( int index);
         E set( int index, E element);
         void add( int index, E element);
         E remove( int index);
         int indexOf(Object o);
         int lastIndexOf(Object o);
         ListIterator<E> listIterator();
         ListIterator<E> listIterator( int index);
         List<E> subList( int fromIndex, int toIndex);
}
```
再看下ArrayList的定义
``` java
    public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
```
可以看出ArrayList继承AbstractList（这是一个抽象类，对一些基础的list操作进行封装，实现List、RandomAccess、Cloneable、Serializable几个接口。RandomAccess是一个标记接口，用来表明其支持快速随机访问。

### 2. 底层存储
顾名思义哈，ArrayList就是用数组实现的List容器，既然是用数组实现，当然底层用数组来保存数据
``` java
	private transient Object[] elementData;
	private int size;
```
可以看到用一个Object数组来存储数据，用一个int值来计数，记录当前容器的数据大小。
另外，细心的人会发现elementData数组是使用transient修饰的，关于transient关键字的作用简单说就是java自带默认机制进行序列化的时候，被其修饰的属性不需要维持。

会不会产生一点疑问？elementData不需要维持，那么怎么进行反序列化，又怎么保证序列化和反序列化数据的正确性？ArrayList是使用了自定义的序列化方式，看下面两个方法：
``` java
/**
     * Save the state of the <tt>ArrayList</tt> instance to a stream (that
     * is, serialize it).
     *
     * @serialData The length of the array backing the <tt>ArrayList</tt>
     *             instance is emitted (int), followed by all of its elements
     *             (each an <tt>Object</tt>) in the proper order.
     */
    private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException{
        // Write out element count, and any hidden stuff
        int expectedModCount = modCount;
        s.defaultWriteObject();

        // Write out size as capacity for behavioural compatibility with clone()
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (int i=0; i<size; i++) {
            s.writeObject(elementData[i]);
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
     * deserialize it).
     */
    private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        elementData = EMPTY_ELEMENTDATA;

        // Read in size, and any hidden stuff
        s.defaultReadObject();

        // Read in capacity
        s.readInt(); // ignored

        if (size > 0) {
            // be like clone(), allocate array based upon size not capacity
            ensureCapacityInternal(size);

            Object[] a = elementData;
            // Read in all elements in the proper order.
            for (int i=0; i<size; i++) {
                a[i] = s.readObject();
            }
        }
    }
```
elementData 是一个数据存储数组，而数组是定长的，它会初始化一个容量，等容量不足时再扩充容量（扩容方式为数据拷贝，后面会详细解释），再通俗一点说就是比如elementData 的长度是10，而里面只保存了3个对象，那么数组中其余的7个元素（null）是没有意义的，所以也就不需要保存，以节省序列化后的内存容量，好了到这里就明白了这样设计的初衷和好处，顺便好像也明白了长度单独用一个int变量保存，而不是直接使用elementData.length的原因。

### 3. 动态扩容
```java
public void ensureCapacity(int minCapacity) {
    modCount++;
    int oldCapacity = elementData.length;
    if (minCapacity > oldCapacity) {
        Object oldData[] = elementData;
        int newCapacity = (oldCapacity * 3)/2 + 1;  //增加50%+1
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
      // minCapacity is usually close to size, so this is a win:
      elementData = Arrays.copyOf(elementData, newCapacity);
    }
 }
```
从上述代码中可以看出，数组进行扩容时，会将老数组中的元素重新拷贝一份到新的数组中，每次数组容量的增长大约是其原容量的1.5倍。这种操作的代价是很高的，因此在实际使用时，我们应该尽量避免数组容量的扩张。当我们可预知要保存的元素的多少时，要在构造ArrayList实例时，就指定其容量，以避免数组扩容的发生。或者根据实际需求，通过调用ensureCapacity方法来手动增加ArrayList实例的容量。
Object oldData[] = elementData;//为什么要用到oldData[]
乍一看来后面并没有用到关于oldData， 这句话显得多此一举！但是这是一个牵涉到内存管理的类， 所以要了解内部的问题。 而且为什么这一句还在if的内部，这跟elementData = Arrays.copyOf(elementData, newCapacity); 这句是有关系的，下面这句Arrays.copyOf的实现时新创建了newCapacity大小的内存，然后把老的elementData放入。好像也没有用到oldData，有什么问题呢。问题就在于旧的内存的引用是elementData， elementData指向了新的内存块，如果有一个局部变量oldData变量引用旧的内存块的话，在copy的过程中就会比较安全，因为这样证明这块老的内存依然有引用，分配内存的时候就不会被侵占掉，然后copy完成后这个局部变量的生命期也过去了，然后释放才是安全的。不然在copy的的时候万一新的内存或其他线程的分配内存侵占了这块老的内存，而copy还没有结束，这将是个严重的事情。

### 4. 部分源码

```java
/**
     * 添加一个元素
     */
    public boolean add(E e) {
       // 进行扩容检查
        ensureCapacityInternal( size + 1);  // Increments modCount
       // 将e增加至list的数据尾部，容量+1
        elementData[size ++] = e;
        return true;
    }
 
    /**
     * 在指定位置添加一个元素
     */
    public void add(int index, E element) {
        // 判断索引是否越界，这里会抛出多么熟悉的异常。。。
        if (index > size || index < 0)
           throw new IndexOutOfBoundsException(
               "Index: "+index+", Size: " +size);
 
       // 进行扩容检查
       ensureCapacity( size+1);  // Increments modCount 
       // 对数组进行复制处理，目的就是空出index的位置插入element，并将index后的元素位移一个位置
       System. arraycopy(elementData, index, elementData, index + 1,
                      size - index);
       // 将指定的index位置赋值为element
        elementData[index] = element;
       // list容量+1
        size++;
    }
    /**
     * 增加一个集合元素
     */
    public boolean addAll(Collection<? extends E> c) {
       //将c转换为数组
       Object[] a = c.toArray();
        int numNew = a.length ;
       //扩容检查
       ensureCapacity( size + numNew);  // Increments modCount
       //将c添加至list的数据尾部
        System. arraycopy(a, 0, elementData, size, numNew);
       //更新当前容器大小
        size += numNew;
        return numNew != 0;
    }
    /**
     * 在指定位置，增加一个集合元素
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size || index < 0)
           throw new IndexOutOfBoundsException(
               "Index: " + index + ", Size: " + size);
 
       Object[] a = c.toArray();
        int numNew = a.length ;
       ensureCapacity( size + numNew);  // Increments modCount
 
       // 计算需要移动的长度（index之后的元素个数）
        int numMoved = size - index;
       // 数组复制，空出第index到index+numNum的位置，即将数组index后的元素向右移动numNum个位置
        if (numMoved > 0)
           System. arraycopy(elementData, index, elementData, index + numNew,
                          numMoved);
 
       // 将要插入的集合元素复制到数组空出的位置中
        System. arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }
 
    /**
     * 数组容量检查，不够时则进行扩容
     */
   public void ensureCapacity( int minCapacity) {
        modCount++;
       // 当前数组的长度
        int oldCapacity = elementData .length;
       // 最小需要的容量大于当前数组的长度则进行扩容
        if (minCapacity > oldCapacity) {
           Object oldData[] = elementData;
          // 新扩容的数组长度为旧容量的1.5倍+1
           int newCapacity = (oldCapacity * 3)/2 + 1;
          // 如果新扩容的数组长度还是比最小需要的容量小，则以最小需要的容量为长度进行扩容
           if (newCapacity < minCapacity)
              newCapacity = minCapacity;
            // minCapacity is usually close to size, so this is a win:
            // 进行数据拷贝，Arrays.copyOf底层实现是System.arrayCopy()
            elementData = Arrays.copyOf( elementData, newCapacity);
       }
    }
```