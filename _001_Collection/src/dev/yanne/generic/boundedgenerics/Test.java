package dev.yanne.generic.boundedgenerics;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //a,b,c三个集合是并列的关系；
        List<Object> a = new ArrayList<>();
        List<Person> b = new ArrayList<>();
        List<Student> c = new ArrayList<>();

        /*
        开始使用泛型受限，泛型的上限
        List<? extends Person>是List<Person>的父类，是List<Person的子类>的父类
        向下兼容
        类本身及子类
         */
        List<? extends Person> list1 = new ArrayList<>();
        //list1 = a;//不是Object父类
        list1 = b;
        list1 = c;

        /*
        开始使用泛型受限，泛型的下限
        * 向上兼容
        * 类本身及父类
        * */
        List<? super Person> list2 = new ArrayList<>();
        list2 = a;
        list2 = b;
        //list2 = c;
    }
}
