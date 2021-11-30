package backtracking;

public class NQueen {


    private static boolean isSafeToPlace(int[][] board, int row, int col) {

        //upper
        int r = row -1;
        int c = col;

        while(r >=0){

            if(board[r][c] == 1){
                return false;
            }
            r--;

        }

        //left diagonal
        r = row -1;
        c = col-1;

        while(r >=0  && c>=0){
            if(board[r][c] == 1){
                return false;
            }
            r--;
            c--;
        }

        r= row-1;
        c = col+1;

        while(r >= 0 && c <board[0].length){

            if(board[r][c] == 1){
                return false;
            }

            r--;
            c++;

        }





        return true;
    }


    static void placeQueen(int board[][], int  row, int col, String res ){


        //positive basecase
        if(row == board.length){
            System.out.println(res);

            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++) {
                    if (board[i][j] == 1) {
                        System.out.print("x" + " ");
                    } else {
                        System.out.print("-" + " ");
                    }
                }
                System.out.println();
            }
            return;
        }

        //negetive test case
        if(row > board.length-1 || col >  board[0].length-1){
            return;
        }



        if(isSafeToPlace(board, row, col)) {
            board[row][col] = 1;
            placeQueen(board, row + 1, 0, res+ "{"+row+" : "+ col+ "}");
            board[row][col] = 0;
        }


        placeQueen(board, row, col+1, res);




    }

    public static void main(String[] args) {

        int board[][] = new int[4][4];
        placeQueen(board, 0, 0, "");

    }




}
