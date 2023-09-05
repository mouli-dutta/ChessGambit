package moulichess.a8queens.solver;

public class NKnights extends ChessSolver {
    public NKnights(int n) {
        super(n);
    }

    @Override
    protected boolean isSafe(int[][] board, int row, int col) {
        final int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        final int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (isValid(newRow, newCol) && board[newRow][newCol] == 1)
                return false; // The knight is attacking another knight
        }
        return true;
    }
}
