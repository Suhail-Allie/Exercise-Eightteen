package org.example;
public class Main {
    private static final int SIZE = 8;
    private int[] board = new int[SIZE];

    public static void main(String[] args) {
        EightQueens solver = new EightQueens();
        if (solver.solve(0)) solver.printBoard();
        else System.out.println("No solution found.");
    }

    private boolean solve(int row) {
        if (row == SIZE) return true;
        for (int col = 0; col < SIZE; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                if (solve(row + 1)) return true;
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }

    private void printBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                System.out.print(board[r] == c ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}