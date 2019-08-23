package com.custom.feng.smallcasepractice.thread;

/**
 * 内存可见性问题: 当多个线程操作共享数据时，彼此不可见
 * 代码直接运行, 会陷入死循环
 * 主线程读取flag值时, 此时为false, 故在此处形成死循环
 * RunnableTest线程修改值为true后, 同步到主存, 但对于主线程不可见
 *
 * 解决方法: 1. 使用synchronized关键字, 加锁后每次都会访问主存中的数据
 *           2. 使用validate关键字, 即相当于所有线程均在主存中操作数据, 但不具备互斥性和原子性
 */
public class VolatileTest {
    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();
        while (true) {
            if (runnableTest.isFlag()) {
                System.out.println("main");
                break;
            }
        }
    }
}

class RunnableTest implements Runnable {
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("RunnableTest, flag: {}" + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}