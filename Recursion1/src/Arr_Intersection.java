public class Arr_Intersection {
    public static void intersection(int[] arr1, int[] arr2) {
        //Your code goes here
        mergeSort(arr1);
        mergeSort(arr2);
        int arr3[];
        int m = arr1.length;
        int n = arr2.length;
        if (m < n) {
            arr3 = arr1;
            arr1 = arr2;
            arr2 = arr3;
            m = arr1.length;
            n = arr2.length;
        }
        int i=0,j=0;
        while (i < m && j < n) {
            if (arr1[i] == arr2[j]) {
                System.out.print(arr2[j] + " ");
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else{
                j++;
            }
        }
        System.out.println();
    }
}
