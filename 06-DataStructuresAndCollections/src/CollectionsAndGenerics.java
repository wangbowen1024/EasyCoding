/*集合与泛型

List：泛型出来前的集合定义方式
List<Object>：似乎没区别，但是有限制
    List<Object> a1 = new ArrayList();
    List<Integer> a2 = a1;// 报错
    反过来也是错，数组可以这样赋值，因为它是协变的，但是集合不是。

List<?>：在没有赋值前，表示它可以接受任何类型的集合赋值，赋值之后就不能随意往里面添加元素了。
    <? extends T>
        可以赋值给任何T及T子类的集合，上界为T。
        null可以表示任何类型，所以除null外，任何元素不能添加进<? extends T>集合内。
        可以返回带类型的元素，但是只能返回自身及父类对象，因为子类类型被擦除了。（取出来的类型带有泛型限制，向上强制转型为T。）
    <? super T>
        可以赋值给任何T以及T的父类集合，下界为T。
        可以往里面添加元素，但是只能添加自身及子类对象。
        可以进行get操作，但是类型丢失，即只能返回Object对象。

    如果只是取，用<? extends T>；如果经常放的话，<? super T>


 */

public class CollectionsAndGenerics {
}
