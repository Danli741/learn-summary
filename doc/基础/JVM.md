## JVM基础知识

> 假设你是一个普通的 Java 对象，你出生在 Eden 区，在 Eden 区有许多和你差不多的小兄弟、小姐妹，可以把 Eden 区当成幼儿园，在这个幼儿园里大家玩了很长时间。Eden 区不能无休止地放你们在里面，所以当年纪稍大，你就要被送到学校去上学，这里假设从小学到高中都称为 Survivor 区。开始的时候你在 Survivor 区里面划分出来的的“From”区，读到高年级了，就进了 Survivor 区的“To”区，中间由于学习成绩不稳定，还经常来回折腾。直到你 18 岁的时候，高中毕业了，该去社会上闯闯了。于是你就去了年老代，年老代里面人也很多。在年老代里，你生活了 20 年 (每次 GC 加一岁)，最后寿终正寝，被 GC 回收。有一点没有提，你在年老代遇到了一个同学，他的名字叫爱德华 (慕光之城里的帅哥吸血鬼)，他以及他的家族永远不会死，那么他们就生活在永生代。

- 年轻代
- 年老代
- 永久代

