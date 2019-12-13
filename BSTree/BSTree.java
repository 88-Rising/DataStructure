package BSTree;

public class BSTree <T extends Comparable<T>>{


    /*
    * 二叉搜索树需满足以下四个条件：

    若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    若任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    任意节点的左、右子树也分别为二叉查找树；
    没有键值相等的节点。
    *
    * */

        private BSTNode<T> mRoot;//定义根节点
        public class BSTNode<T extends Comparable<T>>{
            T key;   //定义键值
            BSTNode<T> right;   //右孩子
            BSTNode<T> left;    //左孩子
            BSTNode<T> parent;  //父节点

            public BSTNode(T key, BSTNode<T> right, BSTNode<T> left, BSTNode<T> parent) {
                this.key = key;
                this.right = right;
                this.left = left;
                this.parent = parent;
            }
        }

        //二叉搜索树先序遍历
        private void preOrder(BSTNode<T> tree){
                if(tree!=null){
                    System.out.println(tree.key+"  ");
                    preOrder(tree.left);
                    preOrder(tree.right);

                }


        }
        //二叉搜索树中序遍历
        private void inOrder(BSTNode<T> tree){
            if(tree!=null){
                inOrder(tree.left);
                System.out.println(tree.key+"  ");
                inOrder(tree.right);
            }

        }
        //二叉搜索树后序遍历
        private void postOrder(BSTNode<T> tree){
            if(tree!=null){
                postOrder(tree.left);
                postOrder(tree.right);
                System.out.println(tree.key+"  ");

            }

        }


}
