package dev.yanne.day03_set.treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class TestStudent01 {
    public static void main(String[] args) {

        //利用外部比较器
        Comparator<Student01> bj1 = new Bijiao01();
        TreeSet<Student01> ts = new TreeSet<>(bj1);
        ts.add(new Student01(10,140,"ebaibai"));
        ts.add(new Student01(10,140,"abaibai"));
        ts.add(new Student01(10,140,"dbaibai"));
        ts.add(new Student01(10,140,"gbaibai"));
        ts.add(new Student01(10,140,"cbaibai"));
        ts.add(new Student01(10,140,"bbaibai"));

        System.out.println(ts.size());
        System.out.println(ts);

        //实际开发中利用外部比较器多，是因为方便扩展，实际是多态

        //换一种写法
        //这里是匿名内部类
        /*Comparator<Student01> bj2 = new Comparator<Student01>() {
            @Override
            public int compare(Student01 o1, Student01 o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };*/
        //也可以用以下方式，在实际用时再定义内部类
        TreeSet<Student01> ts1 = new TreeSet<>(new Comparator<Student01>() {
            @Override
            public int compare(Student01 o1, Student01 o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        ts1.add(new Student01(10,140,"ebaibai"));
        ts1.add(new Student01(10,140,"abaibai"));
        ts1.add(new Student01(10,140,"dbaibai"));
        ts1.add(new Student01(10,140,"gbaibai"));
        ts1.add(new Student01(10,140,"cbaibai"));
        ts1.add(new Student01(10,140,"bbaibai"));

        System.out.println(ts1.size());
        System.out.println(ts1);

        //实际上是怎样获得有序的结果呢？
        //TreeSet 底层的树结构是红黑树，而红黑树是一种二叉搜索树（BST）
        //TreeSet → Red-Black Tree → BST → 中序遍历 → 有序（升序）
        //二叉树的遍历方式：
        //中序遍历：左，根，右===>treeset用此方式遍历二叉树数据,从小到大
        //先序遍历：根，左，右===>不保证有序
        //后序遍历：左，右，根===>不保证有序
        //TreeSet.descendingSet() 得到的降序结果，可以理解为利用了反向比较器
    }
}
