package backtracking;

public class CoinChangeCoinRespect {

    static void coinChange(int coins[], int index, int sum,String res){

        if(sum == 0){
            System.out.println(res);
            return;
        }


        if(index >= coins.length || sum < 0){
            return;
        }

        coinChange(coins, index, sum- coins[index], res+ coins[index]);
        coinChange(coins, index+1, sum, res);
    }

    public static void main(String[] args) {

        int coins[] = {1,2,3};
        coinChange(coins, 0, 4, "");

    }

}
