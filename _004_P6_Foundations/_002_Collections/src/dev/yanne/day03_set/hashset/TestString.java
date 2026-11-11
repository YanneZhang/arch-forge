package dev.yanne.day03_set.hashset;

import java.util.HashSet;

public class TestString {
    public static void main(String[] args) {
        //创建一个hashset集合
        HashSet<String> hsi = new HashSet<>();
        System.out.println(hsi.add("hello"));// 输出true
        hsi.add("java");
        hsi.add("apple");
        hsi.add("html");
        hsi.add("css");
        System.out.println(hsi.add("hello"));// 输出false

        System.out.println(hsi.size());
        System.out.println(hsi);//输出结果和放入时的顺序不同，相同的hello只放入一次


    }
}
