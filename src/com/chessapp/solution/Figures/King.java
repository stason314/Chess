package com.chessapp.solution.Figures;

import com.chessapp.solution.ChessBoard;
import com.chessapp.solution.ChessPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 19.10.2017.
 */
public class King extends Figure {


    @Override
    public List<ChessPosition> move(ChessBoard chessBoard, int x, int y) {
        List<ChessPosition> moves;
        moves = new ArrayList<>();

        return moves;
    }

    @Override
    public String toString() {
        return "K";
    }
}
