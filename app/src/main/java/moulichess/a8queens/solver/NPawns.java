package moulichess.a8queens.solver;

public class NPawns extends ChessSolver {
    public NPawns(int n) {
        super(n);
    }

    @Override
    protected boolean isSafe(int[][] board, int row, int col) {
        // Check if the pawn is not attacking any other pawn in the same column
        for (int i = 0; i < boardSize; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check if the pawn is not attacking any other pawn diagonally
        int[] dx = {-1, 1}; // Diagonal moves (up-left and up-right for a white pawn)
        int[] dy = {-1, 1};

        for (int i = 0; i < 2; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (isValid(newRow, newCol) && board[newRow][newCol] == 1) {
                return false;
            }
        }

        return true;
    }

}
