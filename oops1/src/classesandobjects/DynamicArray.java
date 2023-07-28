package classesandobjects;

public class DynamicArray {

    private int data[];
    private int nextElementIndex;
    public  DynamicArray(){
        data = new int[5];
        nextElementIndex = 0;
    }

    public int size(){
        return nextElementIndex;
    }
    public boolean isEmpty(){
        return nextElementIndex == 0;
    }

    public int get(int i){
        if(i<nextElementIndex){
            return data[i];
        }
        else
            return -1;
    }

    public void set(int i, int value){
        if(i<nextElementIndex){
            data[i] = value;
        }
        else
            System.out.println("Can't Set!");
    }

    public void add(int value){
        if(nextElementIndex==data.length) {
            doubleCapacity();
        }
            data[nextElementIndex] = value;
            nextElementIndex++;
    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2*temp.length];
        for(int i = 0; i<temp.length;i++){
            data[i]=temp[i];
        }
    }

    public int removeLast(){
        if(nextElementIndex==0){
            return -1;
        }
        int x = data[nextElementIndex-1];
        nextElementIndex--;
        return x;
    }

}
