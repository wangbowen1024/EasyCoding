/*元素的比较

1.Comparable 和 Comparator（两个接口）
    两个元素相比较，通常在排序中。
    Comparable
        和自己比
        compareTo方法
    Comparator
        第三方比较器
        compare方法

    自定义比较的时候，如果是正在写的类，重写compareTo。如果是已经写好了在用了，或者是别人的，重写compare来适配。
    约定-1为小于，0为等于，1为大于。

    TimSort JDK7

2.hashCode 和 equals
    两个方法协同工作可以用来判断两个对象是都相等。
    判断过程：先比较hashCode，不一样直接判定不同，跳过equals。如果一样再equals比较值。
    Object类定义中对hashCode 和 equals要求如下：
        ·如果两个对象的equals的结果是相同的，则两个对象的hashCode的返回结果也必须是相同的
        ·任何时候覆写equals，都必须同时覆写hashCode

    如果定义对象作为Map和Set的键，那么必须覆写hashCode和equals

    怎么写hashCode?
    编写hashCode方法
        1.把某个非零的常数值，保存在一个名为result的int类型的常量中
        2.属性域f哈希码c的计算
            如果是boolean类型，true为1，false为0
            如果是byte、char、short和int类型，强制为int的值
            如果是long类型，计算(int)(f^(f>>32))
            如果是float类型，计算Float.floatToIntBits(f)
            如果是double类型，计算Double.doubleToLongBits(f)，再按照long的方法进行计算
            如果是引用类型，则调用其hashCode方法（假设其hashCode满足你的需求）
        3.代入公式result = result * 31 + c
        4.返回result

    尽量避免通过实例对象引用来调用equals方法，否则容易抛出空指针异常。推荐使用JDK7引入的Object的equals方法，源码如下，可以有效防止在equals调用时，产生的NPE，源码：
        public static boolean equals(Object a, Object b) {
            return (a == b) || (a != null && a.equals(b));
        }
 */


import java.sql.Connection;
import java.util.*;

public class ComparisonOfElements {

    public static void main(String[] args) {
        List<person> personList = new ArrayList<>(10);

        personList.add(new person(1, 5, 3, "张三"));
        personList.add(new person(1, 4, 4, "王五"));

        System.out.println("Comparable:");
        Collections.sort(personList);
        for (person p : personList)
           System.out.println(p);

        System.out.println("Comparator:");
        Collections.sort(personList, new personComparator());
        for (person p : personList)
            System.out.println(p);

        //如果注释掉hashCode,只保留equals
        //重复添加
        Set<person> hashSet = new HashSet<>();
        person a = new person(1, 5, 3, "张三");
        person b = new person(1, 5, 3, "张三");
        person c = new person(1, 4, 4, "王五");
        hashSet.add(a);
        hashSet.add(b);
        hashSet.add(c);
        //结果显示3。取消注释后，结果显示3
        System.out.println(hashSet.size());



    }

}
//一开始自定义了比较
class person implements Comparable<person> {

    private double high;
    private double weight;
    private int age;
    private String name;

    public person(double high, double weight, int age, String name) {
        this.high = high;
        this.weight = weight;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(person o) {
        //先按身高排序
        if (this.high != o.high) {
            return this.high > o.high ? 1 : -1;
        }
        //再按体重
        if (this.weight != o.weight) {
            return this.weight > o.weight ? 1 : -1;
        }
        return 0;
    }

    //如果用MAP或SET必须要实现hashCode和equals
    @Override
    public boolean equals(Object obj) {
        //如果为null，或者非本类，直接返回false
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        //如果引用指向同一个对象，返回true
        if (this == obj) {
            return true;
        }

        //需要强转来获取本类对象，因为之前已经getClass判断过了，确保是本对象
        person temp = (person)obj;
        //判断值相等，根据实际业务逻辑而定
        if (temp.getHigh() == this.getHigh() && temp.getWeight() == this.getWeight() && temp.getAge() == this.getAge()
            && name.equals(temp.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result *= 37 + this.high;
        result *= 37 + this.weight;
        result *= 37 + this.age;
        return result;
    }

    @Override
    public String toString() {
        return "Person 身高：" + this.high + ",体重：" + this.weight + "，年龄：" + this.age;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


//后来发现不好用，要改
class personComparator implements Comparator<person> {

    @Override
    public int compare(person o1, person o2) {
        //先身高
        if (o1.getHigh() != o2.getHigh()) {
            return o1.getHigh() > o2.getHigh() ? 1 : -1;
        }
        //后年龄
        if(o1.getAge() != o2.getAge()) {
            return o1.getAge() > o2.getAge() ? 1 : -1;
        }
        //最后体重
       if (o1.getWeight() != o2.getWeight()) {
           return o1.getWeight() > o2.getWeight() ? 1 : -1;
       }
        return 0;
    }
}