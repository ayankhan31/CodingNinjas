import java.util.ArrayList;

public class RemoveConsecutiveDuplicates {

    public static ArrayList<Integer> removeconsecutiveDuplicates(int arr[]){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                result.add(arr[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {10,10,20,2020,30,40,10};
        ArrayList<Integer> result = removeconsecutiveDuplicates(arr);
        System.out.println(result);
    }
}
