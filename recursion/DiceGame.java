package recursion;

public class DiceGame {


    static void diceThrow(int i, int n, String temp){

        if(i == n){
            System.out.println(temp);
            return;
        }

        if(i > n) return;

        for(int dice=1; dice<=6; dice++){

            diceThrow(dice+ i, n, temp+dice);


        }


    }

    public static void main(String[] args) {
        diceThrow(0, 10, "");
    }


}
