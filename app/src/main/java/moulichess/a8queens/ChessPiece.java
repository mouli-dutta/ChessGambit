package moulichess.a8queens;

public class ChessPiece {
    private final PieceType type;

    public ChessPiece(PieceType type) {
        this.type = type;
    }

    public PieceType getType() {
        return type;
    }
}
