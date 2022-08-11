package matrix;

import java.util.Random;

public class MatrixGenerator {
	private static Random random = new Random();

	public static int[][]generateMatrix(int rows, int columns){
		int[][] matrix = new int[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				matrix[i][j] = random.nextInt(10);
			}
		}
		
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
