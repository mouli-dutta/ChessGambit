package moulichess.a8queens;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import moulichess.a8queens.solver.ChessSolver;
import moulichess.a8queens.solver.NBishops;
import moulichess.a8queens.solver.NKings;
import moulichess.a8queens.solver.NKnights;
import moulichess.a8queens.solver.NPawns;
import moulichess.a8queens.solver.NQueens;
import moulichess.a8queens.solver.NRooks;
import moulichess.a8queens.spinner.CustomSpinnerAdapter;
import moulichess.a8queens.spinner.SpinnerItems;

public class MainActivity extends AppCompatActivity {
    private ChessBoardView chessBoardView;
    private TextView solutionTextView;
    private Spinner spinner;
    private CustomSpinnerAdapter customSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initIds();
        int boardSize = 8;
        ChessSolver solver = new NQueens(boardSize);
        int drawableResource = PieceType.QUEEN.getDrawableResource();
        initSolver(solver, drawableResource);

        initSpinnerAdapter();
        initSpinnerOnClickListener(boardSize);
    }

    private void initSpinnerOnClickListener(int boardSize) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnerSelectedItem = customSpinnerAdapter.getItem(position).getImageText();
                getSelectedAction(boardSize, spinnerSelectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Invalid choice", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getSelectedAction(int boardSize, String spinnerSelectedItem) {
        if (spinnerSelectedItem != null) {

            if (spinnerSelectedItem.equals(getString(R.string.queen))) {
                ChessSolver solver = new NQueens(boardSize);
                int drawableResource = PieceType.QUEEN.getDrawableResource();
                initSolver(solver, drawableResource);

            } else if (spinnerSelectedItem.equals(getString(R.string.king))) {
                ChessSolver solver = new NKings(boardSize);
                int drawableResource = PieceType.KING.getDrawableResource();
                initSolver(solver, drawableResource);

            } else if (spinnerSelectedItem.equals(getString(R.string.knight))) {
                ChessSolver solver = new NKnights(boardSize);
                int drawableResource = PieceType.KNIGHT.getDrawableResource();
                initSolver(solver, drawableResource);

            } else if (spinnerSelectedItem.equals(getString(R.string.bishop))) {
                ChessSolver solver = new NBishops(boardSize);
                int drawableResource = PieceType.BISHOP.getDrawableResource();
                initSolver(solver, drawableResource);

            } else if (spinnerSelectedItem.equals(getString(R.string.rook))) {
                ChessSolver solver = new NRooks(boardSize);
                int drawableResource = PieceType.ROOK.getDrawableResource();
                initSolver(solver, drawableResource);

            } else if (spinnerSelectedItem.equals(getString(R.string.pawn))) {
                ChessSolver solver = new NPawns(boardSize);
                int drawableResource = PieceType.PAWN.getDrawableResource();
                initSolver(solver, drawableResource);
            }
        }
    }

    private void initSolver(ChessSolver solver, int drawableResource) {
        chessBoardView.setPiecePositions(solver.getRandomSol());
        chessBoardView.setPieceImageResource(drawableResource);

        String totalSol = "Total solutions found = " + solver.getTotalSolutions();
        solutionTextView.setText(totalSol);

        Button generate = findViewById(R.id.generate);
        generate.setOnClickListener(v -> {
            chessBoardView.setPiecePositions(solver.getRandomSol());
            chessBoardView.setPieceImageResource(drawableResource);
        });
    }

    private void initSpinnerAdapter() {
        ArrayList<SpinnerItems> spinnerItems = new ArrayList<>();
        spinnerItems.add(new SpinnerItems(PieceType.QUEEN.getDrawableResource(), getString(R.string.queen)));
        spinnerItems.add(new SpinnerItems(PieceType.KING.getDrawableResource(), getString(R.string.king)));
        spinnerItems.add(new SpinnerItems(PieceType.KNIGHT.getDrawableResource(), getString(R.string.knight)));
        spinnerItems.add(new SpinnerItems(PieceType.BISHOP.getDrawableResource(), getString(R.string.bishop)));
        spinnerItems.add(new SpinnerItems(PieceType.ROOK.getDrawableResource(), getString(R.string.rook)));
        spinnerItems.add(new SpinnerItems(PieceType.PAWN.getDrawableResource(), getString(R.string.pawn)));

        customSpinnerAdapter = new CustomSpinnerAdapter(this, spinnerItems);
        spinner.setAdapter(customSpinnerAdapter);
    }

    private void initIds() {
        chessBoardView = findViewById(R.id.chess_board);
        solutionTextView = findViewById(R.id.total_solutions);
        spinner = findViewById(R.id.spinner_menu);
    }
}