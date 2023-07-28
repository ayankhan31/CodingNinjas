public class Print {
    public static<T> void printArray(T arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Integer arr[] = new Integer[5];
        for(int i=0;i<5;i++){
            arr[i]=i+1;
        }
        String arr1[] = new String[5];
        for(int i =0;i<5;i++){
            arr1[i]="abc";
        }
        printArray(arr);
        System.out.println();
        printArray(arr1);
    }
}
