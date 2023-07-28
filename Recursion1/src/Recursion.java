import java.sql.SQLOutput;

public class Recursion {

    public static int fact(int n){
        if(n==0)
            return 1;
        int smallOutput = fact(n-1);
        int output = n* smallOutput;
        return output;
    }
    public static int sumn(int n){
        if(n==0){
            return 0;
        }
        int smallOutput = sumn(n-1);
        int output = n + smallOutput;
        return output;
    }

    public static void print1ton(int n){
        if(n==0){
            return;
        }
        print1ton(n-1);
        System.out.println(n);
    }
    public static int fib(int n){
        if(n==1 || n==2){
            return 1;
        }
        int fib_n_1 = fib(n-1);
        int fib_n_2 = fib(n-2);
        int output = fib_n_1 + fib_n_2;
        return output;
    }

    //Remove all occurrences of 'x' from a String.
    public static String removeX(String input){
        // Write your code here

        if(input.length()==0){
            return input;
        }

        String smallOutput = removeX(input.substring(1));
        if(input.charAt(0)!= 'x'){
            smallOutput = input.charAt(0)+smallOutput;
        }
        else{
            smallOutput = ""+smallOutput;
        }
        return smallOutput;

    }
    public static void mergeSort(int[] input){
        // Write your code here
        if(input.length==0 || input.length == 1)
            return;
        int a1[],a2[];
        int mid = (input.length)/2;
        a1 = new int[mid];
        a2 = new int[(input.length)-mid];
        for(int i=0;i<input.length;i++){
            if(i<mid)
                a1[i]=input[i];
            else
                a2[i-mid]=input[i];
        }
        mergeSort(a1);
        mergeSort(a2);
        merge(a1,a2,input);
    }

    public static void merge(int a[],int b[],int d[]){
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                d[k]=a[i];
                i++;
                k++;
            }
            else{
                d[k]=b[j];
                k++; j++;
            }
        }
        if(i<a.length){
            while(i<a.length) {
                d[k] = a[i];
                i++;
                k++;
            }
        }
        if(j<b.length){
            while(j<b.length){
                d[k]=b[j];
                k++;
                j++;
            }
        }
    }
    public static int binarySearch(int a[], int si, int ei, int x){
        if(si>ei){
            return -1;
        }
        int midIndex=(si+ei)/2;
        if(a[midIndex]==x){
            return midIndex;
        }
        else if(a[midIndex]<x){
            return binarySearch(a,midIndex+1,ei,x);
        }
        else
            return binarySearch(a,si,midIndex-1,x);
    }
    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        // Write your code here
        if(disks<=0)
            return;
        if(disks==1){
            System.out.println(source+" "+destination);
            return;
        }

        towerOfHanoi(disks-1, source, destination, auxiliary);
        System.out.println(source+" "+destination);
        towerOfHanoi(disks-1, auxiliary, source, destination);

    }

    public static void main(String[] args) {
//        System.out.println(fact(5));
//        System.out.println(sumn(4));
//        System.out.println(fib(8));
        int arr[] = {1,4,5,8,23,45,67};
//        System.out.println(binarySearch(arr,0,6,67));
        mergeSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
