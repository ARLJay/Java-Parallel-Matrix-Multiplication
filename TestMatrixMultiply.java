package matrix;


public class TestMatrixMultiply {

	public static void main(String args[]) {

		int[][] mat1 = MatrixGenerator.generateMatrix(1000,1000);
		int[][] mat2 = MatrixGenerator.generateMatrix(1000,1000);

		long start = System.currentTimeMillis();
		
		MatrixMultiplication.matrixMultiply(mat1, mat2);
		System.out.println("Single: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		
		MatrixRowMultiplier.parallelMatrixMultiply(mat1, mat2);
		System.out.println("Parallel: " + (System.currentTimeMillis() - start));
	}
}
