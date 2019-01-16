public class BubbleSort {

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    //swap elements
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 16, 23, 43, 55, 58, 61};
        bubbleSort(array);

        for(int number: array) {
            System.out.print(number + " ");
        }
    }
}