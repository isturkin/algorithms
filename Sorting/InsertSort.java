public class InsertSort {

    public static void insertSort(int[] array) {
        int i, j;
        int x;

        for (i = 1; i < array.length; i++) {//iterate through an unsorted part of array
            x = array[i];//remember a current unsorted element
            for (j = i - 1; j >= 0 && array[j] > x; j--) {//find position in a sorted part of array
                array[j + 1] = array[j];
            }
            array[j + 1] = x;//insert element
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 16, 23, 43, 55, 58, 61};
        insertSort(array);

        for(int number: array) {
            System.out.print(number + " ");
        }
    }
}