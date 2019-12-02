package MyTree;

public interface BinaryTree {
    //判断是否为空树
    public Boolean isEmpty();

    //树结点数量
    public int size();

    //获取树的高度
    public int getHeight();

    //先序遍历
    public void preOderTraverse();
    public void preOderTraverse(Node root);


}
