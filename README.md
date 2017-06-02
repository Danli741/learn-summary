## 学习总结

### java.lang.Object
> [Object类方法](https://github.com/liuwei1989/learn-summary/blob/master/doc/%E5%9F%BA%E7%A1%80/Object/Object%E7%B1%BB%E6%96%B9%E6%B3%95.md)

### 基础

#### 1. 基础语法
> * [Java操作符总结](https://github.com/liuwei1989/learn-summary/blob/master/doc/%E5%9F%BA%E7%A1%80/Java%E6%93%8D%E4%BD%9C%E7%AC%A6%E6%80%BB%E7%BB%93.md)
    
#### 2. 包装类（源码阅读）
> * Integer
> * Long
> * String

#### 3. 集合框架（源码阅读）
* [ArrayList实现原理](https://github.com/liuwei1989/learn-summary/blob/master/doc/%E5%9F%BA%E7%A1%80/%E9%9B%86%E5%90%88/ArrayList%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86.md)
* [ArrayList遍历方式测试](https://github.com/liuwei1989/learn-summary/blob/master/javacode/src/main/java/com/diyill/collection/ArrayListRandomAccessTest.java)
* [LinkedList实现原理](https://github.com/liuwei1989/learn-summary/blob/master/doc/%E5%9F%BA%E7%A1%80/%E9%9B%86%E5%90%88/LinkedList%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86.md)
* [HashMap实现原理](https://github.com/liuwei1989/learn-summary/blob/master/doc/%E5%9F%BA%E7%A1%80/%E9%9B%86%E5%90%88/HashMap%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86.md)
* [Java8重新认识HashMap](http://tech.meituan.com/java-hashmap.html)
* LinkedHashMap
* TreeMap
* HashSet
* TreeSet
* Queue
* Stack
* WeakHashMap
* Fail-Fast原理
* 红黑树

#### 4. 工具类
* Google guava
* Apache common lang/BeanUtils/Collections/IO/commons-dbutils
* JSON
    1. fastjson
    2. gson
    3. jackson
* Google Guice

#### 5. 高级特性
    1. 泛型
    2. 多态的实现原理
    3. Lambda
    4. 并发编程
        1. Executor框架
        2. Fork/Join
        3. happen-before
        4. 数据结构
            1. ConcurrentHashMap
            2. ConcurrentLinkedQueue
        5. 线程池
            1. 参数设置
            2. 原理
            3. 拒绝策略
            4. [线程池调整真的很重要](https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651478541&idx=1&sn=6ad7f19084ff68ab7c7d23bc35c6eccc&chksm=bd2536728a52bf6410354735f6b120b6a4898a17f36a39caac2f03c5703441db1f0281c0e602&scene=0&key=a9a3d8941685a009f06d1184e7ec8630caf4ce3b71a3b9bc9150a27942904ea19bee0497b6d86f3148a88bfa4be8ef1793d5c3a6c8a011cd087e7fbf0269ffd3ba2824bdb89ffd8e4e6eb658821dae28&ascene=0&uin=NTQ0NDc1NQ%3D%3D&devicetype=iMac+MacBookPro11%2C1+OSX+OSX+10.12.4+build(16E195)&version=12020610&nettype=WIFI&fontScale=100&pass_ticket=ojqy01xPj4MKcWlWbez1wyyCnLz5dAjwjXSWWBKal9w%3D)
        6. 线程状态
        7. Lock/Synchronized
        8. 原子操作类
        9. 并发工具类
            1. CountDownLatch
            2. Semaphore
            3. CyclicBarrier
            4. Exchanger
    5. 网络编程
        1. Socket
        2. 基本案例实现
    6. IO
        1. BIO
        2. NIO
        3. AIO
        4. IO多路复用机制详解
    7. 序列化
        1. JDK自带
        2. Google protobuf
    8. 远程调用
        1. RMI
        2. Thrift
        3. Dubbo（服务治理）
        4. gRPC


#### 6. 多线程
* [Java内存模型](https://github.com/liuwei1989/learn-summary/blob/master/doc/%E5%A4%9A%E7%BA%BF%E7%A8%8B/Java%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B.md)
* 线程通信
* 多线程同步
* Java线程池
* Runnable
* Callable
* AtomicBoolean
* AtomicInteger
* AtomicReference
* Lock
* Condition
* ReentrantLock
* ReentrantReadWriteLock
* BlockingQueue
* ConcurrentHashMap
* CopyOnWriteArrayList
* CopyOnWriteArraySet
* CountDownLatch
* CyclicBarrier
* Exchanger
* Semaphore
* Executors


#### 7. JVM
* JVM内存结构模型
* JDK1.8元数据区
    1. 认识Java虚拟机（默认Hotspot实现）
    2. 类加载机制（知道双薪委派模型）
    3. 内存模型
    4. JDK1.8元数据区
    5. GC
        1. 回收算法
        2. 垃圾收集器详解
    6. JVM监控与调优
    7. 工具
        1. jstack
        2. jmap
        3. jconsole
    8. https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA%3D%3D&mid=2651478543&idx=1&sn=09c543923b46021e5c98c3e3054a3895#wechat_redirect
    9. https://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=207606093&idx=1&sn=134b87218ff1eb6bafb54628a093da63&scene=21#wechat_redirect


#### 8. 类加载
* ClassLoader
* 类加载时机与过程
* 反射内省

### 数据库
* [事务](https://github.com/liuwei1989/learn-summary/blob/master/doc/%E6%95%B0%E6%8D%AE%E5%BA%93/%E4%BA%8B%E5%8A%A1.md)
* [MVCC浅析](https://github.com/liuwei1989/learn-summary/blob/master/doc/%E6%95%B0%E6%8D%AE%E5%BA%93/MVCC%E6%B5%85%E6%9E%90.md)
#### mysql
* 常见存储引擎
* innodb索引原理

#### redis
* 数据结构
* 用法
* 持久化

#### memcache

#### mongodb


### 框架
#### spring
#### springmvc
#### mybatis
#### zookeeper
#### MQ


### 设计模式
#### 设计模式六大原则
* 开闭原则
* 里氏代换原则
* 依赖倒转原则
* 接口隔离原则
* 迪米特法则（最少知道原则）
* 合成复用原则

#### 设计模式的分类
* 创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式
* 结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式
* 行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式

### 脚本语言
    1. python
    2. node.js

### 版本控制 常用命令
    1. svn
    2. git

### 构建方式
    1. Maven
    2. Gradle

### 安全
    1. 单项散列算法
        1. MD5
        2. SHA
    2. 对称加密
        1. DES
    3. 非对称加密
        1. RSA
        2. HTTPS

### 测试
    1. 测试用例
    2. 白盒
    3. 黑盒
    4. Junit
    5. Spring Test
    6. CmdExcetor
    
### 分布式系统
    1. 从集中式到分布式
    2. 分布式Session
        1. Session复制
        2. Session绑定
        3. Session服务器
    3. 分布式缓存
        1. Redis
        2. 一致性Hash
    4. 数据库
        1. 读写分离（主从热备）
        2. 分库
        3. 分表
    5. 一致性
        1. 分布式事务
            1. CAP
            2. BASE
            3. 2PC/3PC
            4. Paxos
        2. 分布式锁
            1. Redisson
    6. 负载均衡
        1. 硬件：F5
        2. 软件：LVS
    7. 消息队列
        1. RabbitMQ
        2. ZeroMQ
        3. ActiveMQ
        4. Kafka
    8. 服务化
        1. 服务注册与发现： Zookeeper
        2. 架构
            1. 微服务： Spring Boot/Dubbo
            2. RPC
            3. SOA
    9. 虚拟化：Docker
    10. 计算平台：实时/离线
    11. 容灾、异地多活

### 软件工程
    1. 运维
    2. 持续集成：Jenkins
    3. TDD
    4. 原则
        1. DRY
        2. 单一职责
        3. 开闭原则
        
### 数据
    1. NoSql
        1. MongoDB： 文档模型、分片
    2. 分布式缓存
        1. MemoCache
        2. Redis
    3. 关系数据库
        1. Mysql
            1. 引擎
                1. InnoDB（支持事务）
                2. MyISAM（支持全文索引）
            2. 分库分表
                1. Cobar
                2. Mycat
            3. SQL优化
                1. 索引：主键索引/组合索引
                2. explain
                3. 存储过程
            4. SQL注入：使用#而不是$
            5. 事务隔离级别（ACID）
                1. 原子性
                2. 一致性
                3. 隔离性
                4. 持久性
            6. 锁
                1. 表锁
                2. 行锁
                3. 乐观锁
                4. 悲观锁
        2. 数据库设计
            1. 范式：第一范式/第二范式/第三范式
            2. E-R图
        3. druid：http://druid.io/
    4. 搜索引擎
        1. Solr
        2. ElasticSearch
    5. 大数据
        1. Hadoop
        2. Hbase
        3. Spark
        4. Storm/jStorm
        
### Linux
    1. 发行版（Server）
        1. Ubuntu
        2. Redhat
        3. CenterOS
    2. 常用命令
        1. 查看正在执行的进程
        2. 查询指定进程ID打开的文件
        3. 杀死置顶PID的进程
        4. 计算文件的行数、字数或字符数
        5. 显示进程信息、并实时更新
        6. 调用top命令的-H选项，该选项会列出所有Linux线程
        7. 查看用户userName的进程所打开的文件
        8. 在ps命令中，-T 选项可开启线程查看。列出由进程号为xxx的进程创建的所有线程
        9. 比较两个文件
        10. 后台执行，通过在shell中输入exit来退出终端
        11. 查看正在执行的任务
        12. 多线程执行
        13. 查看进程和线程的树形结构关系
        14. ps命令-L参数显示进程，并尽量显示其LWP（线程ID）和NLWP（线程的个数）
        15. ps命令查看线程在哪个CPU上运行
        16. 取出文件的前面几行
        17. 动态查看文件变化
        18. 退回tail -f
        19. tail程序放到后台去（ctrl+z）等处理完其他事情，再用fg命令将tail命令转到前台来
        20. 查看文件夹和子目录的大小
        21. 设置定时任务
        22. 重命名文件和文件夹
        23. 复制、剪切、清空和删除
        24. Linux通信
    3. select、poll、epoll
        
### 算法与数据结构
    1. 字符串
        1. 查找匹配（KMP）
        2. 正则
    2. 数组
    3. 链表
    4. 栈
    5. 队列
    6. 树
        1. 二叉树
            1. 前序遍历
            2. 中序遍历
            3. 后序遍历
        2. B Tree/B+ Tree
        3. 红黑树
    7. 哈希
        1. 哈希冲突
        2. k-v
    8. 图
        1. BFS
        2. DFS
    9. 排序
        1. 内部排序
            1. 插入排序
                1. 直接插入排序
                2. 希尔排序
            2. 选择排序
                1. 简单选择排序
                2. 堆排序
            3. 交换排序
                1. 冒泡排序
                2. 快速排序
            4. 归并排序
            5. 基数排序
            6. 桶排序
        2. 外部排序
        
### 计算机基础
    1. 操作系统
    2. 编译原理
    3. 计算机网络
    4. 互联网协议
        1. TCP/IP
        2. HTTP1.0/2.0
        3. HTTPS
        4. OAuth 2.0
        5. REST
        6. 计算机网络协议分层体系结构