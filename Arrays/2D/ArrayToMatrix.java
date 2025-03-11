import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 
        int rows = arr.length / 3; 
        int cols = 3;

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < arr.length; i++) {
            matrix[i / cols][i % cols] = arr[i];
        }

        // Print the matrix
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
