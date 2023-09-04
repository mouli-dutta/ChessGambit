package moulichess.a8queens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import moulichess.a8queens.solver.ChessSolver;
import moulichess.a8queens.solver.NBishops;
import moulichess.a8queens.solver.NKings;
import moulichess.a8queens.solver.NQueens;
import moulichess.a8queens.solver.NRooks;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChessBoardView chessBoardView = findViewById(R.id.chess_board);


        ChessSolver nQueens = new NKings(8);
        int drawableResource = PieceType.KING.getDrawableResource();

        chessBoardView.setPiecePositions(nQueens.getRandomSol());
        chessBoardView.setPieceImageResource(drawableResource);

        TextView textView = findViewById(R.id.total_solutions);

        String totalSol = "Total found solutions = " + nQueens.getTotalSolutions();
        textView.setText(totalSol);

        Button generate = findViewById(R.id.generate);
        generate.setOnClickListener(v -> {
            chessBoardView.setPiecePositions(nQueens.getRandomSol());
            chessBoardView.setPieceImageResource(drawableResource);
            System.out.println(Arrays.deepToString(nQueens.getRandomSol()));
        });


    }
}