public class BST {

    private BinaryTreeNode<Integer> root;
    private int size;
    //static because any node that we pass will be independent of the bst on which we are working
    private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x){
        if(node==null){
            return false;
        }
        if (node.data==x) {
            return true;
        }
        if(x<node.data){
            //call on left side
            return isPresentHelper(node.left,x);
        }
        else{
            //call on the right side
            return isPresentHelper(node.right,x);

        }
    }
    public boolean isPresent(int x){
        return isPresentHelper(root,x);
    }

    public void insert(int x){

    }
    public boolean deleteData(int x){
        return false;
    }
    public int size(){
        return size;
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> node){
        //TODO take care of base case
        if (node == null) {
            return;
        }
        System.out.print(node.data+" : ");
        if(node.left!=null){
            System.out.print("L"+node.left.data+", ");
        }
        if(node.right!=null){
            System.out.print("R"+node.right.data);
        }
        System.out.println();
        printTreeHelper(node.left);
        printTreeHelper(node.right);
    }
    public void printTree(){
        printTreeHelper(root);
    }
}
