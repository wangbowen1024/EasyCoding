/*异常

1.异常分类
    所有异常都是Throwable的子类，分别Error（致命异常）和Exception（非致命异常）
    Exception又分为checked异常（受检异常）和unchecked异常（非受检异常）


2.try代码块
    try-catch-finally
    注意：
        ·finally是必选执行的代码块，如果try里又System.exit()则不会执行。
        ·finally是在return表达式运行后执行的，此时将要return的结果已经暂存起来，待finally代码块执行结束后再将之前暂存的结果返回。
        ·在finally代码块中使用return语句，使返回值判断变得复杂，不要这样写。
        ·在try之前调用lock()方法，防止finally中unlock()抛出异常


 3.异常的抛与接
    推荐对外提供的开放接口使用错误码；
    公司内部跨应用远程服务调用优先考虑使用Result对象来封装错误码、错误秒描述信息；
    而应用内部推荐直接抛出异常对象






 */

public class Exceptions {
    public static int finallyNotWork() {
        int temp = 1000;
        try {
            throw new Exception();
        } catch (Exception e) {
            return ++temp;
        } finally {
            temp = 999;
        }
    }

    public static void main(String[] args) {
        //2
        System.out.println(finallyNotWork());
    }
}
