package matrix;

public class MatrixMultiplication {
	public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2){
		int[][] matrix = new int[matrix1.length][matrix2[0].length]; // MxN x NxP = MxP matrix
				
		for(int i = 0; i < matrix1.length; i++) {
			for(int j = 0; j < matrix2[0].length; j++) {
				for(int k = 0; k < matrix2.length; k++) {
					matrix[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}
		
		return matrix;
		
	}
}
