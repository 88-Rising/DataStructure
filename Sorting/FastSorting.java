package Sorting;

import java.util.Arrays;

/*
* 快速排序：是冒泡排序的改进版，也是最好的一种组内排序，还涉及到分治和递归
* 冒泡排序：其中记录的比较和交换是在相邻的单元中进行，每次交换只能上移或者下移一个单元，因而总的比较和移动次数比较多
*
* 快排的基本思想：
*   1.先从数列中取一个数作为基准数（一般取第一个数）
*   2.分区过程，把这个数大的全部放在它的右边小于或等于它的数去不放在它的左边（分区）
*   3.在对左右区间重复第一步，第二部直到各个区间只有一个数为止（递归）
*
* 核心在于分治和递归
* */
public class FastSorting {
    private static int partition(int[] arr, int low, int high) {
        //指定左指针i和右指针j
        int i = low;
        int j = high;
        //指定第一个数为基准值
        int x=arr[low];
        //使用循环实现分区操作
        while(i<j){//?
            //从右向左移动j 找到小于基准值的j
            while(arr[j]>=x && i<j){
                j--;
            }
            //把右侧找到的小于基准值的值加入左边的坑中，然后i++向中间移动一个位置
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            //从左向右移动指针i 找到第一个大于基准值的arr[i]
            while(arr[i]<x && i<j){
                i++;
            }
            //把左侧找到大于基准值的值计入右边的坑中 然后j--把右指针向中间移动
            if(i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        //使用基准值填坑，这就是基准值的最终位置
        arr[i]=x;//arr[j]=y;
        //返回基准值的位置索引
        return i;

    }
    
    private  static void quickSort(int[] arr,int low,int high){

        if(low<high) {
            //分区操作 把一个数组分成两个数组 返回分区界索引

            int index = partition(arr, low, high);

            //对右分区进行快排
            quickSort(arr, low, index - 1);


            //对右分区进行快排
            quickSort(arr, index + 1, high);
        }
    }



    public static void quickSort(int[] arr) {
        int low =0;
        int high=arr.length-1;
        quickSort(arr,low,high);
        
    }
    
    public static void main(String[] args){
        //给出无序数组
        int[] arr={72,6,57,88,60,4,83,73,48,85};

        //输出无序数组
        System.out.println(Arrays.toString(arr));

        //快速排序
        quickSort(arr);

        //输出有序数组
        System.out.println(Arrays.toString(arr));
    }

    


}
