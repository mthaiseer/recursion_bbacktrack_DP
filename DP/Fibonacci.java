package DP;


/**
 * @Author : Mohamed Thaiseer
 *
 */
public class Fibonacci {


    static int fibRecursive(int n){

        if(n == 1 || n ==0){
            return n;
        }

        return fibRecursive(n-1)+ fibRecursive(n-2);
    }

    static int fibTD(int n, int dp[]){

        if(n == 1 || n ==0){
            return n;
        }

        //reuse
        if(dp[n] !=0){
            return dp[n];
        }

        int res =   fibTD(n-1, dp)+ fibTD(n-2, dp);
        //store
        dp[n] = res;
        return  res;

    }

    static int fibBU(int n){

        int dp[] = new int[n+1];
        dp[1] =1;

        for(int i=2; i<=n; i++){

            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }

    static int fibBUSE(int n){

        int dp[] = new int[2];
        dp[1] =1;

        for(int i=2; i<=n; i++){

           int res = dp[0]+ dp[1];
           dp[0] = dp[1];
           dp[1] = res;
        }
        return dp[1];
    }


    public static void main(String[] args) {

        //int n = 5;
        int n = 100000;
        //System.out.println(fibRecursive(n));

        int dp[] = new int[n+1];
        //System.out.println(fibTD(n, dp));

       System.out.println(fibBU(n));
       System.out.println(fibBUSE(n));
    }



}
