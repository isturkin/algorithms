import java.util.Arrays;
import java.util.List;

// this greedy decision can give you wrong answer on some set of coins
// for example for the following set of coins (1, 9, 10) and the target nominal k=18
// you will get answer 9 [10, 1, 1, 1, 1, 1, 1, 1, 1]
// but the optimal decision here is 2 [9, 9]
public class ChangeMinCoinsCountGreedyAlgorithm {

    private static final List<Integer> coins = Arrays.asList(1, 3, 5, 10);

    public static void main(String[] args) {
        System.out.println("F(0):" + minCoinCount(0));
        System.out.println("F(1):" + minCoinCount(1));
        System.out.println("F(2):" + minCoinCount(2));
        System.out.println("F(3):" + minCoinCount(3));
        System.out.println("F(4):" + minCoinCount(4));
        System.out.println("F(5):" + minCoinCount(5));
        System.out.println("F(6):" + minCoinCount(6));
        System.out.println("F(7):" + minCoinCount(7));
        System.out.println("F(8):" + minCoinCount(8));
        System.out.println("F(9):" + minCoinCount(9));
        System.out.println("F(10):" + minCoinCount(10));
    }

    private static int minCoinCount(int k) {
        int coinsCount = 0;
        while (k > 0) {
            int maxCoinIndex = -1;
            for (Integer coin : coins) {
                if ((k - coin) >= 0) {
                    maxCoinIndex++;
                } else {
                    break;
                }
            }
            coinsCount++;
            k = k - coins.get(maxCoinIndex);
        }
        return coinsCount;
    }
}
