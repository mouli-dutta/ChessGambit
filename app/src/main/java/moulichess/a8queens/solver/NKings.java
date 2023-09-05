package moulichess.a8queens.solver;

//  Kings can move one square in any direction (horizontally, vertically, or diagonally)

public class NKings extends ChessSolver {
    public NKings(int n) {
        super(n);
    }

    @Override
    protected boolean isSafe(int[][] board, int row, int col) {
        // Check if there's another king in the same row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check if there's another king in the same column
        for (int[] rows : board) {
            if (rows[col] == 1) {
                return false;
            }
        }

        // Check if there's another king in any of the eight adjacent cells
        final int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        final int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (isValid(newRow, newCol) && board[newRow][newCol] == 1) {
                return false; // There's another king in an adjacent cell
            }
        }

        return true; // The king's position is valid
    }

}
