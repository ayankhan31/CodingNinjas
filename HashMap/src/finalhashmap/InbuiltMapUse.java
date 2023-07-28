package finalhashmap;

import java.util.*;
public class InbuiltMapUse {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        map.put("abc",1);
        map.put("def",3);

        //presence
        if(map.containsKey("abc")){
            System.out.println("map has abc");
        }
        if(map.containsKey("abc1")){
            System.out.println("map has abc");
        }

        //get value
        int v=map.get("abc");
        System.out.println(v);
        int v1=-1;
        if(map.containsKey("abc1"))
            v1 = map.get("abc1");
        System.out.println(v1);

        //remove
//        map.remove("abc");

        //size
        System.out.println(map.size());

        //iterate on a hashmap
        Set<String> keys = map.keySet();
        for(String s:keys){
//            System.out.println(s);
            System.out.println(map.get(s));
        }
        public static ArrayList<Integer> removeDuplicates(int[] arr){
            ArrayList<Integer> output = new ArrayList<>();
            HashMap<Integer,Boolean> map1 = new HashMap<>();
            for(int i=0;i<arr.length;i++){
                if(map1.containsKey(arr[i])){
                    continue;
                }
                output.add(arr[i]);
                map1.put(arr[i],true);
            }
        }
    }
}
