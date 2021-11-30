package backtracking;

import java.util.Arrays;

public class QueenCombinationBoxRespect {

    static void queenComination(int [] box, int placedSofar, int totalQueen, int index, String res){

        if(placedSofar == totalQueen){
            System.out.println(res);
            return;
        }

        if (index >= box.length){
            return;
        }

        queenComination(box, placedSofar+1, totalQueen, index+1, res+"b"+index);
        queenComination(box, placedSofar, totalQueen, index+1, res);
    }

    public static void main(String[] args) {
        int[] box = new int[4];
        queenComination(box, 0, 2, 0, "");
    }



}
