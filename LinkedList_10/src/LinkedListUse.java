import java.util.*;

class DoubleNode{
    Node<Integer> head;
    Node<Integer> tail;
    DoubleNode(Node<Integer> head, Node<Integer> tail){
        this.head = head;
        this.tail = tail;
    }
    DoubleNode(){

    }
}
public class LinkedListUse {

    public static Node<Integer> createLinkedList(){
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        return n1;

    }
    public static void print(Node<Integer> head){
        Node<Integer> currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data+" ");
            currNode=currNode.next;
        }
    }
    public static void increment(Node<Integer> head){
        head.data++;
    }
    public static Node<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);

        int data = sc.nextInt();
        Node<Integer> head = null, tail = null;
        while(data !=-1){
            Node<Integer> currNode = new Node<Integer>(data);
            if(head == null){
                head = currNode;
                tail = currNode;
            }
            else{
                tail.next = currNode;
                tail = currNode;
            }
            data = sc.nextInt();
        }
        return head;
    }
//    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
//        //Your code goes here
//        if(head==null)
//            return head;
//        if(head.next==null)
//            return head;
//        LinkedListNode<Integer> t1=head,t2=head.next;
//        LinkedListNode<Integer> finalhead=head;
//        while(t2!=null){
//            if(t1.data.equals(t2.data))
//            {
//                t2=t2.next;
//            }
//            else{
//                t1.next=t2;
//                t1=t2;
//            }
//        }
//
//        t1.next=null;
//        return finalhead;
//    }
    public static Node<Integer> insertRecursive(Node<Integer> head, int d, int pos){
        if(head==null && pos>0){
            return head;
        }
        if(pos == 0){
            Node<Integer> newNode= new Node<>(d);
            newNode.next = head;
            return newNode;
        }
        else{
            Node<Integer> smallHead = insertRecursive(head.next,d,pos-1);
            head.next = smallHead;
            return head;
        }
    }
    public static Node<Integer> delNodeRecursive(Node<Integer> head, int pos){
        if(head == null){
            return head;
        }
        if(pos == 0){
            return head.next;
        }
        else{
           Node<Integer> smallHead = delNodeRecursive(head.next,pos-1);
           head.next = smallHead;
        }
        return head;
    }
    public static void main(String[] args) {

        Node<Integer> head = takeInput();
//        increment(head);
        print(head);
        insertRecursive(head,20,2);
        System.out.println();
        print(head);
        System.out.println();
        head = delNodeRecursive(head,3);
        print(head);
//        Node<Integer> n1 = new Node<>(10);
//        System.out.println(n1);


    }

    public static DoubleNode reverseRBetter(Node<Integer> head){
        DoubleNode ans;
        if(head == null || head.next == null){
            ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        //This double node will have both head and tail of the reversed linked list
        DoubleNode smallAns = reverseRBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;
        ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;

    }
}
