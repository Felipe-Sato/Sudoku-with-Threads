package sudoku_validator;

import java.util.ArrayList;
import java.util.List;

public class VerifyCol extends Thread {
	private Sudoku sudoku;
	private int x;
	private List<Integer> aux = new ArrayList<Integer>();

	public VerifyCol(Sudoku target, int col) {
		this.sudoku = target;
		this.x = col;
	}

	@Override
	public void run() {
		System.out.println("Rodando coluna " + x);
		for (int j = 0; j < 9; j++) {
			if (!(aux.contains(sudoku.getSudoku(x, j)))) {
				aux.add(sudoku.getSudoku(x, j));
			} else {
				System.out.println("Existe erro na coluna " + x);
				this.interrupt();
			}
		}
	}
}
