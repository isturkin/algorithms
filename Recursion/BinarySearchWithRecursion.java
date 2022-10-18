public class BinarySearchWithRecursion {

	public static int binarySearch(int[] a, int searchElement) {
		int low = 0;
		int high = a.length - 1;
		return binarySearch(a, searchElement, low, high);
	}

	private static int binarySearch(int[] a, int searchElement, int low, int high) {
		//we are out of [low..high] range
		//base recursion case
		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;//take an element in the centre of an array
		
		if (a[mid] == searchElement) {
			return mid;
		}

		if (a[mid] > searchElement) {
			return binarySearch(a, searchElement, low, mid - 1);//search in the left half
		} else {
			return binarySearch(a, searchElement, mid + 1, high);//search in the right half
		}
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
