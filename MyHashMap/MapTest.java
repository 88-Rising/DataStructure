package MyHashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Map就是用来存储键值对的，Map类中存储的键值对通过键来标识，所以键值不能重复
 * Map接口的实现类有 HashMap,TreeMap,HashTable,Properties
 * 测试HashMap的使用
 *
 * */
class Employee{
    private  int id;
    private String ename;
    private double salay;

    public Employee(int id,String ename,double salay) {
        this.id=id;
        this.ename=ename;
        this.salay=salay;
    }

    public double getSalay() {
        return salay;
    }

    public void setSalay(double salay) {
        this.salay = salay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
    public String toString(){
        return  "id:"+id+" name:"+ename+" salary:"+salay;
    }

}

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> m1=new HashMap<>();

        m1.put(1,"one");//存放键值对
        m1.put(2,"two");
        m1.put(3,"three");

        System.out.println(m1.get(1));//通过键对象查找到值对象
        System.out.println(m1.size());//输出键值对的大小
        System.out.println(m1.isEmpty());//判断map是否为空
        System.out.println(m1.containsValue("four"));//判断是否包含four

        Map<Integer,String> m2=new HashMap<>();
        m2.put(4,"四");
        m2.put(5,"五");
        m1.putAll(m2);//把m2的所有键值对放到m1
        System.out.println(m1);

        m1.put(3,"San");
        System.out.println(m1);
        //map中键不能重复，如果重复（是否重复是根据equals方法来判断的），则新的会覆盖旧的


        Employee e1=new Employee(1001,"haha",10000);
        Employee e2=new Employee(1002,"heihei",20000);
        Employee e3=new Employee(1003,"hehe",20222);
        Employee e4=new Employee(1003,"hehahe",30000);
        Map<Integer,Employee> map=new HashMap<>();

        map.put(1001,e1);
        map.put(1002,e2);
        map.put(1003,e3);

        System.out.println(map);
        map.put(1001,e4);
        System.out.println(map);

        Employee emp = map.get(1001);
        System.out.println(emp.getEname());




    }
}