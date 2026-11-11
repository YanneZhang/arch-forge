package dev.yanne.day02_list.generic;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {
        //泛型就相当于标签
        //形式：<>
        //设计和声明阶段不能确定容器实际存什么类型对象，jdk1.5之前用Object，1.5之后用泛型
        //类型参数叫做泛型
        //泛型就是<>+实际的引用类型
        //使用泛型后，确定集合存放的类型，编译期就可以检查类型
        //后续遍历等操作简单
        //泛型一般修饰集合的
        //new后面<>可以不用写具体类型，可以做类型推断，<>叫作钻石运算符


        //没有泛型时使用容器
        ArrayList al = new ArrayList();
        al.add(66);
        al.add(67);
        al.add(68);
        al.add(69);
        al.add("qaz");
        al.add(66.6);
        System.out.println("----------------");
        //遍历时用Object接收
        for (Object obj : al) {
            System.out.println(obj);
        }

        //有泛型时使用容器,一般往集合中存入的数据都是相同类型，便于数据管理，相当于给这个容器贴了一个标签
        //泛型必须用引用类型
        //优点：编译时期就会类型检查，集合遍历查看，可以直接用引用类型接收
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(66);
        al1.add(67);
        al1.add(68);
        al1.add(69);
        //al1.add("qaz");// 此处报错
        //for(Integer obj:al)//这样报错
        for (Integer obj : al1) {
            System.out.println(obj);
        }
    }
}

//上面是普通类
//这个是泛型类
//<>里面就是一个参数类型，E可以用其他任何字幕代替，这个类型现在不确定，相当于站位，可以确定的是引用类型
class TestGeneric01<E> {
    int age;
    String name;
    E sex;

    //不是泛型方法
    public void a(E n) {
    }

    //不能是static方法，因为加载时就需要知道E的类型
    public void b(E[] m) {
    }

    //是泛型方法
    //要求方法的泛型参数类型，和当前类的泛型参数不同
    //<T>是必须加的
    //静态方法优先于对象加载，因为T随着调用的时候才会确定
    public static <T> void c(T t)
    {

    }
}

class TestGeMain {
    public static void main(String[] args) {
        //TestGeneric01实例化
        //不指定泛型
        //实例化时泛型如果不指定，泛型就会被擦除，泛型对应的类型为Object类型
        TestGeneric01 gt1 = new TestGeneric01();
        gt1.a("bac");
        gt1.a(17);
        gt1.b(new Integer[]{1, 2, 3});

        //调用泛型方法
        gt1.c(1);//这里是Object

        //推荐方式，必须进行类型限制
        TestGeneric01<Double> gt2 = new TestGeneric01<>();
        gt2.sex = 1.2;
        gt2.a(17.5);
        gt2.b(new Double[]{1.1, 2.2, 3.3});

        //T的类型调用时才确定的
        //gt2.c()
    }
}

class SubTestGeneric extends TestGeneric01<Integer> {

}

//后面写E了，前面也必须加<E>
//父类不指定泛型，子类也必须不指定，再创建对象时指定
class SubTestGeneric1<E> extends TestGeneric01<E> {

}

class testSubMain {
    public static void main(String[] args) {
        //指定父类泛型，那么子类就不需要再指定，直接使用
        SubTestGeneric stg = new SubTestGeneric();
        stg.a(1);

        SubTestGeneric1<String> stg2 = new SubTestGeneric1<>();
        stg2.sex = "女";
    }
}

//应用场合
//Arrayist<E>--add方法
//可以多个参数类型
//

class TestGeneric02<A, B, C> {
    A age;
    B name;
    C sex;

    public void a(A m, B n, C k) {
    }

    //public TestGeneric02<A, B, C>>() { }//构造器不可以写泛型类型

    public void b(){
        ArrayList<String> al = null;
        ArrayList<Integer> al1 = null;
        //al=al1;//不同的泛型的引用类型不可以相互赋值
    }

    //没有创建对象时，静态方法已经加载到内存中了，此时还不知道A是什么
    /*public static int c(A a){
        return 10;
    }*/

    //不能使用E[]数组的创建
    public void d(A a){
        //A[] i = new A[10];不可以这样使用
        A[] i = (A[]) new Object[10]; //可以这样使用
    }


}
