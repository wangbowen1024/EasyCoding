package pers.bow.easy.coding.MapCollections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*Map类集合

Map接口除提供了传统的增删改查方式外，还有3个特有的方法
    返回所有Key：Set<K> keySet();
    返回所有Value：Collection<V> values();
    返回所有KV键值对：set<Map.Entry<K, V>> entrySet();

    通常这些返回的视图是支持清除操作的，但是修改和添加元素会抛出异常，因为AbstractCollection没有实现add操作，但是实现了remove、clear等相关操作。
    所以在使用这些视图返回的集合时，主要不要操作此类的相关方法。

    是否将KV设置为null，以实现类的约束为准，这是一个十分难以记忆的知识点，如下：
    Map集合类              Key             Value           Super          JDK          说明
    Hashtable           不允许为null     不允许为null      Dictionary     1.0          线程安全（过时）
    ConcurrentHashMap   不允许为null     不允许为null      AbstractMap    1.5          锁分段技术或CAS（JDK8及以上）
    TreeMap             不允许为null      允许为null       AbstractMap    1.2          线程不安全（有序）
    HashMap              允许为null       允许为null       AbstractMap    1.2          线程不安全（resize死链问题）

    大多数情况下，直接使用ConcurrentHashMap代替HashMap没有任何问题，性能上区别不大，而且更加安全。但是后者允许为null，前者不行。
    所以，在任何Map类集合中，都要尽量避免KV设置为null值。

 */
public class Maps {

    public static void main(String[] args) {
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(0, "zero");
        testMap.put(1, "one");
        testMap.put(2, "two");
        testMap.put(3, "two");

        Set<Integer> s1 = testMap.keySet();
        Collection<String> c = testMap.values();
        Set<Map.Entry<Integer, String>> s2 = testMap.entrySet();
        System.out.println(s1);
        System.out.println(c);
        System.out.println(s2);
        System.out.println("--------------------");
        //对视图集合进行添加操作
        //以下代码报错
        //s1.add(5);

        //进行视图删除KEY操作,会影响原Map
        s1.remove(0);
        System.out.println(testMap.entrySet());

        //删除VALUE操作，也会影响，不过只删除第一个值=VALUE的
        c.remove("two");
        System.out.println(testMap.entrySet());

        //删除KV视图，也会影响
        s2.clear();
        System.out.println(testMap.entrySet());

        System.out.println("---------------------");

        //线程安全的hashMap
        ConcurrentHashMap<Integer, String> testMap2 = new ConcurrentHashMap<>();
        testMap2.put(0, "zero");
        testMap2.put(1, "one");
        testMap2.put(2, "two");

        //使用JDK8新特性遍历
        testMap2.keySet().stream().forEach(x -> System.out.println(x));
        testMap2.values().stream().forEach((x) -> {
            System.out.println(x);
        });
       testMap2.entrySet().stream().forEach(System.out::println);


    }

}
