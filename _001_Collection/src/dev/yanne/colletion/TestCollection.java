package dev.yanne.colletion;

import java.util.*;

//集合1：Collection-->List-->ArrayList\LinkedList
//集合1：Collection-->Set-->HashSet\TreeSet
//集合2：Map-->HashMap/TreeMap

public class TestCollection {
    public static void main(String[] args) {
        //集合api
        //增加
        //add

        //删除
        //remove
        //clear

        //修改
        //

        //查询
        //iterator
        //size

        //判断
        //contains
        //equals
        //isEmpty

        // 1.创建collection对象,collection是接口不能创建,用实现类创建对象
        Collection col = new ArrayList();//多态写法

        // 集合有一个特点,只能存放引用数据类型的数据,不能是基本数据类型
        // 基本数据类型自动装箱,对应包装类,int-->Integer
        col.add(18);
        col.add(12);
        col.add(11);
        col.add(17);

        System.out.println(col/*.toString()*/);//[18,12,11,17]


        List list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});//多态
        col.addAll(list);//将另一个集合添加到col中
        System.out.println(col);//[18,12,11,17,1,2,3,4,5,6]

        //col.clear();//清空集合
        System.out.println(col);
        System.out.println("集合长度:" + col.size());
        System.out.println("是否为空:" + col.isEmpty());

        //删除
        boolean isRemove = col.remove(5);
        System.out.println(col);
        System.out.println("删除是否成功:" + isRemove);// true

        Collection col2 = new ArrayList();
        col.add(18);
        col.add(12);
        col.add(11);
        col.add(17);

        Collection col3 = new ArrayList();
        col.add(18);
        col.add(12);
        col.add(11);
        col.add(17);
        System.out.println(col2.equals(col3));//比较两个集合中每个位置对应的元素是否相同，true
        System.out.println(col2 == col3);//比较地址，地址一定不相等，false

        System.out.println("是否包含元素：" + col3.contains(17));// true
        System.out.println("是否包含元素：" + col3.contains(117));// false

        // 对集合遍历（对集合中元素进行查看）
        // 普通for循环,这种方式不行，没有根据索引get数据的方式
        /*for (int i = 0; i < col.size(); i++) {
            System.out.println(col.);
        }*/

        // 增强for循环
        for (Object obj : col) {//用object方式接收，不能用具体的引用对象
            System.out.println(obj);
        }

        // 方式3：迭代器  简要原理：java中没有指针概念，通过hasnext判断是否有下一个元素，有则true，否则false
        // next()将元素获取到，并且将指针下移
        Iterator it = col.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}