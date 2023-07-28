public class StackUsingArray {

    private int data[];
    private int topIndex;
    public StackUsingArray(){
        data = new int[10];
        topIndex=-1;
    }

    public int size(){
        return topIndex+1;
    }

    public boolean isEmpty(){
        if(topIndex==-1)
            return true;
        return false;
    }

    public void push(int elem) throws StackFullException {
        if(topIndex==data.length-1){
            StackFullException e = new StackFullException();
            throw e;
        }
            topIndex++;
            data[topIndex]=elem;
    }
    public int top(){
        if(topIndex==-1){
            System.out.println("Stack is Empty");
        }
        else{
            return data[topIndex];
        }
       return -1;
    }

    public int pop(){
        int x=-1;
        if(!isEmpty()){
            x=data[topIndex];
            topIndex--;
            return x;
        }

        return -1;
    }
}
