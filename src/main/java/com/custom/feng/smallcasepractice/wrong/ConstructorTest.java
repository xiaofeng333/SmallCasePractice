package com.custom.feng.smallcasepractice.wrong;

/**
 * 规范: 不要在构造函数中使this引用逸出
 * 1. 不要在构造函数中调用非private或final的方法
 * 2. 发布了一个内部类实例, 其包含了对this的隐含引用
 * <p>
 * 如下例子为调用public方法的错误示范
 */
public class ConstructorTest extends SuperClass {
    private String filed;

    public ConstructorTest(String filed) {
        this.filed = filed;
        say();
    }

    public static void main(String[] args) {

        // 父类初始化时调用的say为子类方法, 此时filed为null
        ConstructorTest constructorTest = new ConstructorTest("wrong");
    }

    @Override
    public void say() {
        System.out.println("filed is " + filed);
    }
}

class SuperClass {

    public SuperClass() {
        say();
    }

    public void say() {
        System.out.println("super say");
    }
}
