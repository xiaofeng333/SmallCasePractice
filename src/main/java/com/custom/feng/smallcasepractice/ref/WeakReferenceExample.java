package com.custom.feng.smallcasepractice.ref;

import com.custom.feng.smallcasepractice.pojo.Apple;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * WeakReference: 当一个对象仅仅被弱引用引用, 且没有其它强引用指向时, 当GC运行时, 无论当前内存空间是否足够, 该对象都会被回收。
 * 对象回收后, 会把弱引用对象放入ReferenceQueue中
 */
public class WeakReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<Apple> weakReference = new WeakReference<>(new Apple("honghushi"));
        System.gc();
        Thread.sleep(5000);
        Apple apple = weakReference.get();
        if (apple == null) {
            System.out.println("clear apple");
        } else {
            System.out.println(apple.getName());
        }

        ReferenceQueue<Apple> referenceQueue = new ReferenceQueue<>();
        WeakReference<Apple> weakReference1 = new WeakReference<>(new Apple("honghusshi"), referenceQueue);
        System.out.println(referenceQueue.poll());
        System.gc();
        Thread.sleep(5000);
        Reference<? extends Apple> reference = referenceQueue.poll();

        // 只是将弱引用对象放入了ReferenceQueue, 被弱引用对象已经回收了。
        System.out.println(reference.get());
    }
}
