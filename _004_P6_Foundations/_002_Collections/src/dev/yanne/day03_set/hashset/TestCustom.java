package dev.yanne.day03_set.hashset;

import java.util.HashSet;
import java.util.Objects;


public class TestCustom {
    public static void main(String[] args) {
        //创建一个hashset集合
        //自定义的类型，不满足数据唯一的特性
        HashSet<Student> hsi = new HashSet<>();
        System.out.println(hsi.add(new Student("aa",10)));// 输出true
        hsi.add(new Student("bb",8));
        hsi.add(new Student("cc",9));
        hsi.add(new Student("dd",11));
        hsi.add(new Student("ee",7));
        System.out.println(hsi.add(new Student("aa",10)));// 输出true，如果自定义类型重写了hashcode()和equals()方法，此处输出是false

        System.out.println(hsi.size());
        System.out.println(hsi);//输出结果和放入时的顺序不同，相同的hello只放入一次


        //底层原理（简要原理图）以Integer为例，实际底层和HashMap相似，
        /*
        * 底层：数组+链表=哈希表
        * 调用对应的hashCode方法计算hash值，通过hash值和一个表达式计算在数组中的存放位置
        * 注意：如果放入hashSet中的数据，一定要重写hashcode()和equals()这两个方法，这两个方法就是数据唯一的验证
        * 提问：1.数据的长度是多少？
        * 2.数组的类型是什么？
        * 3.hashcode()和equals()是否真的被调用？
        * 4.用于存放位置计算的表达式是什么？
        * 5.同一个位置的数据，是向前放还是向后放？
        * 6.放入数组中的数据，是直接放？还是封装成对象了？
        *
        * */

    }
}

class Student
{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // 以下两个方法，就是对数据唯一性进行处理的，如果没有这两个方法，则可放入重复的数据
    // 在使用alt+insert快捷键时，添加hashcode和equals两个方法，是同时进行的
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
