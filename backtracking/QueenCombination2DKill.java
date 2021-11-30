package backtracking;

public class QueenCombination2DKill {



    private static boolean isSafeToPlaceQueen(int[][] board, int row, int col) {

        //check any queen in upward

        int r  = row;
        int c = col;
        while(r >= 0){

            if(board[r][c] == 1){
                return false;
            }
            r--;

        }

        r = row;
        c = col-1;
        // check left has any queen
        while(c >= 0 ){
            if(board[r][c] == 1){
                return false;
            }
            c--;

        }
        //check left diagonal
        r = row-1;
        c = col-1;
        while (r>= 0 && c >=0){
            if(board[r][c] == 1){
                return false;
            }
            r--;
            c--;
        }

        //check right diagonal
        r = row-1;
        c = col+1;
        while (r >=0 && c<=board[0].length-1){

            if(board[r][c] == 1){
                return false;
            }
            r--;
            c++;


        }
        return true;
    }

    static void placeQueen(int board[][], int row, int col,int tqsf, int totalQueen, String ans){

        if(tqsf == totalQueen){

            System.out.println(ans);
            printBoard(board);
            return;
        }

        if(col == board[0].length){
            row++;
            col=0;
        }

        if(row  == board.length){
            return;
        }



        if(isSafeToPlaceQueen(board, row, col)){
            board[row][col] = 1;
            placeQueen(board, row, col+1, tqsf+1, totalQueen, ans+ "{"+row+ "-"+col+"}");
            board[row][col] = 0;
        }

        placeQueen(board, row, col+1, tqsf, totalQueen, ans);

    }

    private static void printBoard(int[][] board) {
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][] board = new int[3][4];
        placeQueen(board, 0, 0, 0, 3, "");
    }
}
