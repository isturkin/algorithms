public class SelectionSort {

    public static void selectionSort(int[] array) {
        //choose the smallest element in every iteration
        for (int i = 0; i < array.length - 1; i++) {
            int smallest = array[i];
            int smallestIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < smallest) { //compare every element in the unsorted part of array with the smallest element
                    smallest = array[j];
                    smallestIndex = j;
                }
            }
            //swap elements
            int temp = array[i];
            array[i] = smallest;
            array[smallestIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 16, 23, 43, 55, 58, 61};
        selectionSort(array);

        for(int number: array) {
            System.out.print(number + " ");
        }
    }
}