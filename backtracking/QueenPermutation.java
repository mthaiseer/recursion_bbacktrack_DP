package backtracking;

public class QueenPermutation {


    static void queenPermute(boolean [] box, int index, int totalPlaced, int totalQueens, int N, String res){

        if(totalPlaced == totalQueens){
            System.out.println(res);
            return;
        }
        for(int i=0; i<N; i++){
             if(!box[i]){
                 box[i] = true;
                 queenPermute(box, i, totalPlaced+1, totalQueens, N , res+"b"+i);
                 box[i] = false;
             }
        }

    }

    public static void main(String[] args) {
        boolean []box = new boolean[4];
        queenPermute(box, 0, 0, 2, 4, "");
    }


}
