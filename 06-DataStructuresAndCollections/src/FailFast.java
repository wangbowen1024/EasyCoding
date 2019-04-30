/*fail-fast机制

fail-fast机制是集合世界中比较常见的错误检测机制，通常出现在遍历集合元素的过程中。

主列表和子列表的关系
List branchList = masterList.subList(0, 3);
    ·子列表无法序列化（即不能网络传输）
    ·子列表的修改会导致主列表的修改
    ·主列表的修改会导致子列表操作时怕抛出异常
    ·可以使用Iterator机制进行遍历删除，如果时多线程，还需要在Iterator遍历时加锁。如下源码：
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            synchronized(对象) {
                String item = iterator.next();
                if (删除元素的条件) {
                    iterator.remove();
                }
            }
        }
      或者可以用并发容器CopyOnWriteArrayList代替ArrayList，该容器内部会对Iterator进行加锁操作
        这里介绍COW（奶牛）家族，即Copy-On-Write（是fail-safe机制，并发包的集合中都是由这种机制实现的）：
            这是一种并发的新思路，实行读写分离，如果是写操作，则复制一个新集合，在新集合内添加或删除元素。待一切修改完后，再将原集合的引用指向新集合。
            好处：可以高并发地对COW进行读和遍历的操作，而不需要加锁
            注意：
                尽量设置合理的容量初始值，它扩容代价比较大。
                使用批量添加或删除方法，如addAll或removeAll操作，在高并发请求下，可以攒一下要添加或删除的元素，避免添加一个元素复制整个集合。
            缺点：读取不到最新的数据（CAP理论中一致性与可用性矛盾）

 */

public class FailFast {
}
