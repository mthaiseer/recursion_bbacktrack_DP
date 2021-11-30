package recursion;

import java.util.ArrayList;
import java.util.Collections;

public class GetSubsequence {


    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        Collections.sort(A);
         ArrayList<ArrayList<Integer>>  finalList = new ArrayList<>();
         ArrayList<Integer> subAns = new ArrayList<>();
         subsetHelper(A, 0, finalList, subAns);
         return finalList;

    }

    private  void  subsetHelper(ArrayList<Integer> A, int index,  ArrayList<ArrayList<Integer>>  finalList,  ArrayList<Integer> subAns  ){

        finalList.add(new ArrayList<>(subAns));
        for(int i=index; i<A.size(); i++){
            subAns.add(A.get(i));
            subsetHelper(A, i+1, finalList, subAns);
            subAns.remove(subAns.size()-1);
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);

        GetSubsequence obj = new GetSubsequence();
        ArrayList<ArrayList<Integer>> subsets = obj.subsets(A);
        System.out.println(subsets);


    }
}
