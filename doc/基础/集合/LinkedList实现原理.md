# LinkedList实现原理(JDK1.7)

LinkedList是基于链表结构的一种List，在分析LinkedList源码前有必要对链表结构进行说明。
## 链表的概念
链表是由一系列非连续的节点组成的存储结构，简单分下类的话，链表又分为单向链表和双向链表，而单向/双向链表又可以分为循环链表和非循环链表，下面简单就这四种链表进行图解说明。

1. 单向链表
单向链表就是通过每个结点的指针指向下一个结点从而链接起来的结构，最后一个节点的next指向null。<br/>
![单向链表](http://images2015.cnblogs.com/blog/681047/201512/681047-20151214224723037-812736243.jpg)

2. 单向循环链表
单向循环链表和单向链表的不同是，最后一个节点的next不是指向null，而是指向head节点，形成一个“环”。<br/>
![单向循环链表](http://images2015.cnblogs.com/blog/681047/201512/681047-20151214224745021-970878279.jpg)

3. 双向链表
从名字就可以看出，双向链表是包含两个指针的，pre指向前一个节点，next指向后一个节点，但是第一个节点head的pre指向null，最后一个节点的tail指向null。<br/>
![双向链表](http://images2015.cnblogs.com/blog/681047/201512/681047-20151214224802709-397855279.jpg)

4. 双向循环链表
双向循环链表和双向链表的不同在于，第一个节点的pre指向最后一个节点，最后一个节点的next指向第一个节点，也形成一个“环”。<br/>
![双向循环链表](http://images2015.cnblogs.com/blog/681047/201512/681047-20151214224821724-1683724484.jpg)<br/>
更形象的解释下就是：双向循环链表就像一群小孩手牵手围成一个圈，第一个小孩的右手拉着第二个小孩的左手，第二个小孩的左手拉着第一个小孩的右手。最后一个小孩的右手拉着第一个小孩的左手。



## LinkedList定义
``` java
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable,java.io.Serializable
```

根据LinkedList的定义，我们可以知道： 

（1）LinkedList可以进行所有List的操作，因为其实现了List接口，同时LinkedList可以存放任何元素，包括null； 

（2）所有根据索引的查找操作都是按照双向链表的需要执行的，根据索引从前或从后开始搜索，并且从最靠近索引的一端开始。例如一个LindedList有5个元素，如果调用了get(2)方法，LinkedList将会从头开始搜索；如果调用get(4)方法，那么LinkedList将会从后向前搜索。这样做的目的可以提升查找效率。那如何做到这一点呢？在LinkedList内部有一个Node(int index)方法，它会判断从头或者从后开始查找比较快。代码如下：
``` java
Node<E> node(int index) {
    // assert isElementIndex(index);
    if (index < (size >> 1)) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    } else {
        Node<E> x = last;
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x;
    }
}
```
（3）LinkedList不是线程安全的，所以在多线程的环境下使用LinkedList需要注意LinkedList类型变量的线程同步问题。当然，有一种方式可以创建一个线程安全的LinkedList： 
``` java
List list = Collections.synchronizedList(new LinkedList(…)); 
```
（4）LinedList的迭代器 iterator 和 listIterator 方法返回的迭代器是快速失败 的。所谓快速失败，意思就是如果在迭代器已经创建了的情况下，任何时刻对LinkedList结构的修改，迭代器将会抛出一个ConcurrentModificationException异常。


## LinkedList节点数据结构
LinkedList每个节点是一个Node类型的实例，每个Node实例除了保存节点的真实值（即真实数据）外，还保存了这个节点的前一个节点的引用和后一个节点的引用，这样就实现了双线链表的数据结构。Node数据结构如下：
``` java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
```
从代码中我们可以看到，当创建一个Node节点时，我们需要传入三个参数，第一个参数就是当前节点的前驱节点，第二个就是节点的真实数据，第三个就是节点的后继节点。


## 常用方法具体实现
1、add(E e)方法：add(E e)方法实际上调用的是linkLast(E e)方法，意思是把方法加到链表的最后。下面看看linkLast(E e)方法的具体实现： 
``` java
 void linkLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
    if (l == null)
        first = newNode;
    else
        l.next = newNode;
    size++;
    modCount++;
}
```
从代码中我们可以看到，代码中使用了变量first和last，这两个变量分别保存了当前链表第一个节点和最后一个节点的引用。在新增一个节点之前，首先把指向最后一个节点的引用（即变量 last）保存起来（即变量 l），然后新建一个节点，指定前驱节点是原来链表的最后一个节点，然后把指向最后一个节点的引用（last）指向新建的节点。紧接着就设置新建节点的前驱节点的后继节点指向新增的节点，最后把整个链表的总数加1，完成了新增一个节点的操作。

2、add(int index, Ee)方法：add(int index, Ee)方法可以指定把某个数据插入指定的位置。我们首先看下源码：
``` java
public void add(int index, E element) {
    checkPositionIndex(index);

    if (index == size)
        linkLast(element);
    else
        linkBefore(element, node(index));
}
```
从源码中我们可以看到，方法一开始调用了checkPositionIndex(index)方法，这个方法主要的作用是判断指定的index是否越界，如果越界就抛出IndexOutOfBoundsException异常，从方法的注释我们也能看出来。在LinkedList源码中，很多方法都会调用这个方法去判断指定的index是否越界，比如set(int index, E e)方法。如果指定的index是合法的，那么接下来就判断指定的index是否与LinkedList的size是否相等，如果相等，那么就直接把节点加到后面即可。如果不相等，则调用linkBefore(element, node(index))方法。这里我们可以看到，linkBefore方法的第二个参数是通过调用node(index)的返回值当作参数的，这个方法前面已经讲解过。通过node(index)方法获取指定索引的节点，其实这个方法返回的节点会当作新增节点的后继节点，通过查看linkBefore里的具体源码我们就知道原因： 
``` java
 void linkBefore(E e, Node<E> succ) {
    // assert succ != null;
    final Node<E> pred = succ.prev;
    final Node<E> newNode = new Node<>(pred, e, succ);
    succ.prev = newNode;
    if (pred == null)
        first = newNode;
    else
        pred.next = newNode;
    size++;
    modCount++;
}
```
从linkBefore方法我们可以看到，在创建新节点时，同时指定了前驱节点和后继节点，这里后继节点就是我们传进来的第二个参数，所以验证了我们之前所说的第二个参数即为新增节点的后继节点的说法。在创建节点之前，我们把后继节点的前驱节点的引用先保存到一个pred变量中，然后创建一个新的节点，并指定前驱节点和后继节点；接着把后继节点的前驱节点引用指向了新的节点，这样新的节点就可以找到后继节点，接下来根据前驱节点如果为空，则更改first指向新建的节点，否则将前驱节点指向后继节点的引用指向新建的节点，最后把LinkedList的size加1。

通过以上两个方法，我们可以知道Java中的LinkedList的底层实现原理，底层是用一个双向链表的数据结构来保存数据。链表中一个节点是一个Node类型的数据结构，其保存了一个指向前驱节点的引用、真实数据和一个指向后继节点的引用。对LinkedList的操作实际上是对指向前驱节点和后继节点的引用操作。因为LinkedList采用双线链表作为底层的数据结构，所以其插入和删除效率较高，但是随机访问效率较差，因为要遍历。 

下面再看几个方法的实现源码： 
remove(int index)： 
``` java
public E remove(int index) {
    checkElementIndex(index);
    return unlink(node(index));
}
```
``` java
E unlink(Node<E> x) {
    // assert x != null;
    final E element = x.item;
    final Node<E> next = x.next;
    final Node<E> prev = x.prev;

    if (prev == null) {
        first = next;
    } else {
        prev.next = next;
        x.prev = null;
    }

    if (next == null) {
        last = prev;
    } else {
        next.prev = prev;
        x.next = null;
    }

    x.item = null;
    size--;
    modCount++;
    return element;
}
```

[JDK1.6与JDK1.7 LinkedList实现原理的区别](http://blog.csdn.net/tiwerbao/article/details/8227689)