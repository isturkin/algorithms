public class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
        //check that there are at least two elements in an array
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);//sort a left sub-array
            quickSort(array, pivot + 1, high);//sort a right sub-array
        }

    }

    private static int partition(int[] array, int low, int high) {
        int pivot = (low + high) / 2;
        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < array[pivot]) i++;
            while (array[j] > array[pivot]) j--;

            if (i <= j) {//swap elements
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        return pivot;
    }

    public static void main(String[] args) {
        int[] array = new int[] {32, 7, 10, 5, 2, 18, 1, 23};
        quickSort(array, 0, array.length - 1);

        for(int number: array) {
            System.out.print(number + " ");
        }
    }
}