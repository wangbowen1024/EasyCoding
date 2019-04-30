package pers.bow.easycoding.OopAndJava;
/*数据类型
1.基本数据类型（9种）
    boolean
    byte
    char
    short
    int
    long
    float
    double
    refvar：引用变量（引用句柄）

    除了最后一个外，其他都有包装类：char对应的名为Character和int对应的Integer外，其他对包装类名就是把首字母大写即可。

    ·基本数据类型
    类型名称    默认值     大小      最小值     最大值         包装类          缓存区间
    boolean     false       1B      0(false)    1(true)         Boolean           无
    byte       (byte)0      1B        -128       127            Byte          -128 ~ 127
    char       '\u0000'     2B      '\u0000'   '\uFFFF'         Character  (char)0 ~ (char)127
    short      (short)0     2B       -2^15    2^15-1(32767)     Short         -128 ~ 127
    int           0         4B       -2^31      2^31-1          Integer       -128 ~ 127
    long          0L        8B       -2^63      2^63-1          Long          -128 ~ 127
    float        0.0f       4B      1.4e-45     3.4e+38         Float             无
    double       0.0d       8B      4.9e-324    1.798e+308      Double            无



    引用变量（refvar）：均占4B
    引用指向的实际对象（Referred Object ，简称refobj）：
        不论是多么小的对象，最少占用空间12B（用于存储基本信息，称为对象头），但由于存储空间分配必须是8B的倍数，所以初始分配空间至少是16B。

    对象分为三块存储区
        ·对象头（12B）
            对象标记：哈希码、[GC标记]、[GC次数]、[同步锁标记]、[偏向锁持有者]。占用8B，存储格式与JVM具体实现有关。
            类元信息：存储对象指向它的类元数据即首地址，占用4B
        ·实例数据：存储本类的实例成员变量和所有可见的父类成员变量。
        ·对齐填充：对象的存储空间分配单位是8个字节，所以不足8的倍数会自动填充

2.包装类型
    解决了基本数据类型无法做到的事情：泛型类型参数、序列化、类型转换、高频区间数据缓存，尤其是最后一项。
    推荐所有包装类对象之间值的比较都用equals()方法。（因为超出缓存区间的值就无法用==比较了，在缓存区间内时，对象是由IntegerCache.cache产生的，会复用已有对象，所以可以用==比较）

    对6个包装类直接赋值时，就是调用对应包装类的静态工厂方法。以Integer为例：
    public static Integer valueOf(int i) {
        if(i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
    所以，推荐使用valueOf()，合理的利用缓存，提升程序性能。各包装类缓存区间，在上表。

    其中，Integer是唯一一个可以修改缓存范围的包装类，在VM options 加入参数 -XX:AutoBoxCacheMax=7777，即可设置最大缓存为7777

    在选择使用包装类还是基本数据类型的时候，推荐使用如下方法：
        ·所有的POJO（简单Java对象）类属性必须使用包装数据类型
        ·RPC方法返回值和参数必须使用包装数据类型
        ·所有的局部变量推荐使用基本数据类型

3.字符串
    String
        ·只读字符串
        ·String对象赋值操作后，会在常量池中进行缓存，如果下次申请创建对象时，缓存已经存在，则直接返回相应引用
    StringBuffer
        ·在原对象上进行修改，是线程安全的
    StringBuilder
        ·非线程安全的，把是否需要进行多线程加锁交给工程师决定，操作效率比StringBuilder高

    注意！在非基本数据类型的对象中，String是仅支持直接相加操作的对象。这样操作比较方便，但在循环体内，字符串的连接方式应该使用StringBuilder的append方法进行扩展



 */
public class dataType {
    public static void main(String[] args) {
        //测试Integer缓存区间-128 ~ 127
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
        Integer e = -128;
        Integer f = -128;
        System.out.println(e == f);
        Integer g = -129;
        Integer h = -129;
        System.out.println(g == h);
        System.out.println("equals 方法：" + g.equals(h));

        //String进行循环体拼接是不推荐的
        //在这段代码的内部实现逻辑是每次循环都会new一个StringBuilder对象，然后进行append操作，最后通过toString方法返回String对象，
        //不仅内存资源浪费，且性能更差
        String str = "start";
        for(int i = 0; i < 100; i++) {
            str = str + "hello";
        }
        //对字符串修改的时候，推荐使用如下
        StringBuffer sBuffer = new StringBuffer("start：");
        sBuffer.append("one-");
        sBuffer.append("two-");
        sBuffer.append("three");
        System.out.println(sBuffer);

    }
}
