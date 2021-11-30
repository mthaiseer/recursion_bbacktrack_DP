package recursion;

public class MazePathDiagonalCount {


    static int  pathDiagonal(int startRow, int startCol, int endRow, int endCol){

        if(startRow == endRow && startCol == endCol){
            return 1;
        }

        if(startRow   >  endRow ||  startCol > endCol){
            return 0;
        }
        int row =  pathDiagonal(startRow, startCol+1, endRow, endCol );
        int col = pathDiagonal(startRow+1, startCol, endRow, endCol);
        int diag = pathDiagonal(startRow+1, startCol+1, endRow, endCol);


        return row+ col+ diag;


    }

    public static void main(String[] args) {

        int res = pathDiagonal(0, 0, 2, 2);
        System.out.println(res);

    }

}
