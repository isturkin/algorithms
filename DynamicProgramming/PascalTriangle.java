import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            throw new IllegalArgumentException();
        }

        List<List<Integer>> result = new ArrayList<>();
        return generate(numRows, result);
    }

    private static List<List<Integer>> generate(int numRows, List<List<Integer>> list) {
        if (numRows == 1) {
            list.add(Collections.singletonList(1));
            return list;
        }

        List<List<Integer>> result = generate(numRows - 1, list);
        List<Integer> previousRow = result.get(numRows - 2);
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            newRow.add(previousRow.get(i - 1) + previousRow.get(i));
        }
        newRow.add(1);
        list.add(newRow);

        return list;
    }
}
