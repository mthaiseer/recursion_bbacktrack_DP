package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsequence {

    static void generateSubsequence(String str, String res){

        if( str.length() == 0){
            System.out.println(res);
            return;
        }

        generateSubsequence(str.substring(1), res);
        generateSubsequence(str.substring(1), res+ str.charAt(0));



    }

    public static void main(String[] args) {
       generateSubsequence("abc", "");

    }

}
