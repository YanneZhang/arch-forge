package dev.yanne.day02_list.linkedlist.customlinkedlist;

public class MyLinkedList {
    // 链中一定有一个首节点；
    Node first;

    // 链中一定有一个尾节点；
    Node last;

    //计数器：
    int count = 0;

    public MyLinkedList() {

    }

    //添加元素的方法：
    public void add(Object o) {
        //证明你添加的元素是第一个节点
        if (first == null) {
            //将添加的元素封装为一个Node对象
            Node n = new Node();
            n.setPre(null);
            n.setObj(o);
            n.setNext(null);

            //当前链中第一个节点变为n
            first = n;

            //当前链中最后一个节点变为n
            last = n;
        }
        //证明已经不是链中的第一个节点了
        else {
            Node n = new Node();
            //上一个节点变为last了
            n.setPre(last);
            n.setObj(o);
            n.setNext(null);

            //当前链中的最后一个节点last的下一个元素next节点为n
            last.setNext(n);

            //当前链中的最后一个节点last为新的n
            last = n;
        }

        //链中元素数量加1
        count++;
    }

    //得到链的长度
    public int getSize() {
        return count;
    }

    //通过下标得到元素
    public Object get(int index) {
        //获取链表的头元素
        Node n = first;
        //一直n获取next，就获取到index的元素
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }
        return n.getObj();
    }
}

class Test {
    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.add("aa");
        ml.add("bb");
        ml.add("cc");

        //可以在此处加debug断点，查看数据是否添加成功
        System.out.println(ml.getSize());
        System.out.println(ml.get(2));
    }
}
