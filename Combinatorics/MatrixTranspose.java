public class MatrixTranspose {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}};

        System.out.println("Source matrix:");
        printMatrix(a);

        System.out.println("Transposed matrix:");
        printMatrix(transpose(a));
    }

    private static int[][] transpose(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        int[][] resultMatrix = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                resultMatrix[j][i] = a[i][j];
            }
        }
        return resultMatrix;
    }

    private static void printMatrix(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
		
