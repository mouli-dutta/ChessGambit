package moulichess.a8queens.solver;

// Bishop can move diagonally

public class NBishops extends ChessSolver {
    public NBishops(int n) {
        super(n);
    }

    @Override
    protected boolean isValid(int[][] board, int row, int col) {
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
