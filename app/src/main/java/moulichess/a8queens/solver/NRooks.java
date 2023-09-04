package moulichess.a8queens.solver;

// Rooks can move horizontally or vertically
public class NRooks extends ChessSolver {
    public NRooks(int n) {
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
        return true;
    }
}
