package recursion;

public class MazePathCount {

    static int countPath(int startRow, int startCol, int endRow, int endCol){

        if(startRow == endRow && startCol == endCol){
            return 1;
        }
        if(startRow > endRow ||  startCol > endCol){

            return 0;
        }

        int res = countPath(startRow, startCol+1, endRow, endCol) +
                  countPath(startRow+1, startCol, endRow,endCol);

        return res;


    }

    public static void main(String[] args) {
       int res = countPath(0,0, 3,3);
        System.out.println(res);
    }

}
