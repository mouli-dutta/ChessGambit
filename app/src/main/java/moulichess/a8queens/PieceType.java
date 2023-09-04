package moulichess.a8queens;

public enum PieceType {
    EMPTY(0),
    PAWN(R.drawable.pawn),
    ROOK(R.drawable.rook),
    KNIGHT(R.drawable.knight),
    BISHOP(R.drawable.bishop),
    QUEEN(R.drawable.queen),
    KING(R.drawable.king);

    private final int drawableResource;
    PieceType(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public int getDrawableResource() {
        return drawableResource;
    }
}
