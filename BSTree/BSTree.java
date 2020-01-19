package BSTree;

import static jdk.nashorn.internal.objects.Global.print;

public class BSTree <T extends Comparable<T>>{


    /*
    * 二叉搜索树需满足以下四个条件：

    若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    若任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    任意节点的左、右子树也分别为二叉查找树；
    没有键值相等的节点。
    *0
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
        public BSTree(){
            mRoot=null;
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


        /*
        * 二叉搜索树的查找方法(递归查找) compareTo方法：
        *返回值:
          1)如果指定的数与参数相等返回0。
          2)如果指定的数小于参数返回 -1。
          3)如果指定的数大于参数返回 1。
        *
        * */
        private BSTNode<T> search(BSTNode<T> x,T key){

            if(x==null){
                return null;
            }
            int cmp=key.compareTo(x.key);
            if(cmp<0){
                return  search(x.left,key);

            }else if(cmp>0){
                return search(x.right,key);

            }else
                return x;

        }



        /*
        * 二叉搜索树的非递归查找
        * */
        private BSTNode<T> iterativeSearch(BSTNode<T> x,T key){

            while(x!=null){
                int cmp=key.compareTo(x.key);
                if(cmp<0){
                    x=x.left;

                }else if(cmp>0){
                    x=x.right;

                }else
                    return x;



            }
            return x;

        }
        /*
        * 查询BSTree二叉搜索树的最大值
        * */
        private BSTNode<T> maximum(BSTNode<T> tree){

            if(tree ==null){
                return  null;

            }
            while(tree.right!=null){

                tree=tree.right;
            }

            return tree;

        }
        public T maximum(){

          BSTNode<T> p=maximum(mRoot);
          if(p!=null)
            return p.key;
          else
              return null;

        }
        /*
        * BSTree二叉搜索树 查找其最小值
        *
        * */
        private BSTNode<T> minimum(BSTNode<T> tree){
            if(tree == null){

                return null;
            }
            while(tree.left!=null){
                tree=tree.right;

            }
            return tree;
        }

        public T minimum(){

            BSTNode<T> p=minimum(mRoot);
            if(p!=null){
                return p.key;
            }else
                return null;
        }
        /*

        * 结点的前驱 这个结点左子树中最大的结点
        *
        *
        * */
        public BSTNode<T> predecessor (BSTNode<T> x){

            // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
            if (x.left != null)
                return maximum(x.left);

            // 如果x没有左孩子。则x有以下两种可能：
            //  x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
            //  x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点的有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
            BSTNode<T> y = x.parent;
            while ((y!=null) && (x==y.left)) {

                x = y;
                y = y.parent;
            }

            return y;
        }


       /*
       * 结点的后继 ：该节点右子树最小的结点
       * */
    public BSTNode<T> successor(BSTNode<T> x) {
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (x.right != null)
            return minimum(x.right);
        // 如果x没有右孩子。则x有以下两种可能：
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        BSTNode<T> y = x.parent;
        while ((y!=null) && (x==y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }
    /*

    * 插入一个结点
    * */
    private void insert(BSTree<T> bst , BSTNode<T> z){
        int cmp;
        BSTNode<T> y=null;
        BSTNode<T> x=bst.mRoot;

        while(x!=null){
            y=x;
            cmp=z.key.compareTo(y.key);
            if(cmp<0){
                x=x.left;

            }else{
                x=x.right;
            }

        }
        z.parent=y;
        if(y==null){

         bst.mRoot=z;
        }else{
            cmp=z.key.compareTo(y.key);

            if(cmp<0){
                y.left=z;
            }else{
                y.right=z;

            }
        }
    }
    //删除一个结点
    private BSTNode<T> remove(BSTree<T> bst, BSTNode<T> z) {
        BSTNode<T> x=null;
        BSTNode<T> y=null;
        if ((z.left == null) || (z.right == null) )
            y = z;
        else
            y = successor(z);
        if (y.left != null)
            x = y.left;
        else
            x = y.right;
        if (x != null)
            x.parent = y.parent;
        if (y.parent == null)
            bst.mRoot = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;
        if (y != z)
            z.key = y.key;
        return y;
    }
    public void remove(T key) {
        BSTNode<T> z, node;
        if ((z = search(mRoot, key)) != null)
            if ( (node = remove(this, z)) != null)
                node = null;
    }

  /*
  * 打印
  * */
  public void print(BSTNode<T> tree,T key,int direction){
      if(tree!=null){
         if(direction == 0){
             System.out.printf("%2d is root/n",tree.key );


         }else{
             System.out.printf("%2d is %2d's %6s child/n", tree.key, key, direction==1?"right" : "left");

         }
          print(tree.left, tree.key, -1);
          print(tree.right,tree.key,  1);
      }

  }
    public void print(){
      if(mRoot!=null){

          print(mRoot,mRoot.key,0);
      }


    }

    private void destroy(BSTNode<T> tree) {

        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);

        if (tree.right != null)
            destroy(tree.right);

        tree=null;
    }

    public void clear() {

        destroy(mRoot);
        mRoot = null;
    }

}













