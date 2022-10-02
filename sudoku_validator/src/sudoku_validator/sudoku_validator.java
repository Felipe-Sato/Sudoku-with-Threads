package sudoku_validator;

/**
 * @author Felipe Sato
 * RA = 2050943
 * 
 * Para verificar outros sudokus deve-se alterar o arquivo sudoku.txt
 * Cada linha do sudoku deve ser preenchida continuamente, utilizando
 * " " para delimitar a troca de linha
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class sudoku_validator {
	private static Sudoku sudoku = new Sudoku();

	public static void readSudoku() throws IOException {
		int i = 0, j = 0;
		BufferedReader br = new BufferedReader(
				new FileReader(new File("../sudoku_validator/src/sudoku_validator/sudoku.txt")));
		int c = 0;
		while ((c = br.read()) != -1) {
			if (j == 9) {
				j = 0;
				i++;
			} else {
				sudoku.setSudoku(Character.getNumericValue(c), i, j);
				j++;
			}
		}
	}

	public static void main(String[] args) {
		
		// Carregando a matriz 9x9 do Sudoku
		try {
			readSudoku();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Metodo para imprimir o conteudo do Sudoku
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				System.out.println(sudoku.getSudoku(i, j));
//
//			}
//		}

		// Rodando um thread por linha, por coluna e por quadrante
		for (int x = 0; x < 9; x++) {
			new VerifyCol(sudoku, x).start();
			new VerifyRow(sudoku, x).start();
			new VerifyQua(sudoku, x).start();
		}
	}
}
