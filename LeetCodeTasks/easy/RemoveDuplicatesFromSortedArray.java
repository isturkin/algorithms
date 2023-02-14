package easy;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] ints1 = new int[] { 1,1,2 };
        int[] ints2 = new int[] { 0,0,1,1,1,2,2,3,3,4 };
        System.out.println(removeDuplicates(ints1));
        System.out.println(removeDuplicates(ints2));
    }

    private static int removeDuplicates(int[] nums) {
        int k = 1;
        int tail = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[tail]) {
                tail++;
                if (tail != i) {
                    nums[tail] = nums[i];
                }
                k++;
            }
        }
        return k;
    }
}
