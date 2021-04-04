package com.mercadolibre.app.mutantes.utils;

import java.util.Arrays;
import java.util.List;

public class MutanUtils {

	boolean horizontalValidate = false;

	public boolean horizontalValidate(String[] dna) {
		List<String> aLista = Arrays.asList(dna);
		aLista.stream().forEach(p -> {
			int count = 1;
			char c1, c2;
			c1 = p.charAt(0);
			for (int i = 1; i < p.length(); i++) {
				c2 = p.charAt(i);
				if (c1 == c2) {
					count++;
				} else {
					count = 1;
				}

				c1 = c2;
				if (count >= 4) {
					horizontalValidate = true;
				}
			}
		});
		return horizontalValidate;
	}

	public boolean verticalValidate(String[] dna) {

		String[][] matriz = arrayToMatriz(dna);
		for (int i = 0; i < matriz[0].length; i++) {
			int count = 1;
			String c1, c2;
			c1 = matriz[0][i];
			for (int j = 1; j < matriz.length; j++) {
				c2 = matriz[j][i];
				if (c1.equals(c2)) {
					count++;
				} else {
					count = 1;
				}

				c1 = c2;
				if (count >= 4) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean diagonalValidate(String[] dna) {
		String[][] matriz = arrayToMatriz(dna);
		if (recDig(matriz) ||
				recDigInv(matriz)) {
			return true;
		}
		;
		return false;

	}

	private boolean recDigInv(String[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			StringBuffer rec = new StringBuffer();
			for (int j = 0; j < i + 1; j++) {
				rec.append(matriz[j][matriz.length - 1 - i + j]);
			}
			if (rec.length() >= 4) {
				int count = 1;
				String c1, c2;
				c1 = rec.substring(0, 1);
				for (int k = 1; k < rec.length(); k++) {
					c2 = rec.substring(k, k + 1);
					if (c1.equals(c2)) {
						count++;
					} else {
						count = 1;
					}
					c1 = c2;
					if (count >= 4) {
						return true;
					}
				}
			}
		}

		for (int i = 1; i < matriz.length; i++) {
			StringBuffer rec = new StringBuffer();
			for (int j = 0; j < matriz.length - i; j++) {
			}
			if (rec.length() >= 4) {
				int count = 1;
				String c1, c2;
				c1 = rec.substring(0, 1);
				for (int k = 1; k < rec.length(); k++) {
					c2 = rec.substring(k, k + 1);
					if (c1.equals(c2)) {
						count++;
					} else {
						count = 1;
					}
					c1 = c2;
					if (count >= 4) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean recDig(String[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			StringBuffer rec = new StringBuffer();
			for (int j = 0; j <= i; j++) {
				rec.append(matriz[i - j][j]);
			}
			if (rec.length() >= 4) {
				int count = 1;
				String c1, c2;
				c1 = rec.substring(0, 1);
				for (int k = 1; k < rec.length(); k++) {
					c2 = rec.substring(k, k + 1);
					if (c1.equals(c2)) {
						count++;
					} else {
						count = 1;
					}
					c1 = c2;
					if (count >= 4) {
						return true;
					}
				}
			}
		}

		for (int i = 0; i < matriz.length; i++) {
			StringBuffer rec = new StringBuffer();
			for (int j = 0; j < matriz.length - i - 1; j++) {
				rec.append(matriz[matriz.length - j - 1][j + i + 1]);
			}
			if (rec.length() >= 4) {
				int count = 1;
				String c1, c2;
				c1 = rec.substring(0, 1);
				for (int k = 1; k < rec.length(); k++) {
					c2 = rec.substring(k, k + 1);
					if (c1.equals(c2)) {
						count++;
					} else {
						count = 1;
					}
					c1 = c2;
					if (count >= 4) {
						return true;
					}
				}
			}
		}return false;
	}

	public String[][] arrayToMatriz(String[] dna) {

		String[][] matriz = new String[dna.length][dna[0].length()];

		for (int i = 0; i < dna.length; i++) {

			for (int j = 0; j < dna.length; j++) {

				if (j != dna.length) {
					matriz[i][j] = dna[i].substring(j, j + 1);
				}

			}
		}
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		return matriz;

	}



}
