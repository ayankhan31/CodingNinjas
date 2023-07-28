import com.sun.source.tree.BinaryTree;

import java.nio.BufferUnderflowException;
import java.util.*;
public class BinaryTreeUse {
    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
//
//        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
//        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
//        root.left = rootLeft;
//        root.right = rootRight;
//
//        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
//        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
//
//        rootLeft.right = twoRight;
//        rootRight.left = threeLeft;

//        printTreeDetailed(root);
//        BinaryTreeNode<Integer> root = takeTreeInputBetter(true,0,true);
//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        printTreeDetailed(root);
//        int num = numNodes(root);
//        System.out.println("Total number of nodes = "+num);
//        System.out.println("Largest is " +largest(root));
//        System.out.println("Number of Leaf Nodes " + numLeaves(root));
//        printAtDepthK(root, 2);
//        System.out.println("Is balanced "+isBalanced(root));
//        System.out.println("Is balanced better "+isBalancedBetter(root));
        int in[]={4,2,5,1,3};
        int pre[] = {1,2,4,5,3};
        BinaryTreeNode<Integer> root = buildTreeFromPreIn(pre,in);
        printTreeDetailed(root);
    }

    public static void printTree(BinaryTreeNode<Integer> root){

        //TODO take care of base case
        if(root==null){
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);

//        System.out.println(root.data);
//        if(root.left!=null){
//            printTree(root.left);
//        }
//        if(root.right!=null)
//            printTree(root.right);
    }
    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {

        //TODO take care of base case
        if (root == null) {
            return;
        }
        System.out.print(root.data+" : ");
        if(root.left!=null){
            System.out.print("L"+root.left.data+", ");
        }
        if(root.right!=null){
            System.out.print("R"+root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static BinaryTreeNode<Integer> takeTreeInput(){
        System.out.println("Enter root data");
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput(); // for left sub tree
        BinaryTreeNode<Integer> rightChild = takeTreeInput(); // for right sub tree
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot)
            System.out.println("Enter root data");
        else{
            if(isLeft)
                System.out.println("Enter left child of "+ parentData+": ");
            else
                System.out.println("Enter right child of "+ parentData+": ");
        }
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false,rootData, true); // for left sub tree
        BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false); // for right sub tree
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static int numNodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int leftNodeCount = numNodes(root.left);
        int rightNodeCount = numNodes(root.right);
        return 1+leftNodeCount+rightNodeCount;
    }

    public static int largest(BinaryTreeNode<Integer> root){
        if(root==null){
            return -1;
        }
        int largestLeft = largest(root.left);
        int largestRight = largest(root.right);
        return Math.max(root.data,Math.max(largestRight,largestLeft));
    }
    public static int numLeaves(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        else
            return numLeaves(root.left)+numLeaves(root.right);

    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k){
        if(root == null){
            return;
        }
        if(k==0){
            System.out.println(root.data);
            return;
        }
        printAtDepthK(root.left, k-1);
        printAtDepthK(root.right,k-1);
    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(root.left==null && root.right == null){
            return null;
        }

        root.left = removeLeaves(root.left);

        root.right = removeLeaves(root.right);
        return root;
    }
    public static int height(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1+Math.max(leftHeight,rightHeight);
    }
    public static boolean isBalanced(BinaryTreeNode<Integer> root){
        if(root==null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight-rightHeight)>1){
            return false;
        }
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        return isRightBalanced && isLeftBalanced;
    }
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){
        if(root == null){ // base case
            int height = 0;
            boolean isBal = true;
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }

        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
        boolean isBal = true;
        int height = 1+Math.max(leftOutput.height, rightOutput.height);

        if(Math.abs(leftOutput.height - rightOutput.height)>1){
            isBal = false;
        }

        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }
        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data: ");
        int rootData = sc.nextInt();
        if(rootData == -1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);
        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer>  front = pendingChildren.poll();
            System.out.println("Enter Left child of "+ front.data);
            int left = sc.nextInt();
            if(left!=-1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }
            System.out.println("Enter right child of "+ front.data);
            int right = sc.nextInt();
            if(right!=-1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);
            }
        }
        return root;
    }

    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int pre[],int in[],int siPre,int eiPre,int siIn, int eiIn){
        if(siPre>eiPre){
            return null;  //if pre order empty then in order has to be empty too.
        }
        int rootData = pre[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;
        for(int i=siIn;i<=eiIn;i++){
            if(in[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        //we have assumed that root actually is present in inorder.
        //siInLeft is same as start index of inorder
        int siPreLeft=siPre+1;
        int siInLeft=siIn;
        int eiInLeft=rootIndex-1;
        int siInRight=rootIndex+1;
        int eiPreRight=eiPre;
        int eiInRight=eiIn;
        int leftSubtreeLength = eiInLeft-siInLeft+1;
        int eiPreLeft=siPreLeft+leftSubtreeLength-1;
        int siPreRight=eiPreLeft+1;


        BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(pre,in,siPreLeft,eiPreLeft,siInLeft,eiInLeft);
        BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(pre,in,siPreRight,eiPreRight,siInRight,eiPreRight);
        root.left = left;
        root.right = right;
        return root;
    }
    public static BinaryTreeNode<Integer>  buildTreeFromPreIn(int pre[], int in[]){

        BinaryTreeNode<Integer> root = buildTreeFromPreInHelper(pre,in,0,pre.length-1,0,in.length-1);
        return root;
    }

    //root to node path in a binary tree
    public static ArrayList<Integer> nodeToROotPath(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return null;
        }
        if(root.data == x){
            ArrayList<Integer> output = new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> leftOutput = nodeToROotPath(root.left, x);
        if(leftOutput!=null){
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer> rightOutput = nodeToROotPath(root.right,x);
        if(rightOutput!=null){
            rightOutput.add(root.data);
            return rightOutput;
        }
        return null;
    }

}
