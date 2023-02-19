package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals1 = new int[][] { {1,3},{2,6},{8,10},{15,18} };
        Stream.of(merge(intervals1)).forEach(value -> System.out.println(Arrays.toString(value)));
        int[][] intervals2 = new int[][] {{1,4},{4,5}};
        Stream.of(merge(intervals2)).forEach(value -> System.out.println(Arrays.toString(value)));
        int[][] intervals3 = new int[][] {{1,4}, {0,4}};
        Stream.of(merge(intervals3)).forEach(value -> System.out.println(Arrays.toString(value)));
        int[][] intervals4 = new int[][] {{1,4}, {0,1}};
        Stream.of(merge(intervals4)).forEach(value -> System.out.println(Arrays.toString(value)));
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<List<Integer>> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (nextInterval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                result.add(Arrays.asList(currentInterval[0], currentInterval[1]));
                currentInterval = nextInterval;
            }
        }
        result.add(Arrays.asList(currentInterval[0], currentInterval[1]));

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            res[i] = new int[] {list.get(0), list.get(1)};
        }
        return res;
    }
}
