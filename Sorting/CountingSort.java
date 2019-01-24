public class CountingSort {

    private static final int MAX_ELEMENT = 100;

    public static void countingSort(int[] array) {
        int[] countArray = new int[MAX_ELEMENT + 1];

        //count how many times each element occurs in an array
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]] = countArray[array[i]] + 1;
        }

        int position = 0;
        //iterate through count array and fill it again
        for (int j = 0; j < countArray.length; j++) {
            int count = countArray[j];
            for (int i = 0; i < count; i++) {
                array[position++] = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {32, 7, 10, 5, 2, 18, 1, 23, 100};
        countingSort(array);

        for(int number: array) {
            System.out.print(number + " ");
        }
    }
}