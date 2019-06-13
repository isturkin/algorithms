public class ShellSort {

	public static void shellSort(int[] a) {
		int n = a.length;
		int h = 1;
		while(h < n / 3) h = 3 * h + 1;

		//do h-sorting of an array
		while(h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j > 0 && a[j] < a[j-h]; j-=h) {
					int temp = a[j];
					a[j] = a[j - h];
					a[j - h] = temp;
				}
			}
			h = h / 3;
		}
	}

	public static void main(String[] args) {
       	   int[] array = new int[] {1, 16, 23, 43, 55, 58, 61};
           shellSort(array);
	   
 	   for(int number: array) {
	       	 System.out.print(number + " ");
	   }
	}

}
