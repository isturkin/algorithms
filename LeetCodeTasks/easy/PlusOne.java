package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{ 1, 2, 3 })));
        System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 1 })));
        System.out.println(Arrays.toString(plusOne(new int[] { 9 })));
    }

    private static int[] plusOne(int[] digits) {
        List<Integer> values = IntStream.of(digits).boxed().collect(toList());
        Collections.reverse(values);

        boolean needToAddOne = true;
        int i = 0;

        while (needToAddOne) {
            if (i < values.size()) {
                if (values.get(i) == 9) {
                    values.set(i, 0);
                } else {
                    values.set(i, values.get(i) + 1);
                    needToAddOne = false;
                }
            } else {
                values.add(1);
                needToAddOne = false;
            }
            i++;
        }

        Collections.reverse(values);
        return values.stream().mapToInt(value -> value).toArray();
    }
}
