package matrix;

public class MatrixRowMultiplier extends Thread{
	private int[] row;
	private int[][] matrix;
	private int[] rowResult;
	
	
	public MatrixRowMultiplier(int[] row, int[][] matrix) {
		this.row = row;
		this.matrix = matrix;
	}
	
	public void run() {
		multiplyByRow();
	}
	
	public void multiplyByRow() {
		this.rowResult = new int[row.length];
		int[][] row2d = new int[1][row.length] ;
		for(int i = 0; i < row.length; i++) {
			row2d[0][i] = row[i];
		}
		
		int[][] rowResult2d = MatrixMultiplication.matrixMultiply(row2d, matrix);
				
		for(int i = 0; i < rowResult2d[0].length; i++) {
			rowResult[i] = rowResult2d[0][i];

		}
		
	}
	
	public int[] getResult() {
		return rowResult;
	}
	
	public static int[][] parallelMatrixMultiply(int[][] matrix1, int[][] matrix2){
		int numThreads = matrix1.length;
		MatrixRowMultiplier[] rowMultiplier = new MatrixRowMultiplier[numThreads];
		
		
		for(int i = 0; i < numThreads; i++) { //Convert each row in matrix1 to an array
			int[] row = new int[matrix1[0].length];
			for(int j = 0; j < matrix1[0].length; j++) {
				row[j] = matrix1[i][j];
			}
			rowMultiplier[i] = new MatrixRowMultiplier(row, matrix2); //Create a thread for each row

			rowMultiplier[i].start(); //Start each thread
		}
		
		try {
			for (MatrixRowMultiplier m : rowMultiplier) {
				m.join();
				}
			} catch (InterruptedException e) { }
		int[][] matrix = new int[matrix1.length][matrix2[0].length];
		
		for (int i = 0; i < rowMultiplier.length; i++) {
			for(int j = 0; j < matrix2[0].length; j++) {
				matrix[i][j] = rowMultiplier[i].getResult()[j];
			}
		}
			
		
		
		return matrix;
	}

}
