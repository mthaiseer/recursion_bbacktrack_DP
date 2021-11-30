package DP;

/**
 * @Author : Mohamed Thaiseer
 *
 */
public class LongestCommonSubsequence {

    static int lcsRecursive(String s1, String s2, int index1, int index2) {


        if (index1 == s1.length() || index2 == s2.length()) {
            return 0;
        }

        int ans = 0;

        if (s1.charAt(index1) == s2.charAt(index2)) {
            ans = lcsRecursive(s1, s2, index1 + 1, index2 + 1) + 1;
        } else {
            int left = lcsRecursive(s1, s2, index1 + 1, index2);
            int right = lcsRecursive(s1, s2, index1, index2 + 1);
            ans = Math.max(left, right);

        }

        return ans;
    }


    static int lcsTD(String s1, String s2, int index1, int index2, int dp[][]) {


        if (index1 == s1.length() || index2 == s2.length()) {
            return 0;
        }

        if (dp[index1][index2] != 0) {
            return dp[index1][index2];
        }

        int ans = 0;

        if (s1.charAt(index1) == s2.charAt(index2)) {
            ans = lcsTD(s1, s2, index1 + 1, index2 + 1, dp) + 1;
        } else {
            int left = lcsTD(s1, s2, index1 + 1, index2, dp);
            int right = lcsTD(s1, s2, index1, index2 + 1, dp);
            ans = Math.max(left, right);

        }

        //store
        dp[index1][index2] = ans;

        return ans;
    }

    static int lcsBU(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {

            for (int j = s2.length() - 1; j >= 0; j--) {

                int ch1 = s1.charAt(i);
                int ch2 = s2.charAt(j);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {

                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];

    }


    public static void main(String[] args) {


        String s1 = "axbuudvfgfhghddfsfdfdfdsfdgrfhfdsdsdsdsadfvgfhghghgh";
        String s2 = "acbffghgfgfsdfsdfgfgdfdsfdfgghggfdfgfggghjkjlkjlkfskjkjkjsfuijkooofdfdf";


//        int res = lcsRecursive(s1, s2, 0, 0);
//        System.out.println(res);


//        int dp[][] = new int[s1.length()][s2.length()];
//
//        int resTd = lcsTD(s1, s2, 0, 0, dp);
//        System.out.println(resTd);

        //Bottom Up
        int resBU = lcsBU(s1, s2);
        System.out.println(resBU);

    }


}
