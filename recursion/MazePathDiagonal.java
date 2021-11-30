package recursion;

public class MazePathDiagonal {

    static void pathDiagonal(int startRow, int startCol, int endRow, int endCol, String path){

        if(startRow == endRow && startCol == endCol){
            System.out.println(path);
            return;
        }

        if(startRow   >  endRow ||  startCol > endCol){
            return;
        }
        pathDiagonal(startRow, startCol+1, endRow, endCol, path+"R");
        pathDiagonal(startRow+1, startCol, endRow, endCol, path+"D");
        pathDiagonal(startRow+1, startCol+1, endRow, endCol, path+"C");





    }

    public static void main(String[] args) {

        pathDiagonal(0, 0, 2, 2, "");

    }

}
