package DP;


/**
 * @Author : Mohamed Thaiseer
 *
 */
public class EditDistance {

    static int edRecursive(String s1, String s2, int vidx1, int vidx2){

        if(vidx1 == s1.length() || vidx2 == s2.length() ){
              return   Math.max( s1.length()-vidx1, s2.length()-vidx2);
        }


        int ch1 = s1.charAt(vidx1);
        int ch2 = s2.charAt(vidx2);

        int ans  = 0;


        if(ch1 == ch2){
            ans =   edRecursive(s1, s2, vidx1+1, vidx2+1);
        }else{

            int insert = edRecursive(s1, s2, vidx1+1, vidx2);
            int delete  = edRecursive(s1, s2, vidx1, vidx2+1);
            int replace =  edRecursive(s1, s2, vidx1+1, vidx2+1);
            int min =      Math.min(insert, Math.min(delete, replace));
            ans =   min+1;
        }
        return ans;
    }


    static int edRTD(String s1, String s2, int vidx1, int vidx2, int dp[][]){

        if(vidx1 == s1.length() || vidx2 == s2.length() ){
            return   Math.max( s1.length()-vidx1, s2.length()-vidx2);
        }


        int ch1 = s1.charAt(vidx1);
        int ch2 = s2.charAt(vidx2);

        //reuse
        if( dp[vidx1][vidx2] != 0){
            return   dp[vidx1][vidx2];
        }

        int ans  = 0;


        if(ch1 == ch2){
            ans =   edRTD(s1, s2, vidx1+1, vidx2+1, dp);
        }else{

            int insert = edRTD(s1, s2, vidx1+1, vidx2, dp);
            int delete  = edRTD(s1, s2, vidx1, vidx2+1, dp);
            int replace =  edRTD(s1, s2, vidx1+1, vidx2+1, dp);
            int min =      Math.min(insert, Math.min(delete, replace));
            ans =   min+1;
        }

        //store
        dp[vidx1][vidx2] = ans;
        return ans;
    }

    static int edBU(String s1, String s2){


        int dp[][]  = new int[s1.length()+1][s2.length()+1];

        //last column corner case
       int r = s1.length();
       int c = s2.length();
       int s1Len = s1.length();

       for(int i=0; i<=r; i++){
           dp[i][c] =  s1Len - i;
       }

       //last row corner case
       r= s1.length();
       c = s2.length();
       int s2Len = s2.length();

       for(int i=0; i<=s2Len; i++){
           dp[r][i] = s2Len - i;
       }


        for(int i=s1.length()-1; i>=0; i--){

            for(int j=s2.length()-1; j>=0; j--){

                int ch1 = s1.charAt(i);
                int ch2 = s2.charAt(j);


                if(ch1 == ch2){
                    dp[i][j] = dp[i+1][j+1];
                }else{

                    int ins = dp[i+1][j];
                    int del =  dp[i][j+1];
                    int rep = dp[i+1][j+1];

                    dp[i][j]  =  Math.min(ins, Math.min(del, rep))+1;
                }
            }
        }

        for(int i=0; i<dp.length; i++){
            for (int j=0;j<dp[0].length; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }


        return dp[0][0];


    }


    public static void main(String[] args) {
//        String s1 = "abc";
//        String s2 = "axc";


//        String s1 = "abc";
//        String s2 = "ab";
//        String s1 = "saturday";
//        String s2 = "sunday";

        String s1 = "saturdayjhjhjshfjkhjhsjhjhjsdfhffcc";
        String s2 = "sundayhskdfhjkjkhjhfjhsjkhgfkjshfjksdhfffff";

//        int res = edRecursive(s1, s2, 0, 0);
//        System.out.println(res);

//        int dp[][] = new int[s1.length()+1][s2.length()+1];
//        int resTd = edRTD(s1, s2, 0, 0, dp);
//        System.out.println(resTd);

        int resBU = edBU(s1, s2);
        System.out.println(resBU);



    }

}
