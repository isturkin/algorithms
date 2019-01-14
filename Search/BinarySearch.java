public class BinarySearch {

    public static int binarySearch(int[] array, int searchElement) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;//take an element in the centre of an array
            if (array[mid] == searchElement) {
                return mid;
            }

            if (array[mid] > searchElement) {
                high = mid - 1; //search in the left half
            } else {
                low = mid + 1;//search int the right half
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 16, 23, 43, 55, 58, 61};
        int[] searchElements = new int[] {16, 23, 28};

        for (int searchElement : searchElements) {
            int position = binarySearch(array, searchElement);
            if (position != -1) {
                System.out.println("Element " + searchElement + " found at position " + position);
            } else {
                System.out.println("Element " + searchElement + " not found");
            }
        }
    }
}