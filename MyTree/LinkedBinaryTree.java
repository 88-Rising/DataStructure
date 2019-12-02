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
}
