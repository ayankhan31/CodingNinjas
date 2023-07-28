public class QueueUsingLL<T>{
    private Node<T> front;
    private Node<T> rear;
    int size;

    public QueueUsingLL(){
        front = null;
        rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enqueue(int data) {
        //Implement the enqueue(element) function
        Node newNode = new Node(data);
        if(front == null && rear == null){
            front = newNode;
            rear = newNode;
            size++;
        }
        else{
            rear.next = newNode;
            rear = newNode;
            size++;
        }

    }
    public T front(){
        if(size>0)
            return front.data;
        return null;
    }
    public T dequeue() {
        //Implement the dequeue() function
        if(size == 0)
            return null;
        if(size==1){
            T x = front.data;
            front = null;
            rear = null;
            size--;
            return x;
        }
        T x = front.data;
        front=front.next;
        size--;
        return x;
    }

    public static void main(String[] args) {

    }
}
