package moulichess.a8queens.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class ChessSolver {
    protected final int n;
    private int totalSolutions;
    private final List<int[][]> solutions;

    public ChessSolver(int n) {
        this.n = n;
        totalSolutions = 0;
        this.solutions = new ArrayList<>();
        solve(new int[n][n], 0);
    }

    public int getTotalSolutions() {
        return totalSolutions;
    }

    public int[][] getRandomSol() {
        if (totalSolutions > 0) {
            int randIdx = ThreadLocalRandom.current().nextInt(0, totalSolutions);
            return solutions.get(randIdx);
        } else {
            return new int[n][n];
        }
    }

    protected abstract boolean isValid(int[][] board, int row, int col);

    private void solve(int[][] board, int row) {
        if (row == n) {
            solutions.add(deepCopy(board));
            totalSolutions++;
        } else {
            for (int col = 0; col < n; col++) {
                if (isValid(board, row, col)) {
                    board[row][col] = 1;
                    solve(board, row + 1);
                    board[row][col] = 0; // Backtrack
                }
            }
        }
    }

    private int[][] deepCopy(int[][] original) {
        int[][] clone = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, clone[i], 0, n);
        }
        return clone;
    }
}