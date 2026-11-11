package dev.yanne.day02_list.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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

        // 增强for循环，底层实际也是迭代器的方式
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

        //ArrayList数据结构：
        //物理结构：紧密结构
        //逻辑结构：线性表（数组）

        //linkedList数据结构
        //物理结构：跳转结构
        //逻辑结构：线性表（链表）
        //jdk1.8底层是双向链表，既保存前一个元素的地址，又指向后一个元素的地址
        //单独元素时，前一个地址和后一个地址是null
        //


        //linkedlist源码解读
        //public class LinkedList<E> ---是一个泛型，具体的类型要在实例化的时候才会最终确定
        //transient int size = 0;---集合中元素的数量
        //transient Node<E> first;---首节点
        //transient Node<E> last;---尾节点
        //Node属性E item; Node<E> next; Node<E> prev;
        //定义空构造器
        //add方法，linkLast方法是具体实现的方法，传一个参数E
        /*linkLast方法r如下：
            void linkLast(E e) {//添加的元素E
            final Node<E> l = last;//将链表中的last节点给l，如果是第一个元素的话，l为null
            //将元素封装为一个Node具体的对象：
            final Node<E> newNode = new Node<>(l, e, null);
            //将链表的last节点指向新的创建的对象：
            last = newNode;
            //如果添加的是第一个节点，将链表的first指向为newNode
            //如果添加的不是第一个节点，将链表的next指向为newNode
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            //元素数量自增1
            size++;
            modCount++;
            }
         */
        //size方法，返回size
        //get方法
        /*
        public E get(int index) {
            checkElementIndex(index);//程序健壮性需要考虑的
            return node(index).item;
        }
        //具体查找元素的方法
        Node<E> node(int index) {
            // assert isElementIndex(index);

            //如果index在size的前半段，则从前向后找元素
            if (index < (size >> 1)) {
                Node<E> x = first;
                for (int i = 0; i < index; i++)
                    x = x.next;
                return x;
            } else {//如果index在size的后半段，则从后向前找元素
                Node<E> x = last;
                for (int i = size - 1; i > index; i--)
                    x = x.prev;
                return x;
            }
        }
        * */

        ArrayList al = new ArrayList<>();
        //ArrayList--implements-->List接口--extends-->Collection接口--extends-->Iterable接口
        //Iterable接口都是抽象方法iterator()
        //抽象方法iterator()在具体的实现类中实现了
        //ArrayList中的iterator(),这个方法的返回值是Iterator<E>,是一个接口，有一些抽象方法，常用的抽象方法是hasNext(),next()
        //public Iterator<E> iterator() {// 这里返回值是接口，return返回的是实现类，这里也是多态的一种表现
        //        return new Itr();
        //    }
        //那么抽象方法是hasNext(),next()在哪里实现的呢？在 new Itr()中得到具体实现，Itr()是ArrayList的内部类
        //
        //
        /*private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        // prevent creating a synthetic constructor
        Itr() {}

        public boolean hasNext() {//判断cursor是否等于size
            return cursor != size;//cursor是自定义指针，判断和ArrayList源码中的size是否相同，cursor和size不同时返回true，相同时，返回false
        }

        @SuppressWarnings("unchecked")
        public E next() {//改变cursor，输出元素
            checkForComodification();//健壮性考虑
            int i = cursor;//第一次执行，cursor=0，同时i=0
            if (i >= size)//健壮性考虑
                throw new NoSuchElementException();//健壮性考虑
            Object[] elementData = ArrayList.this.elementData; //elementData是ArrayList底层数据存储的元素
            if (i >= elementData.length)//健壮性考虑
                throw new ConcurrentModificationException();//健壮性考虑
            cursor = i + 1;//用cursor模拟指针，第一次执行，cursor=0+1=1;
            return (E) elementData[lastRet = i];//第一次执行时，lastRet也设置成0，并返回elementData为0索引的数据
        }
    }*/

        ArrayList<String> al1 = new ArrayList<>();
        al1.add("aa");
        al1.add("bb");
        al1.add("cc");
        al1.add("dd");
        al1.add("ee");

        //在 cc 之后增加 kk 这个元素
        Iterator<String> it = al1.iterator();
        while (it.hasNext()) {
            if ("cc".equals(it.next())) {
                al1.add("kk");// 此处报错，报concurrentModificationException，并发修改异常，迭代器在遍历集合，add在给集合增加数据，两个操作同时操作集合
            }
        }
        //以上exception的解决办法，引入新的迭代器ListIterator；迭代和添加操作都通过ListIterator操作
        ListIterator<String> it1 = al1.listIterator();
        while (it1.hasNext()) {
            if ("cc".equals(it1.next())) {
                it1.add("kk");
            }
        }
        System.out.println(it1.hasNext());//输出false
        System.out.println(it1.hasPrevious());//输出true
        //逆向遍历：
        while(it1.hasPrevious())
        {
            System.out.println(it1.previous());
        }

        System.out.println(it1.hasNext());//输出true
        System.out.println(it1.hasPrevious());//输出false
    }
}
