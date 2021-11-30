package recursion;

public class CountDiceGame {

    static  int countDice(int count, int max){

        if(count == max){
            return 1;
        }
        if(count > max){
            return 0;
        }

        int ans  = 0;
        for(int dice = 1; dice<=6; dice++){
            ans+= countDice(count+dice, max);
        }

        return ans;


    }

    public static void main(String[] args) {

        int ans  = countDice(0, 10);
        System.out.println(ans);

    }

}
