package moulichess.a8queens;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class ChessBoardView extends View {
    private static final int NUM_ROWS = 8;
    private static final int NUM_COLS = 8;

    private final Paint darkTilePaint = new Paint();
    private final Paint lightTilePaint = new Paint();

    private int[][] piecePositions;
    private int pieceImageResource;

    public void setPiecePositions(int[][] piecePositions) {
        this.piecePositions = piecePositions;
        invalidate();
    }

    public void setPieceImageResource(int pieceImageResource) {
        this.pieceImageResource = pieceImageResource;
        invalidate();
    }

    public ChessBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        int darkColor = ContextCompat.getColor(getContext(), R.color.darkTile);
        darkTilePaint.setColor(darkColor);

        int lightColor = ContextCompat.getColor(getContext(), R.color.lightTile);
        lightTilePaint.setColor(lightColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBoard(canvas, getWidth());
        drawChessPiece(canvas, getWidth());
    }

    private void drawChessPiece(Canvas canvas, int width) {
        int tileSize = width / NUM_COLS;

        for(int row = 0; row < NUM_ROWS; ++row) {
            for (int col = 0; col < NUM_COLS; ++col) {
                if (piecePositions[row][col] == 1) {
                    if (pieceImageResource != 0) {
                        Drawable pieceDrawable = ContextCompat.getDrawable(getContext(), pieceImageResource);
                        int left = col * tileSize;
                        int top = row * tileSize;
                        int right = (col + 1) * tileSize;
                        int bottom = (row + 1) * tileSize;

                        assert pieceDrawable != null;
                        pieceDrawable.setBounds(left, top, right, bottom);
                        pieceDrawable.draw(canvas);
                    }
                }
            }
        }
    }

    private void drawBoard(Canvas canvas, int width) {
        int tileSize = width / NUM_COLS;

        for(int row = 0; row < NUM_ROWS; ++row) {
            for (int col = 0; col < NUM_COLS; ++col) {
                if (((row + col) & 1) == 0) {
                    // Even rows and even columns
                    canvas.drawRect(col * tileSize, row * tileSize, (col+1) * tileSize, (row+1) * tileSize, lightTilePaint);
                } else {
                    // Odd rows and odd columns
                    canvas.drawRect(col * tileSize, row * tileSize, (col+1) * tileSize, (row+1) * tileSize, darkTilePaint);
                }
            }
        }
    }
}
