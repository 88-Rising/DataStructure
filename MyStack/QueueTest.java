package MyStack;

import java.util.Deque;
import java.util.Queue;

/*
 *队列(Queue)简称队，和堆栈一样，也是一种运算受限的线性表
 * 其限制是仅允许在表的一端进行插入，而在表的另一端进行删除
 * 在队列中把出入数据元素的一段称为队尾（rear）删除数据元素的一端称为（front）
 * 向队尾插入元素成为进队或入队，新元素入队后成为新的队尾元素
 * 从队列中删除元素成为离队或出队，元素出队后，其后续元素成为新的队首元素
 * 由于队列的插入和删除操作分别在队尾和队首进行，美国个元素必然按照进入的次序离队
 *
 * 也就是说先进队的元素必然先离队，所以成为 先进先出表（First In First Out）简称FIFO
 *
 * 队列的常用的操作是 enqueue：数据元素入队
 *                   dequeue:队首元素出队
 *                    peek：取队首元素
 * 队列的存储结构有： 顺序队列：使用数组作为存储结构
 *                    循环队列：避免出队之后数组前几个存储空间为空    双端队列：两端都可以进队或者出队
 *双端队列既可以用队列来操作也可以用实现栈来操作
 *
 *
 * */
public class QueueTest {
    public static void main(String[] args) {
        Deque dq;//可以在两端插入或删除元素的队列
        Queue qu;//Queue接口的实现类有LinkedList,ArrayDeque
    }


}