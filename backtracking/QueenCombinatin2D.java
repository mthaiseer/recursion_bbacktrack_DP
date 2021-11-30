package backtracking;

public class QueenCombinatin2D {

    static void combination2DTable(int board[][], int row, int col, int queenSofar, int totalQueen, String ans){


        if(queenSofar == totalQueen){
            System.out.println(ans);
            return;
        }

        if(col == board[0].length){
//            row++;
//            col=0;
            combination2DTable(board, row+1, 0, queenSofar, totalQueen, ans);
            return;
        }

        if (row == board.length) {
            return;
        }
        board[row][col] = 1;
        combination2DTable(board, row, col+1, queenSofar+1, totalQueen, ans+"{"+row+"-"+col+"}");
        board[row][col] = 0;

        combination2DTable(board, row, col+1, queenSofar, totalQueen, ans);


    }

    public static void main(String[] args) {

        int[][] board = new int[2][2];
        combination2DTable(board, 0, 0, 0, 2, "");


    }

}
