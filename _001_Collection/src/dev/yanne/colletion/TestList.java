package dev.yanne.colletion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class TestList {
    public static void main(String[] args) {
        // collection父类里有的方法不测试
        //增加
        // add(int,E)

        //删除
        // remove(int)\remove(object)

        //修改
        //set(int,E)

        //查询
        // get(int)

        //判断

        // 底层是Object[] elementData数组，紧密结构
        // size有效长度
        List list = new ArrayList();//多态，调用空构造器，给elementData赋值，空的数组DEFAULTCAPACITY_EMPTY_ELEMENTDATA

        //调用add之后，给数组长度赋值10，
        list.add(1);
        //
        list.add(2);
        list.add(3);
        list.add(-1);
        list.add("abc");
        list.add("qaz");
        System.out.println(list/*.toString()*/);

        list.add(2, 22);
        System.out.println(list);

        list.set(4, 44);
        System.out.println(list);

        list.remove(6);//指定索引删除
        System.out.println(list);

        list.remove("abc");
        System.out.println(list);

        list.remove(2);//指定索引删除
        System.out.println(list);

        Object o = list.get(0);
        System.out.println(o);

        //遍历集合
        //方法1：普通遍历
        System.out.println("----------------");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }

        //方式2：增强for循环
        System.out.println("----------------");
        for(Object obj:list)
        {
            System.out.println(obj);
        }

        //方式3：迭代器
        System.out.println("----------------");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Vector与Arrayist的区别
        //底层都是Object[] elementData数组，size长度
        //Arrayist构造器是赋空，Vector创建一个长度为10的数组
        //Arrayist底层扩容长度为原长度1.5倍newCapacity = oldCapacity + (oldCapacity >> 1)
        //Vector底层扩容长度为2倍int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
        //Vector的部分public方法添加了synchronized修饰符，表示线程安全,效率低
        //底层都是数组，查询效率高，删除和增加的效率低
        //数据可重复
        //Vector已经被淘汰了
        Vector vec = new Vector();
    }
}
