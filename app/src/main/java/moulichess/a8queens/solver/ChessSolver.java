package moulichess.a8queens.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class ChessSolver {
    protected final int boardSize;
    private int totalSolutions;
    private final List<int[][]> solutions;

    public ChessSolver(int boardSize) {
        this.boardSize = boardSize;
        totalSolutions = 0;
        this.solutions = new ArrayList<>();
        solve(new int[boardSize][boardSize], 0);
    }

    public int getTotalSolutions() {
        return totalSolutions;
    }

    public int[][] getRandomSol() {
        if (totalSolutions > 0) {
            int randIdx = ThreadLocalRandom.current().nextInt(0, totalSolutions);
            return solutions.get(randIdx);
        } else {
            return new int[boardSize][boardSize];
        }
    }

    protected abstract boolean isSafe(int[][] board, int row, int col);

    protected boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < boardSize && col < boardSize;
    }

    private void solve(int[][] board, int row) {
        if (row == boardSize) {
            solutions.add(deepCopy(board));
            totalSolutions++;
        } else {
            for (int col = 0; col < boardSize; col++) {
                if (isSafe(board, row, col)) {
                    board[row][col] = 1;
                    solve(board, row + 1);
                    board[row][col] = 0; // Backtrack
                }
            }
        }
    }

    private int[][] deepCopy(int[][] original) {
        int[][] clone = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            System.arraycopy(original[i], 0, clone[i], 0, boardSize);
        }
        return clone;
    }
}