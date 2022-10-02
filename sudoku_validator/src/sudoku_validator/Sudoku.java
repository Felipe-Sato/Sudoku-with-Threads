package sudoku_validator;

public class Sudoku {
	private int[][] sudoku = new int[9][9];

	public int[][] getSudoku() {
		return sudoku;
	}

	public int getSudoku(int i, int j) {
		return sudoku[i][j];
	}
	
	public void setSudoku(int data, int i, int j) {
		this.sudoku[i][j] = data;
	}
}
