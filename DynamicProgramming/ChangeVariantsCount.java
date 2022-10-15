import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// coins: 1, 3, 5, 10
// k >= 10
// F(k) = F(k - 1) + F(k - 3) + F(k - 5) + F(k - 10)
// F(0), F(1) = 1
public class ChangeVariantsCount {

    private static final Map<Integer, Integer> nominalToChangeVariantsCount = new HashMap<>();

    private static final List<Integer> coins = Arrays.asList(1, 3, 5, 10);

    static {
        nominalToChangeVariantsCount.put(0, 1);
        nominalToChangeVariantsCount.put(1, 1);
    }

    public static void main(String[] args) {
        System.out.println("F(0):" + changeVariantsForNominal(0));
        System.out.println("F(1):" + changeVariantsForNominal(1));
        System.out.println("F(2):" + changeVariantsForNominal(2));
        System.out.println("F(3):" + changeVariantsForNominal(3));
        System.out.println("F(4):" + changeVariantsForNominal(4));
        System.out.println("F(5):" + changeVariantsForNominal(5));
        System.out.println("F(6):" + changeVariantsForNominal(6));
    }

    private static int changeVariantsForNominal(int k) {
        System.out.println("Change variants count computation for nominal K=" + k);
        if (nominalToChangeVariantsCount.get(k) != null) {
            return nominalToChangeVariantsCount.get(k);
        }

        int sum = 0;
        for (Integer coin : coins) {
            if (k - coin >= 0) {
                System.out.println("Start with coin " + coin);
                sum += changeVariantsForNominal(k - coin);
                nominalToChangeVariantsCount.put(k, sum);
            }
        }
        return sum;
    }
}
