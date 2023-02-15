package easy;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] ints = new int[] { 1,3,5,6 };
        System.out.println("Insert position for 5: " + searchInsert(ints, 5));
        System.out.println("Insert position for 2: " + searchInsert(ints, 2));
        System.out.println("Insert position for 7: " + searchInsert(ints, 7));
    }

    private static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
