package dev.yanne.day03_set.treeset;

//比较器通篇的思路，就是用返回的int值，做判断
public class TestCompare {

    public static void main(String[] args) {

        /*
         * 以int类型为案例：
         * 比较的思路：将比较的数据做差，然后返回一个int类型的数据，将结果按照>0,<0,=0进行判断
         *
         * */
        int a = 10;
        int b = 20;
        System.out.println(a - b);

        /*
         * 以String类型为案例：
         * 比较的思路：系统中String实现了Comparable接口中的compareTo的方法，compareTo返回一个int类型的数据，将结果按照>0,<0,=0进行判断
         *
         * */
        String aa = "aa";
        String bb = "bb";
        //System.out.println(aa - bb); 不能做差
        System.out.println(aa.compareTo(bb));//

        /*
         * 以Double类型为案例：
         * 比较的思路：系统中Double实现了Comparable接口中的compareTo的方法，compareTo返回一个int类型的数据，将结果按照>0,<0,=0进行判断
         *
         * */
        Double aaa = 9.6;
        Double bbb = 9.3;
        System.out.println((int) (aaa - bbb));// 这种方法不行，因为9.6-9.3=0.3，转int后是0，但实际9.6和9.3不相等
        System.out.println(aaa.compareTo(bbb));// 底层源码是aaa<bbb则返回-1，aaa>bbb则返回1

        /*
         * 以自定义类型为案例：
         * 比较的思路：Student实现Comparable接口中的compareTo的方法，compareTo返回一个int类型的数据，将结果按照>0,<0,=0进行判断
         *
         * */
        Student aaaa = new Student(10, 150.6, "aaaa");
        Student bbbb = new Student(11, 155.7, "bbbb");
        //System.out.println(aaaa - bbbb);
        System.out.println(aaaa.compareTo(bbbb));//需要Student实现Comparable接口的compareTo方法，这里调用的是内部比较器


    }
}

class Student implements Comparable<Student> {
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

    public Student(int age, double height, String name) {
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

    //内部比较器：实现Comparable<Student>这个接口
    @Override
    public int compareTo(Student o) {
        // this为当前对象
        //按照年龄比较
        return this.getAge() - o.getAge();
        //按照身高比较
        //return ((Double) (this.getHeight())).compareTo(((Double) (o.getHeight())));
        //按照姓名比较
        //return this.getName().compareTo(o.getName());
    }
}
