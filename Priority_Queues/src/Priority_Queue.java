//import java.util.ArrayList;
//
//public class Priority_Queue<T> {
//    private ArrayList<Element<T>> heap;
//
//    public Priority_Queue(){
//            heap = new ArrayList<>();
//    }
//    public void insert(T value, int priority){
//        Element<T> e = new Element<>(value,priority);
//        heap.add(e);
//        int childIndex = heap.size()-1;
//        int parentIndex = (childIndex-1)/2;
//
//        while(childIndex > 0){
//            if(heap.get(childIndex).priority<heap.get(parentIndex).priority){
//                Element temp = heap.get(childIndex);
//                heap.set(childIndex,heap.get(parentIndex));
//                heap.set(parentIndex,temp);
//                childIndex=parentIndex;
//                parentIndex = (childIndex-1)/2;
//            }
//            else{
//                return;
//            }
//        }
//    }
//    public T getMin() throws PriorityQueueException {
//        if(isEmpty()){
//            throw new PriorityQueueException();
//        }
//        return heap.get(0).value;
//    }
////    public T removeMin(){
////
////    }
//    public int size(){
//        return heap.size();
//    }
//    public boolean isEmpty(){
//        if(size() == 0)
//            return true;
//        else
//            return false;
//    }
//}
