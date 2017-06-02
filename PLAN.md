### 基础
#### 1. 基础语法
#### 2. 集合框架（源码阅读）
    1. List
        1. ArrayList
        2. LinkedList
    2. Set
        1. HashSet
        2. TreeSet
    3. Map
        1. HashMap ： JDK8的实现和之前版本不同
        2. TreeMap
        3. CurrentHashMap
    4. Queue
        1. CurrentLinkedQueue
#### 3. 工具类
    1. Google guava
    2. Apache common lang/BeanUtils/Collections/IO
    3. JSON
        1. fastjson
        2. gson
        3. jackson
#### 4. 高级特性
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
    7. 序列化
        1. JDK自带
        2. Google protobuf
    8. 远程调用
        1. RMI
        2. Thrift
        3. Dubbo（服务治理）
        4. gRPC
#### 5. JVM
    1. 认识Java虚拟机（默认Hotspot实现）
    2. 类加载机制（知道双薪委派模型）
    3. 内存模型
    4. GC
        1. 回收算法
        2. 垃圾收集器
    5. 调优
    6. 工具
        1. jstack
        2. jmap
        3. jconsole
#### 6. 设计模式
    1. 工厂模式
    2. 代理模式
    3. 门面模式
    4. 观察者模式
    5. 责任链模式
    6. 适配器模式
    7. 装饰着模式
    8. 单例模式
#### 7. JavaEE开发
    1. JSP/Servlet 3.x
    2. Session/Cookie
    3. jstl/el
#### 8. 框架 
    1. Spring
        1. IOC
        2. AOP
        3. 常用注解
            1. @Component： 标识该类需要Spring初始化时自动装配，可以是一个普通的bean
            2. @Resource：被该注释修饰的字段或方法，Spring会通过by-name的方式自动注入
            3. @Required：应用于bean属性的setter方法，它表明受影响的bean属相在配置时必须放在XML配置文件中，否则容器就会抛出一个BeanInitializtionException异常
            4. @AutoWired：可以在setter方法中被用于自动连接bean
            5. @Value：可以为普通方法和构造方法中的参数或者字段指定一个默认值
            6. @Qualifier：指定哪个真正的bean将会被装配，用于一个接口有多个实现类的情况
            7. @Service：标注一个业务逻辑处理类
            8. @Repository：标注一个DAO组件类
            9. @RequestMapping：指定请求路径
            10. @Controller：标注一个控制器组件类
            11. @ResposeBody：返回json结果数据
    2. Spring MVC
    3. Mybatis
    4. Shiro
    5. Netty
#### 9. 版本控制
    1. git
    2. svn
#### 10. 构建方式
    1. Maven
    2. Gradle
#### 11. 安全
    1. 单项散列算法
        1. MD5
        2. SHA
    2. 对称加密
        1. DES
    3. 非对称加密
        1. RSA
        2. HTTPS
#### 12. 测试
    1. 测试用例
    2. 白盒
    3. 黑盒
    4. Junit
    5. Spring Test
    6. CmdExcetor
#### 13.分布式系统
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
#### 14. 软件工程
    1. 运维
    2. 持续集成：Jenkins
    3. TDD
    4. 原则
        1. DRY
        2. 单一职责
        3. 开闭原则
#### 15. 数据
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
        3. 其他
    4. 搜索引擎
        1. Solr
        2. ElasticSearch
    5. 大数据
        1. Hadoop
        2. Hbase
        3. Spark
        4. Storm/jStorm
#### 16. Linux
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
#### 17. 算法与数据结构
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
#### 18. 计算机基础
    1. 操作系统
    2. 编译原理
    3. 计算机网络
    4. 互联网协议
        1. TCP/IP
        2. HTTP1.0/2.0
        3. HTTPS
        4. OAuth 2.0
        5. REST
#### 19. 项目