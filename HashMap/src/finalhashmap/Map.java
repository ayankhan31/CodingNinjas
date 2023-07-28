package finalhashmap;

import java.util.ArrayList;

public class Map<K,V> {
    ArrayList<MapNode<K,V>> buckets;
    int count; // for using count value
    int numBuckets; //for buckets
    public Map(){
        buckets = new ArrayList<>();
        numBuckets=20;
        for(int i=0;i<numBuckets;i++){
            buckets.add(null);
        }
    }
    public int size(){
        return count;
    }

    private int getBucketIndex(K key){
        int hc = key.hashCode();
        int index = hc%numBuckets;
        return index;
    }
    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        MapNode<K,V> prev = null;
        while(head != null) {
            if (head.key.equals(key)) {
                if(prev!=null)
                    prev.next = head.next;
                else{
                    buckets.set(bucketIndex, head.next);
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        while(head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }

            head = head.next;
        }
        return null;
    }
    public double loadFactor(){
        return (1.0*count)/numBuckets;
    }
    private void reHash(){
        ArrayList<MapNode<K,V>> temp = buckets;
        buckets = new ArrayList<>();
        for(int i=0;i<2*numBuckets;i++){
            buckets.add(null);
        }
        count = 0;
        numBuckets=numBuckets*2;
        for(int i=0;i<temp.size();i++){
            MapNode<K,V> head = temp.get(i);
            while(head!=null){
                K key = head.key;
                V value = head.value;
                insert(key,value);
                head = head.next;
            }
        }
    }
    public void insert(K key, V value){

        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head=head.next;
        }
        //element not there, insert at 0th position of linked list.
        head = buckets.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<>(key,value);
        newNode.next = head;
        buckets.set(bucketIndex,newNode);
        count++;
        double loadFactor = (double)count/numBuckets;
        if(loadFactor>0.7){
            reHash();
        }
    }



}
