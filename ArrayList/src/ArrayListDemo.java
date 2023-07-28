
import java.util.ArrayList;
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(1, 80);

        System.out.println(arr.size());
        System.out.println(arr.get(1));
        System.out.println(arr);
        arr.remove(2);
//        Integer i = 10;
//        arr.remove(i);
        arr.set(0,100);
        System.out.println(arr);
        for(int i: arr){
            System.out.println(i);
        }
    }
}
