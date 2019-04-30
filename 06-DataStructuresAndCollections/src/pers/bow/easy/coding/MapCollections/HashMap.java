package pers.bow.easy.coding.MapCollections;

/*HashMap

除局部方法或绝对线程安全的情形外，优先推荐使用ConcurrentHashMap。二者虽然性能相差无几，但后者解决了高并发下的线程安全问题。
HashMap的死链问题及扩容数据丢失问题是慎用HashMap的两个主要原因。

某个案例：应用启动过程中仅单线程调用了一次初始化init()方法，不应该有任何问题。但巧合的是，实行了两次init()，启动失败、CPU飙升，dump分析是死链问题。
    解决方案：
        ·用ConcurrentHashMap代替HashMap
        ·用Collections.synchronizedMap(hashMap)包装成同步集合
        ·对init()进行同步操作
    最终选用第三个方法，毕竟只有启动时调用而已。

哈希类集合的三个基本存储概念：table（存储所有节点数据的数组）、slot（哈希槽）、bucket（哈希桶）

死链问题：
    JDK7：


 */
public class HashMap {
}
