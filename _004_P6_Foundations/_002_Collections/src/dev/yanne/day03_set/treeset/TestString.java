package dev.yanne.day03_set.treeset;

import java.util.TreeSet;

public class TestString {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("bb");
        ts.add("zz");
        ts.add("ff");
        ts.add("gg");
        ts.add("uu");
        ts.add("ff");

        System.out.println(ts.size());
        //有一个元素ff只有一个，打印出来按升序进行遍历，没有按照输入顺序进行输出
        //String类型内部也有内部比较器
        System.out.println(ts);
    }
}
