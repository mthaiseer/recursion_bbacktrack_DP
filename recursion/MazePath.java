package recursion;

public class MazePath {

    static void  path(int startRow, int startCol, int endRow, int endCol, String path){

        if(startRow == endRow && startCol== endCol){
            System.out.println(path);
            return;
        }

        if(startRow >  endRow || startCol > endCol){
            return;
        }

        path( startRow, startCol+1, endRow, endCol, path+"R");
        path( startRow+1, startCol, endRow, endCol, path+"D");



    }

    public static void main(String[] args) {
        path(0, 0, 3,3 , "");
    }


}
