package backtracking;

public class CoinSumCombination {

    static void sumCombination(int coins[], int total,  String ans, int index){

        if(total ==0){
            System.out.println(ans);
            return;
        }

        if(total < 0){
            return;
        }
        for(int i=index; i < coins.length; i++){
            if(total>=coins[i]){
                sumCombination(coins, total - coins[i], ans+coins[i], i);
            }
        }
    }

    public static void main(String[] args) {
        int [] coins = {2,3,5};
        int sum = 50;

        sumCombination(coins, sum, "", 0);
    }


}
