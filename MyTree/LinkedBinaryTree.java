package MyTree;

public class LinkedBinaryTree implements BinaryTree {
    public Node root;

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public Boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }


    public void preOderTraverse(){
        System.out.println("先序遍历");
        this.preOderTraverse(root);
        System.out.println();

    }
    @Override
    public void preOderTraverse(Node root) {
        /*
        * 1.输出根节点的值
        * 2.对左子树进行先序遍历
        * 3.对右子树进行先序遍历
        * */
        if(root!=null) {
            System.out.print(root.value+"  ");


            this.preOderTraverse(root.leftChild);

          this.preOderTraverse(root.rightChild);

        }



    }
}
