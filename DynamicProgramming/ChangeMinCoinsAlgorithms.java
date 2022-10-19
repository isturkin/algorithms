import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeMinCoinsAlgorithms {

    private static final List<Integer> coins = Arrays.asList(1, 3, 5, 10);

    public static void main(String[] args) {
        System.out.println("F(0):" + minCoinsCount(0));
        System.out.println("F(1):" + minCoinsCount(1));
        System.out.println("F(2):" + minCoinsCount(2));
        System.out.println("F(3):" + minCoinsCount(3));
        System.out.println("F(4):" + minCoinsCount(4));
        System.out.println("F(5):" + minCoinsCount(5));
        System.out.println("F(6):" + minCoinsCount(6));
        System.out.println("F(7):" + minCoinsCount(7));
        System.out.println("F(8):" + minCoinsCount(8));
        System.out.println("F(9):" + minCoinsCount(9));
        System.out.println("F(10):" + minCoinsCount(10));
        System.out.println("F(11):" + minCoinsCount(11));
        System.out.println("F(12):" + minCoinsCount(12));
    }

    private static int minCoinsCount(int k) {
        if (k == 0) {
            return 0;
        }

        List<Integer> variants = new ArrayList<>();
        for (Integer coin : coins) {
            int rest = k - coin;
            if (rest >= 0) {
                variants.add(minCoinsCount(k - coin));
            } else {
                break;
            }
        }
        return 1 + variants.stream().mapToInt(v -> v)
                .min()
                .orElseThrow();
    }
}
