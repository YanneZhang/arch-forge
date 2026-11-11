package dev.yanne.day03_set.treeset;

import java.util.Comparator;

//外部比较器的优势：扩展性强，用了多态
public class TestCompare01 {
    public static void main(String[] args) {
        /*
         * 以自定义类型为案例：
         * 比较的思路：使用外部比较器，compareTo返回一个int类型的数据，将结果按照>0,<0,=0进行判断
         *
         * */
        Student01 aaaa = new Student01(10, 150.6, "aaaa");
        Student01 bbbb = new Student01(11, 155.7, "bbbb");
        //System.out.println(aaaa - bbbb);//

        //外部比较器：年龄
        Comparator<Student01> bj1 = new Bijiao01();
        System.out.println(bj1.compare(aaaa, bbbb));

        //外部比较器：身高
        Comparator<Student01> bj2 = new Bijiao02();
        System.out.println(bj2.compare(aaaa, bbbb));

        //外部比较器：姓名
        Comparator<Student01> bj3 = new Bijiao03();
        System.out.println(bj3.compare(aaaa, bbbb));

        //外部比较器：年龄相同时，比较身高，不同时比较年龄
        Comparator<Student01> bj4 = new Bijiao04();
        System.out.println(bj4.compare(aaaa, bbbb));
    }
}

class Student01 {
    private int age;
    private double height;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student01(int age, double height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * 外部比较器
 */
class Bijiao01 implements Comparator<Student01> {
    @Override
    public int compare(Student01 o1, Student01 o2) {
        //按照年龄比较
        return o1.getAge() - o2.getAge();
    }
}

/**
 * 外部比较器
 */
class Bijiao02 implements Comparator<Student01> {
    @Override
    public int compare(Student01 o1, Student01 o2) {
        //按照身高比较
        return ((Double) (o1.getHeight())).compareTo(((Double) (o2.getHeight())));
    }
}

/**
 * 外部比较器
 */
class Bijiao03 implements Comparator<Student01> {
    @Override
    public int compare(Student01 o1, Student01 o2) {
        //按照姓名比较
        return o1.getName().compareTo(o2.getName());
    }
}

/**
 * 外部比较器
 */
class Bijiao04 implements Comparator<Student01> {
    @Override
    public int compare(Student01 o1, Student01 o2) {
        //年龄相同时，比较身高
        if (o1.getAge() - o2.getAge() == 0) {
            return ((Double) (o1.getHeight())).compareTo(((Double) (o2.getHeight())));
        } else {
            return o1.getAge() - o2.getAge();
        }
    }
}
