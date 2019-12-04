package MyTree;

public interface BinaryTree {
    //判断是否为空树
    public Boolean isEmpty();

    //树结点数量
    public int size();

    //获取树的高度
    public int getHeight();
    public int getHeight(Node root);


    //先序遍历
    public void preOrderTraverse();
    public void preOrderTraverse(Node root);

    //中序遍历
    public void inOrderTraverse();
    public void inOrderTraverse(Node root);

    //后序遍历
    public void postOrderTraverse();
    public void postOrderTraverse(Node root);

    //寻找某个值
    public Node findKey(int value);




}
