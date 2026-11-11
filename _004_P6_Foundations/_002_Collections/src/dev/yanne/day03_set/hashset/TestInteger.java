package dev.yanne.day03_set.hashset;

import java.util.HashSet;

public class TestInteger {
    public static void main(String[] args) {
        //创建一个hashset集合
        HashSet<Integer> hsi = new HashSet<>();
        hsi.add(1);
        hsi.add(0);
        hsi.add(10);
        hsi.add(8);
        hsi.add(5);
        hsi.add(3);
        hsi.add(7);
        hsi.add(1);

        System.out.println(hsi.size());
        System.out.println(hsi);//输出结果和放入时的顺序不同，相同的1只放入一次


    }
}
