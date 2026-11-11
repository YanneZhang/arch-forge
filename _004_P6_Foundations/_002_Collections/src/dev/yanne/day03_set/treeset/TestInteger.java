package dev.yanne.day03_set.treeset;

import java.util.TreeSet;

public class TestInteger {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(9);
        ts.add(6);
        ts.add(3);
        ts.add(8);
        ts.add(5);
        ts.add(7);
        ts.add(3);

        System.out.println(ts.size());
        //有一个元素3只有一个，打印出来按升序进行遍历，没有按照输入顺序进行输出
        //类似一个二叉树比较，先放进去元素9，在放入元素6时，9和6进行比较，元素6就放在前面，类似比较下去
        //逻辑结果：二叉树，物理结构：跳转结构,底层的树结构是红黑树，而红黑树是一种二叉搜索树
        //底层是用Integer的内部比较器
        System.out.println(ts);
      }
}
