package backtracking;

public class CoinSumPermutation {

    static void sumPermutation(int coins[], int total, String ans, int index){

        if(total ==0){
            System.out.println(ans);
            return;
        }

        if(total < 0){
            return;
        }
        for(int i=0; i < coins.length; i++){
            if(total>=coins[i]){
                sumPermutation(coins, total - coins[i], ans+coins[i], i);
            }
        }
    }

    public static void main(String[] args) {
        int [] coins = {2,3,5};
        int sum = 10;

        sumPermutation(coins, sum, "", 0);
    }

}
