package backtracking;

public class QueenCombination {

    static void queenCombination(boolean box[], int index, int queenSofar, int totalQueen, String ans){


        if(queenSofar == totalQueen){
            System.out.println(ans);
            return;
        }
        for(int i=index; i< box.length; i++){
           // box[i] = true;
            queenCombination(box, i + 1, queenSofar + 1, totalQueen, ans + "q" + i);
           // box[i] = false;
        }


    }

    public static void main(String[] args) {
        boolean[] box =  new boolean[4];
        queenCombination(box, 0, 0, 2, "");
    }


}
