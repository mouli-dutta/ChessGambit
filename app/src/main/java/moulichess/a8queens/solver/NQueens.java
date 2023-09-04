package moulichess.a8queens.solver;

// Queen can move in any direction (horizontally, vertically or diagonally)

public class NQueens extends ChessSolver {
    public NQueens(int n) {
        super(n);
    }

    @Override
    protected boolean isValid(int[][] board, int row, int col) {
        // Check the same column in previous rows
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // check main diagonal
        int r = row-1, c = col-1;
        while(r >= 0 && c >= 0)
            if (board[r--][c--] == 1) return false;

        // check secondary diagonal
        r = row-1; c = col+1;
        while(r >= 0 && c < board[0].length)
            if (board[r--][c++] == 1) return false;

        return true;
    }
}
