package MyStack;

/*
 * 使用队列把十进制转换为二进制
 *
 * */

import java.util.Deque;
import java.util.LinkedList;

public class TestConvert {
    public static void main(String[] args) {
        //给定一个十进制数
        int n=13;
        String str="";

        //把十进制转换为二进制
        int t=13;//被除数

        //定义一个空栈
        Deque stack=new LinkedList();
        do{
            //除以二求余数
            int mod=t%2;
            //输出余数

            str=mod+str;
            stack.push(mod);

            //除以二得到商
            int result=t/2;
            //使用商作为被除数
            t=result;


        }while(t>0);


        //输出结果
        System.out.println(n+"------->"+str);//定义一个String字符串解决问题
        System.out.print(n+"------—>");//使用栈来输出
        while(!stack.isEmpty()){//栈非空
            System.out.print(stack.pop());

        }
    }
}