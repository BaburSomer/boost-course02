package com.bilgeadam.lesson021;

import java.util.Arrays;
import java.util.Scanner;

public class Chess {
	private static final int EMPTY_CELL       = -1;
	private static final int KNIGHTS_POSITION = 0;
	private static final int POSSIBLE_MOVE    = 1;

	private int     linNum;
	private int     colNum;
	private int[][] chess;

	public static void main(String[] args) {
		Chess chessGame = new Chess();
		chessGame.initChessBoard();
		chessGame.readKnightsPosition();
		chessGame.calculatePossiblePositions();
		chessGame.printChessBoard();
	}

	private void printChessBoard() {
		for (int row = 7; row >= 0; row--) { // en tepede a8 olduğu için satır numaraları üst sınırdan başlamalı
			for (char column = 'a'; column <= 'h'; column++) {
				if (chess[row][column - 'a'] == Chess.EMPTY_CELL) { // a'nın ASCİİ değeri 97. Array herzaman 0'dan
																	// başlar [0][0]'cı eleman
					System.out.print(" " + (char) column + (row + 1) + " "); // [0][97-97] oluyor
					// System.out.print(" __ "); // [0][97-97] oluyor
				}
				else {
					if (chess[row][column - 'a'] == Chess.KNIGHTS_POSITION)
						System.out.print(" AT ");
					else
						System.out.print(" XX ");
				}
			}
			System.out.println();
		}
	}

	private void calculatePossiblePositions() {
		if (linNum - 2 >= 0) {
			if (colNum - 1 >= 0)
				chess[linNum - 2][colNum - 1] = Chess.POSSIBLE_MOVE;
			if (colNum + 1 <= 7)
				chess[linNum - 2][colNum + 1] = Chess.POSSIBLE_MOVE;
		}

		if (linNum - 1 >= 0) {
			if (colNum - 2 >= 0)
				chess[linNum - 1][colNum - 2] = Chess.POSSIBLE_MOVE;
			if (colNum + 2 <= 7)
				chess[linNum - 1][colNum + 2] = Chess.POSSIBLE_MOVE;
		}

		if (linNum + 2 <= 7) {
			if (colNum - 1 >= 0)
				chess[linNum + 2][colNum - 1] = Chess.POSSIBLE_MOVE;
			if (colNum + 1 <= 7)
				chess[linNum + 2][colNum + 1] = Chess.POSSIBLE_MOVE;
		}

		if (linNum + 1 <= 7) {
			if (colNum - 2 >= 0)
				chess[linNum + 1][colNum - 2] = Chess.POSSIBLE_MOVE;
			if (colNum + 2 <= 7)
				chess[linNum + 1][colNum + 2] = Chess.POSSIBLE_MOVE;
		}
		// System.out.println(Arrays.deepToString(chess)); // kontrol için array'i göstermek istersek
	}

	private void readKnightsPosition() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Lütfen kolonu belirtiniz (a-h): ");
		String col = sc.nextLine();
		System.out.print("Lütfen satırı belirtiniz (1-8): ");
		int lin = sc.nextInt();
		sc.close();

		colNum                = col.toLowerCase().charAt(0) - 'a'; // 97 çıkartmak yerine
		linNum                = lin - 1;
		chess[linNum][colNum] = Chess.KNIGHTS_POSITION;            // atı yerleştirdiğim pozisyon
	}

	private void initChessBoard() {
		chess = new int[8][8]; // a8
		for (int i = 0; i < 8; i++) {
			Arrays.fill(chess[i], Chess.EMPTY_CELL);
		}
	}
}
