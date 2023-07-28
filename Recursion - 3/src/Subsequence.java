import java.util.ArrayList;

public class Subsequence {

    public static String[] subsequence(String input){
        if(input.length()==0){
            String st[] = {""};
            return st;
        }
        String[] smallOutput = subsequence(input.substring(1));
        String[] output = new String[smallOutput.length * 2];
        for(int i=0;i< smallOutput.length;i++){
            output[i]=smallOutput[i];
        }
        for(int i=0;i< smallOutput.length;i++){
            output[smallOutput.length+i] = input.charAt(0) + smallOutput[i];
        }
        return output;
    }

    public static void main(String[] args) {

    }
}
