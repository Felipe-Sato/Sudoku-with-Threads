package sudoku_validator;

import java.util.ArrayList;
import java.util.List;

public class VerifyRow extends Thread {
	private Sudoku sudoku;
	private int x;
	private List<Integer> aux = new ArrayList<Integer>();

	public VerifyRow(Sudoku target, int row) {
		this.sudoku = target;
		this.x = row;
	}

	@Override
	public void run() {
		System.out.println("Rodando linha " + x );
		for (int i = 0; i < 9; i++) {
			if (!(aux.contains(sudoku.getSudoku(i, x)))) {
				aux.add(sudoku.getSudoku(i, x));
			} else {
				System.out.println("Existe erro na linha " + x);
				this.interrupt();
			}
		}
	}	
}
