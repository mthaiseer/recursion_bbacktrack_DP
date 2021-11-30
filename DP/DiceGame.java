package DP;

/**
 * @Author : Mohamed Thaiseer
 *
 */
public class DiceGame {

    /**
     * Recursion
     * @param target
     * @param diceSofar
     * @return
     */
    static int playDiceRecursive(int target, int diceSofar) {


        if (diceSofar == target) {
            return 1;
        }
        if (diceSofar > target) {
            return 0;
        }
        int res = 0;

        for (int dice = 1; dice <= 6; dice++) {
            res += playDiceRecursive(target, diceSofar + dice);
        }

        return res;
    }

    /**
     * TOPDOWN
     * @param target
     * @param diceSofar
     * @param dp
     * @return
     */
    static int playDiceTD(int target, int diceSofar, int[] dp) {


        if (diceSofar == target) {
            return 1;
        }
        if (diceSofar > target) {
            return 0;
        }

        if (dp[diceSofar] != 0) {
            return dp[diceSofar];
        }

        int res = 0;

        for (int dice = 1; dice <= 6; dice++) {
            res += playDiceTD(target, diceSofar + dice, dp);
        }

        dp[diceSofar] = res;

        return res;
    }

    /**
     * Bottomup
     * @param n
     * @return
     */
    static int playDiceBU(int n) {

        int diceLimit = 6;
        int[] dp = new int[n + diceLimit];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {

            int prev = dp[i + 1] + dp[i + 2] + dp[i + 3] + dp[i + 4] + dp[i + 5] + dp[i + 6] ;
            dp[i] = prev;

        }
        return dp[0];
    }

    /**
     * space efficient
     * @param n
     * @return
     */
    static int playDiceBUSE(int n) {

        int diceLimit = 6;
        int[] dp = new int[diceLimit];
        dp[0] = 1;
        for (int i = n - 1; i >= 0; i--) {

            int ways = dp[0] + dp[1] + dp[2] + dp[3] + dp[4] + dp[5] ;
            dp[5] = dp[4];
            dp[4] = dp[3];
            dp[3] = dp[2];
            dp[2] = dp[1];
            dp[1] = dp[0];
            dp[0] = ways;


        }
        return dp[0];
    }



    public static void main(String[] args) {

        // System.out.println(playDiceRecursive(100, 0));
        int N = 100;
        //int N = 10;
        int[] dp = new int[N + 1];
        System.out.println(playDiceTD(N, 0, dp));

//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i] + " ");
//        }
        System.out.println();

        System.out.println(playDiceBU(N));
        System.out.println(playDiceBUSE(N));

    }
}
