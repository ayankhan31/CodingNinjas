public class StackUsingLL <T>{

    private Node<T> head;
    private int size;

    StackUsingLL(){
        head=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }
    public void push(T elem){
        Node<T> newNode = new Node<>(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public T top(){
        if(head==null){
            System.out.println("Stack Empty");
            return null;
        }
        return head.data;
    }
    public T pop(){
        if(isEmpty()==false) {
            T d = head.data;
            head = head.next;
            size--;
            return d;
        }
        return null;
    }
}
