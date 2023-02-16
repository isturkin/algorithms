package easy;

public class RemoveElement {

    public static void main(String[] args) {
        int[] ints1 = new int[] { 3,2,2,3 };
        System.out.println(removeElement(ints1, 3));
        int[] ints2 = new int[] { 0,1,2,2,3,0,4,2 };
        System.out.println(removeElement(ints2, 2));
    }

    private static int removeElement(int[] nums, int val) {
        int tail = -1;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                k++;
                tail++;
                nums[tail] = nums[i];
            }
        }

        return k;
    }
}
