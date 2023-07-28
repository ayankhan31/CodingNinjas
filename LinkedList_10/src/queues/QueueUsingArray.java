package queues;

public class QueueUsingArray {
    private int data[];
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray(){
        data = new int[5];
        front = -1;
        rear = -1;
    }
    public QueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enqueue(int element)throws QueueFullException{
        if(size==data.length){
            throw new QueueFullException();
        }
        if(front==-1){
            front=0;
        }
        if(rear<size-1){
            rear++;
            size++;
            data[rear]=element;
        }

    }
    public int front()throws QueueEmptyException{
        if(size==0){
            throw new QueueEmptyException();
        }
        return data[front];
    }
    public int dequeue()throws QueueEmptyException{
        if(size==0){
            throw new QueueEmptyException();
        }
        int temp=data[front];
        front++;
        size--;
        if(size==0){
            front=-1;
            rear=-1;
        }
        return temp;
    }
}
