package bugspots;

//Author @dsa.java.hub
//Spot the bug 👀
public class MatrixBoundsBug {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5},      // jagged row - only 2 elements
            {7, 8, 9}
        };

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {   // BUG: assumes all rows same length as row 0
                System.out.print(matrix[row][col] + " ");
            }
        }
    }
}