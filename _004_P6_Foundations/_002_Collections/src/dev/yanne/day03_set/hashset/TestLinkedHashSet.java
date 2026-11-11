package dev.yanne.day03_set.hashset;

import java.util.LinkedHashSet;

public class TestLinkedHashSet {

    public static void main(String[] args) {
        //特点：元素唯一，按照输入顺序输出元素
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(0);
        lhs.add(10);
        lhs.add(8);
        lhs.add(5);
        lhs.add(3);
        lhs.add(7);
        lhs.add(1);

        System.out.println(lhs.size());
        System.out.println(lhs);


        /**
         * LinkedHashSet原理：其实就是在hashset基础上多了一个总链表，这个总链表将放入的元素串在一起，方便有序的遍历
         */

    }
}
