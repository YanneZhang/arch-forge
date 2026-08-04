package dev.yanne.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class Test01 {
    public static void main(String[] args) {
        //增加
        //addFirst(E e);
        //addLast(E e);
        //offer(E e)
        //boolean	offerFirst(E e)
        //boolean	offerLast(E e)

        //修改


        //删除
        //remove()
        //E	remove(int index)
        //boolean	remove(Object o)
        //E	removeFirst()--抛异常，影响程序的健壮性
        //boolean	removeFirstOccurrence(Object o)
        //E	removeLast()
        //boolean	removeLastOccurrence(Object o)
        //poll() --jdk1.6之后的方法，
        //E	pollFirst()
        //E	pollLast()

        //查看
        //getFirst();
        //getLast();
        //contains(Object o)
        //element()
        //indexOf(Object o)
        //lastIndexOf(Object o)
        //peek()
        //E	peekFirst()
        //E	peekLast()

        // 判断


        //创建一个对象，LinkedList是一个泛型类
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("aaaa");
        linkedList.add("bbbb");
        linkedList.add("cccc");
        linkedList.add("dddd");
        linkedList.add("eeee");
        linkedList.add("ffff");
        linkedList.add("bbbb");

        // linkedlist可以添加重复的数据
        System.out.println(linkedList);

        linkedList.addFirst("11111");
        linkedList.addLast("22222");

        //添加元素在尾端
        linkedList.offer("33333");
        linkedList.offerFirst("4444");
        linkedList.offerLast("5555");

        //删除头元素并输出
        System.out.println(linkedList.poll());
        //删除头元素并输出
        System.out.println(linkedList.pollFirst());
        //删除尾元素并输出
        System.out.println(linkedList.pollLast());

        //删除头元素
        System.out.println(linkedList.removeFirst());
        //删除尾元素
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);

        //清空
        linkedList.clear();
        System.out.println(linkedList);

        //删除未报错--jdk1.6之后的方法，不会抛异常，提高程序的健壮性
        linkedList.pollFirst();

        //删除并报异常，报出Exception异常
        linkedList.removeFirst();

        System.out.println("-----------------");

        //循环
        // 普通for循环
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        // 增强for循环
        for (String s : linkedList) {
            System.out.println(s);
        }

        // 迭代器
        /*Iterator<String> iterator = linkedList.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }*/
        //源码中存在的迭代器，这种方式好，节省内存
        for (Iterator<String> iterator = linkedList.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }

        // ArrayList数据结构：
        //物理结构：紧密结构
        //逻辑结构：线性表（数组）

        //linkedList数据结构
        //物理结构：跳转结构
        //逻辑结构：线性表（链表）
        //底层是双向链表，既保存前一个元素的地址，又指向后一个元素的地址
        //单独元素时，前一个地址和后一个地址是null
        //



    }
}
