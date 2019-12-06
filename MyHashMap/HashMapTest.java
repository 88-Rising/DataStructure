package MyHashMap;

/*
 * HashMap底层实现采用了哈希表，哈希表的基本结构就是数组+链表
 * 数组：占用空间连续，寻址容易，查询速度快，但是增删慢
 * 链表：占用空间不连续，寻址困难，查询速度慢，但是增删效率高
 * 然而哈希表结合了两者的优点
 *
 * 自定义一个HashMap
 * 实现了put方法增加键值对，并解决了键重复的时候覆盖相应的结点
 *
 * 数组扩容？
 * */
public class HashMapTest {
    Node[] table; //位桶数组,bucket array
    int size;  //存放键值对的个数

    public  HashMapTest(){
        table =new Node[16]; //长度定义为2的整数幂
    }

    public static int myHash(int v,int length){
//        System.out.println("hash in myHash:"+(v&(length-1)));//直接位运算，效率高
//        System.out.println("hash in myHash:"+(v%(length-1)));//取模运算，效率低

        return v&(length-1); //返回哈希值
    }

    public  void put(Object key,Object value) {
        //定义了新的结点对象
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.value = value;
        newNode.key=key;
        newNode.next = null;

        Node temp = table[newNode.hash];

        Node iterLast=null;
        boolean keyRepeat=false;
        if (temp == null) {  //此处数组元素为空 则直接把新结点放进去
            table[newNode.hash] = newNode;
            size++;
        } else {//如果此处数组元素不为空，则遍历对应的链表
            //遍历对应的链表
            while (temp != null) {
                //判断key如果重复则覆盖
                if (temp.key!=null&&temp.key.equals(key)) {
                    keyRepeat=true;
                    System.out.println("key重复了");
                    temp.value=value;//覆盖value
                    break;
                } else {
                    //key不重复则遍历下一个
                    iterLast=temp;
                    temp = temp.next;

                }

            }
            if(keyRepeat==false){  //如果没有发生key重复的情况则加到链表最后面
                iterLast.next = newNode;
                size++;
            }
        }
    }

    public Object get(Object key){
        //根据hashcode值获得对应的数组然后进行比较 找到相应的Key值
        int hash=myHash(key.hashCode(),table.length);
        Object value=null;
        if(table[hash]==null){
            return  null;

        }else{
            Node temp=table[hash];
            while(temp!=null){
                if(temp.key.equals(key)){//如果相等则说明找到了键值对，返回相应的结点

                    value=temp.value;
                    break;
                }else{
                    temp=temp.next;
                }
            }
        }
        return value;

    }


    @Override
    public String toString() {
        //{10:aa,20bb}
        //核心思想 先遍历数组再遍历结点
        StringBuilder sb=new StringBuilder("{");

        for(int i=0;i<table.length;i++){
            Node temp=table[i];
            while(temp!=null){
                sb.append(temp.key+":"+temp.value+",");
                temp=temp.next;
            }

        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();

    }

    public static void main(String[] args) {
        HashMapTest m=new HashMapTest();

        m.put(10,"a");
        m.put(20,"b");
        m.put(30,"c");
        m.put(10,"ss");
        m.get(30);



        for(int i=10;i<100;i++){//测试哈希冲突
            System.out.println(i+"-----"+myHash(i,16));
        }
        System.out.println(m);
        System.out.println(m.get(53));
        System.out.println(m.get(30));

    }
}