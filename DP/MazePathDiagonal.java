package DP;



/**
 * @Author : Mohamed Thaiseer
 *
 */
public class MazePathDiagonal {


    static int mazePathDiagonalRecursive(int startRow, int startCol, int endRow, int endCol){

        if(startRow == endRow && startCol == endCol){
            return 1;
        }

        if(startRow >  endRow ||  startCol >  endCol){
            return 0;
        }



        int colpath  = mazePathDiagonalRecursive(startRow, startCol+1, endRow, endCol);
        int rowpath  = mazePathDiagonalRecursive(startRow+1, startCol, endRow, endCol);
        int diagpath  = mazePathDiagonalRecursive(startRow+1, startCol+1, endRow, endCol);


        int res  = colpath+ rowpath+ diagpath;

        return res;

    }

    static int mazePathDiagonalTD(int startRow, int startCol, int endRow, int endCol, int dp[][]){

        if(startRow == endRow && startCol == endCol){
            return 1;
        }

        if(startRow >  endRow ||  startCol >  endCol){
            return 0;
        }


        if(dp[startRow][startCol] != 0){
            return dp[startRow][startCol];
        }

        int colpath  = mazePathDiagonalTD(startRow, startCol+1, endRow, endCol, dp);
        int rowpath  = mazePathDiagonalTD(startRow+1, startCol, endRow, endCol, dp);
        int diagpath  = mazePathDiagonalTD(startRow+1, startCol+1, endRow, endCol, dp);


        int res  = colpath+ rowpath+ diagpath;
        dp[startRow][startCol] = res;

        return res;

    }

    static int mazePathDiagonalDP(int endRow, int endCol){

        int dp[][] = new int[endRow+1][endCol+1];

        for(int row=endRow-1; row>=0; row--){

            for(int col=endCol-1; col>=0; col--){

                if(row == endRow-1 && col == endCol-1){
                    dp[row][col] = 1;
                }else{

                    int cpath = dp[row][col+1];
                    int rpath = dp[row+1][col];
                    int dpath = dp[row+1][col+1];

                    dp[row][col] = cpath+ rpath+ dpath;


                }

            }

        }

//        for(int i=0; i<dp.length; i++){
//            for(int j=0; j<dp[0].length; j++){
//                System.out.print(dp[i][j]+ " ");
//            }
//            System.out.println();
//        }
        return dp[0][0];
    }




    public static void main(String[] args) {

        int n = 20000;
//        int res = mazePathDiagonal(0, 0, n, n);
//        System.out.println(res);

        //TOPDOWN
//        int dp[][] = new int[n+1][n+1];
//        int tdRes = mazePathDiagonalTD(0,0,n,n, dp);
//        System.out.println(tdRes);
//
        //BU
        int buRes = mazePathDiagonalDP(n, n);
        System.out.println(buRes);

    }




}
