## jvm常用命令

### 1. jps
作用：
> 显示系统中所有Hotspot虚拟机进程。
    
参数：
> -l ：输出主类全名。
> -v：输出虚拟机进程启动的jvm参数。
> -m：输出启动时传递给main函数的参数。
> -q：只输出LVMID，省略主类的名称。
    
示例：
> ➜ ~ jps 
> ➜ ~ jps -l 
> ➜ ~ jps -v 
> ➜ ~ jps -m 
> ➜ ~ jps -q 
    
### 2. jinfo
作用：
> 显示虚拟机的配置信息，可观察进程运行环境参数，包括Java System属性和JVM命令行参数。
    
参数：
> -flag< name >: 打印指定Java虚拟机的参数值。
> -flag [+|-]<name     >：设置或取消指定java虚拟机参数的布尔值。
> -flag < name >=< value >：设置指定java虚拟机的参数的值。
    
示例：
> ➜ ~ jinfo 10565 
➜ ~ jinfo -flag CICompilerCount 10565 
➜ ~ jinfo -flag +PrintGCDetails 
➜ ~ jinfo -flag -PrintGCDetails 10532 
➜ ~ jinfo -flag CMSInitiatingOccupancyFraction=80 10532 
    
### 3. jstack
作用：
> 显示虚拟机的线程栈信息，用于生成当前JVM的所有线程快照。
    
参数：
> -F：当正常输出的请求不被响应时，强制输出线程堆栈。
-l：除堆栈外，显示关于锁的附加信息。
-m：如果调用到本地方法的话，可以显示C/C++的堆栈 
命令格式:jstack [option] vmid。

示例：
> ➜ ~ jstack -F 10532 
➜ ~ jstack -l 10532 
➜ ~ jstack -m 10532 
    
### 4. jstat
作用：
> 实时显示本地或远程JVM进程中类装载、内存、垃圾收集、JIT编译等数据。
    
参数：
> * -class：监视类装载、卸载数量、总空间及类装载所耗费的时间。
> * -gc：监听Java堆状况，包括Eden区、两个Survivor区、老年代、永久代等的容量，以用空间、GC时间合计等信息。
> * -gccapacity：监视内容与-gc基本相同，但输出主要关注java堆各个区域使用到的最大和最小空间。
> * -gcutil：监视内容与-gc基本相同，但输出主要关注已使用空间占总空间的百分比。
> * -gccause：与-gcutil功能一样，但是会额外输出导致上一次GC产生的原因。
> * -gcnew：监视新生代GC状况。
> * -gcnewcapacity：监视内同与-gcnew基本相同，输出主要关注使用到的最大和最小空间。
> * -gcold：监视老年代GC情况。
> * -gcoldcapacity：监视内同与-gcold基本相同，输出主要关注使用到的最大和最小空间。
> * -gcpermcapacity：输出永久代使用到最大和最小空间。
> * -compiler：输出JIT编译器编译过的方法、耗时等信息。
> * -printcompilation：输出已经被JIT编译的方法。

示例：
> ➜ ~ jstat -class 10532 
➜ ~ jstat -gc 10532 
➜ ~ jstat -gccapacity 10532 
➜ ~ jstat -gcutil 10532 
➜ ~ jstat -gccause 10532 
➜ ~ jstat -gcnew 10532 
➜ ~ jstat -gcnewcapacity 10532 
➜ ~ jstat -gcold 10532 
➜ ~ jstat -gcoldcapacity 10532 
➜ ~ jstat -compiler 10532 
➜ ~ jstat -printcompilation 10532 
    
### 5. jmap

作用：
> 用于生成虚拟机的内存快照信息
    
参数：
> * -dump：生成java堆转储快照。
> * -heap：显示java堆详细信息(只在Linux/Solaris下有效)。
> * -F：当虚拟机进程对-dump选项没有响应时，可使用这个选项强制生成dump快照(只在Linux/Solaris下有效)。
> * -finalizerinfo：显示在F-Queue中等待Finalizer线程执行finalize方法的对象(只在Linux/Solaris下有效)。
> * -histo：显示堆中对象统计信息。
> * -permstat：以ClassLoader为统计口径显示永久代内存状态(只在Linux/Solaris下有效)。

示例：
> ➜ ~ jmap -heap 10532 
➜ ~ jmap -histo 10532 | more 
➜ ~ jmap -F 10532 
➜ ~ jmap -finalizerinfo 10532 
    
### 6. jconsole

作用：
> 内置 Java 性能分析器，可以从命令行或在 GUI shell 中运行。可使用 JConsole来监控 Java 应用程序性能和跟踪 Java 中的代码。

### 7. gc相关术语
    S0C：S0区容量（S1区相同，略） 
    S0U：S0区已使用 
    EC：E区容量 
    EU：E区已使用 
    OC：老年代容量 
    OU：老年代已使用 
    PC：Perm容量 
    PU：Perm区已使用 
    YGC：Young GC（Minor GC）次数 
    YGCT：Young GC总耗时 
    FGC：Full GC次数 
    FGCT：Full GC总耗时 
    GCT：GC总耗时