package DP;


/**
 * @Author : Mohamed Thaiseer
 *
 */
public class MazePath {

    static int countPath(int rowStart, int colStart, int rowEnd, int colEnd){

        if(rowStart == rowEnd && colStart == colEnd){
            return 1;
        }

        if(rowStart > rowEnd || colStart > colEnd){
            return 0;
        }
        int colWise = countPath(rowStart, colStart+1, rowEnd, colEnd);
        int rowWise = countPath(rowStart+1, colStart, rowEnd, colEnd);

        return colWise+ rowWise;
    }

    static int countPathTD(int rowStart, int colStart, int rowEnd, int colEnd, int dp[][]){

        if(rowStart == rowEnd && colStart == colEnd){
            return 1;
        }

        if(rowStart > rowEnd || colStart > colEnd){
            return 0;
        }

        if(dp[rowStart][colStart] != 0){
            return dp[rowStart][colStart];
        }

        int colWise = countPathTD(rowStart, colStart+1, rowEnd, colEnd, dp);
        int rowWise = countPathTD(rowStart+1, colStart, rowEnd, colEnd, dp);

        int ans  = colWise+ rowWise;

        dp[rowStart][colStart] =  ans;

        return ans;
    }

    static int countPathBU(int rowStart, int colStart, int rowEnd, int colEnd ){

        int dp[][] = new int[rowEnd+1][colEnd+1];
        dp[rowEnd-1][colEnd-1] = 1;

        for(int i= rowEnd-1; i>= 0; i--){

            for(int j= colEnd-1; j>=0; j--){

                dp[i][j] +=   dp[i+1][j]+ dp[i][j+1];

            }

        }

        for(int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return dp[0][0];
  }


    public static void main(String[] args) {

        //3*3 matrix
       // int N =3;
        int row = 4;
        int col = 5;
        //System.out.println(countPath(0, 0, row-1,col-1));

        //int dp[][] = new int[N][N];
        //System.out.println(countPathTD(0, 0, row-1,col-1, dp));
        System.out.println(countPathBU(0, 0, row,col));

    }
}
