/*线程池

作用：
    ·利用线程池管理并复用线程、控制最大并发数
    ·实现任务线程队列缓存策略和拒绝机制
    ·实现某些与时间相关的功能，如定时执行、周期执行
    ·隔离线程环境（比如，交易服务和搜索服务在同一个服务器上，两个线程池中）

ThreadPoolExecutor(
        int corePoolSize;// 常驻核心线程数
        int maximumPoolSize;// 能够容纳同时执行的最大线程数，如果和corePoolSize相同就是固定大小线程池
        long keepAliveTime;// 空闲时间，达到线程会被销毁，直到只剩下corePoolSize为止，如果allowCoreThreadTimeOut为true，核心线程超时也会被回收
        TimeUnit unit;// 时间单位，通常是TimeUnit.SECONDS
        BlockingQueue<runnable> workQueueL;// 缓存队列。当请求线程数大于maximumPoolSize时候，线程进入BlockingQueue阻塞队列
        ThreadFactory threadFactory;// 线程工厂。线程池的命名时通过给这个factory添加组名前缀实现的
        RejectedExecutionHandler handler;// 执行拒绝策略的对象。友好的拒绝策略可以是：
            ·保存到数据库进行削峰填谷。在空闲时再提取出来执行
            ·转向某个提示页面
            ·打印日志
        );

    队列、线程工厂、拒绝处理服务都必须有实例对象。但是实际很多通过Executors这个线程池静态工厂提供默认实现。
    通过Executors的静态工厂方法可以创建三个线程池的包装对象：ForkJoinPool、ThreadPoolExecutor、ScheduledThreadPoolExecutor。
    Executors核心方法有5个（可以用ExecutorService接受返回值）：
        ·Executors.newWorkStealingPool：JDK8引入，创建持有足够线程的线程池支持给定的并行度，并通过使用多个队列减少竞争，构造方法中把CPU数量设置为默认的并行度
        ·Executors.newCacheThreadPool：maximumPoolSize最大可以至Integer.MAX_VALUE。keepAliveTime默认60秒，空闲回收，任务增加，创建新线程
        ·Executors.newScheduledThreadPool：最大数同上，支持定时及周期性任务执行。相比Timer,ScheduleExecutorService更安全，功能更强大，与newCacheThreadPool区别是不回收工作线程
        ·Executors.newSingleThreadExecutor：创建一个单线程的线程池
        ·Executors.newFixedThreadPool：输入的参数即是固定线程数，即是核心线程数也是最大线程数，不存在空闲线程，所以keepAliveTime为0

    使用LinkedBlockingQueue这样无界队列，如果瞬间请求非常大，容易OOM。除newWorkStealingPool外，其他4个创建方式都存在资源耗尽的风险。

    Executor中默认的线程工厂和拒接服务策略过于简单，通常对用户不够友好（可以自己实现这2个类）：
        线程工厂：需要做创建前的准备工作，对线程池创建的线程必须明确标识。为线程本身指定有意义的名称和相应序列号。
        拒绝策略：应考虑到业务场景，返回相应的提示或友好的跳转。

    Executors只有一个方法execute，通过参数传入待执行线程的对象。

    源码分析：ThreadPoolExecutor、execute方法、addWorker方法、Worker类

    使用线程池要注意以下几点：
        ·合理设置各类参数
        ·应根据实际业务场景来设置合理的工作线程数
        ·创建线程或线程池时请指定有意义的线程名称，方便出错时回溯


 */

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {


}
