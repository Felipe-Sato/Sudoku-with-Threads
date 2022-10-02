package sudoku_validator;

import java.util.ArrayList;
import java.util.List;

public class VerifyQua extends Thread {

	private Sudoku sudoku;
	private int x;
	private int m, n;
	private List<Integer> aux = new ArrayList<Integer>();

	public VerifyQua(Sudoku target, int qua) {
		this.sudoku = target;
		this.x = qua;
	}

	@Override
	public void run() {
		System.out.println("Rodando Quadrante " + x);
		m = (x%3)*3;
		n = (x/3)*3;
		for (int i = m; i < m + 3; i++) {
			for (int j = n; j < n + 3; j++) {
				if (!(aux.contains(sudoku.getSudoku(i, j)))) {
					aux.add(sudoku.getSudoku(i, j));
				} else {
					System.out.println("Existe erro no quadrante " + x);
					this.interrupt();
				}
			}
		}
	}
}
