package dev.yanne.day02_list.generic;

import java.util.ArrayList;
import java.util.List;

public class TestWildcard {
    public static void main(String[] args) {
        Object obj = new Object();
        String s = new String();
        obj = s;//多态

        Object[] objArr = new Object[10];
        String[] sArr = new String[10];
        objArr = sArr;//多态

        List<Object> objl = new ArrayList<>();
        List<String> sl = new ArrayList<>();//加了String，限制只能存入String类型，并且是编译时限制
        //objl = sl;//这里不可以相等  底层都是Object[]，objl和sl无继承关系，是并列的关系
        
        
        //A和B是子类父类关系，但是G<A>和G<B>不存在继承关系，是并列关系
        //加入通配符?后，G<?>就变成了G<A>和G<B>的父类     

        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        List<?> list = null;
        list = list1;
        list = list2;
        list = list3;


        //
        Test t= new Test();
        t.a(new ArrayList<Object>());
        t.a(new ArrayList<String>());
        t.a(new ArrayList<Integer>());
    }
}

class Test
{
    /*public void a(List<Object> t){}
    public void a(List<String> t){}
    public void a(List<Integer> t){}*/

    //以上方法可简写为,编译器认为以上方法为重复定义，以上方法为重载
    public void a(List<?> list){
        //遍历
        for(Object a : list){
            System.out.println(a);
        }

        //写入
        //list.add("abc");//不能写入操作
        list.add(null);//可以是null，不能是其他任何具体数据


        //读取
        //String s = list.get(0);// 不可以
        Object s = list.get(0); //可以用object接收
    }
}
