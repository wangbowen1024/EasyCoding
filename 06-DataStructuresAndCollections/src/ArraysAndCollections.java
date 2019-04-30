/*数组与集合

数组的遍历
    推荐使用foreach的方式

数组与集合的转换
    数组转集合：
        Arrays.asList()为例，将数组转集合的时候，不能使用其修改相关的方法。add/remove/clear方法会抛出异常。
        通过set()方法，可以成功的修改值（间接对原数组进行修改），但是不能进行修改元素个数的操作，均抛出异常。
        为什么？
        asList的返回是一个Arrays的内部类，它并没有实现几个个数相关的修改方法。
        Arrays.asList 源码：
            public static <T> List<T> asList(T... a) {
                return new ArrayList<>(a);
            }
        这里的ArrayList非彼ArrayList，虽然Arrays与ArrayList同属一个包，但是在Arrays类中还定义了一个ArrayList的内部类。
        在这个内部类中有一个private final E[] a; 构造函数直接把数组引用赋值给a，且只实现了set方法。

        所以，需要用java.util.ArrayList直接创建一个新集合，参数就是Arrays.asList返回的不可变集合，如：
            List<Object> objectList = new java.util.ArrayList<Object>(Arrays.asList(数组));

    集合转数组：
        Arrays.toArray()方法
        当适配别人的数组接口，或者进行局部方法计算等时候，需要集合转数组。
        1.不要用toArray()无参方法把集合转成数组，会导致泛型丢失。如：
            Object[] array1 = list.toArray();
        2.数组长度大于等于集合元素个数
        转化为数组时，注意需要传入类型完全一样的数组，并且它的容量大小为list.size()。因为根据实验，当数组大小等于list大小的时候，总是最快的，空间消耗也是最少的。


 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ArraysAndCollections {

    public static void main(String[] args) {

        //foreach方式遍历
        int[] a = {0, 1, 2, 3};
        for (int ele : a) {
            System.out.println(ele);
        }
        //下标方式
        for (int i = 0; i < a.length ;i++) {
            System.out.println(a[i]);
        }
        //数组转集合
        String[] stringArray = new String[3];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";

        List<String> stringList = Arrays.asList(stringArray);
        //修改转换后的集合
        stringList.set(0, "oneList");
        //修改了原来的数组的值
        System.out.println(stringArray[0]);

        //重点！编译正确，运行抛出异常
        //stringList.add("four");
        //stringList.remove(2);
        //stringList.clear();

        //要想得到可操作的集合
        List<String> objectList = new java.util.ArrayList<String>(Arrays.asList(stringArray));
        objectList.add("four");
        for (String ele : objectList) {
            System.out.println(ele);
        }

        //集合转数组，数组长度小于集合元素个数
        String[] array2 = new String[2];
        objectList.toArray(array2);
        System.out.println(Arrays.asList(array2));
        //集合转数组，数组长度等于集合元素个数
        String[] array3 = new String[4];
        objectList.toArray(array3);
        System.out.println(Arrays.asList(array3));
        //集合转数组，数组长度大于集合元素个数
        String[] array4 = new String[6];
        objectList.toArray(array3);
        System.out.println(Arrays.asList(array3));
    }
}
