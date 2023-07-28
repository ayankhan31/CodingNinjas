package trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeTest {
    public static void main(String[] args) {

//        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer> node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(3);
//        TreeNode<Integer> node3 = new TreeNode<>(1);
//        TreeNode<Integer> node4 = new TreeNode<>(5);
//        TreeNode<Integer> node5 = new TreeNode<>(6);
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//
//        node2.children.add(node4);
//        node2.children.add(node5);
//        printTree2(root);
        TreeNode<Integer> root = takeInputLevelWise();
        printTree2(root);
    }
    public static void printTree1(TreeNode<Integer> root){
        //this is not a base case, it's a special case.
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        for(int i=0;i<root.children.size();i++){
            TreeNode<Integer> child = root.children.get(i);
            printTree2(child);
        }
    }
    public static void printTree2(TreeNode<Integer> root){

        if(root==null){
            return;
        }
        System.out.print(root.data+": ");
        for(int i=0;i<root.children.size();i++){
            System.out.print(root.children.get(i).data+" ");
        }
        System.out.println();
        for(int i=0;i<root.children.size();i++){
            TreeNode<Integer> child = root.children.get(i);
            printTree2(child);
        }
    }

    public static int numberOfNodes(TreeNode<Integer> root){
        int count=1;
        for(int i=0;i<root.children.size();i++){
            int childCount = numberOfNodes(root.children.get(i));
            count +=childCount;
        }
        return count;
    }

    // Level-wise Input
    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        Queue<TreeNode<Integer>> node = new LinkedList<>();

        System.out.println("Enter root data: ");
        int rootData = sc.nextInt();
        if(rootData==-1)
            return null;

        TreeNode<Integer> root = new TreeNode(rootData);
        node.add(root);
        while(!node.isEmpty()){
            TreeNode<Integer> front = node.poll();
            System.out.println("Enter no  of children for: "+ front.data);
            int childNum = sc.nextInt();
            for(int i=0;i<childNum;i++){
                System.out.println("Eneter "+i+"th child data for: " +front.data);
                int childData=sc.nextInt();
                TreeNode<Integer> childNode=new TreeNode<>(childData);
                front.children.add(childNode);
                node.add(childNode);
            }

        }
        return root;
    }

    Queue<TreeNode<Integer>> node=new LinkedList<>();
		node.add(root);
		while(!node.isEmpty()){
        int n=node.size();
        while(n>0){
            TreeNode<Integer> front = node.poll();
            System.out.print(front.data+" ");
            for(int i=0;i<front.children.size();i++)
            {
                TreeNode<Integer> childNode = front.children.get(i);
                node.add(childNode);
            }
            n--;
        }
        System.out.println();
    }

}
