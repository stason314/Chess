package com.chessapp.solution.Figures;

import com.chessapp.solution.ChessBoard;
import com.chessapp.solution.ChessPosition;
import com.chessapp.solution.enums.ChessColor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanislav on 20.10.2017.
 */
public class Pawn extends Figure {

    ChessPosition chessPosition;

    public Pawn(ChessColor chessColor) {
        color = chessColor;
        x = 0;
        y = 0;
        chessPosition = new ChessPosition(x, y);
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard, int x, int y) {
        List<ChessPosition> moveList = new ArrayList<>();

        return null;
    }

    @Override
    public void draw(Graphics2D g,int x, int y) {
        Color black = new Color(0);
        Color white = new Color(0, 204, 255);
        if (color == color.BLACK){
            g.setColor(black);
        }
        if (color == color.WHITE){
            g.setColor(white);
        }

        g.drawString("P", x + 25, y + 25);
    }

    @Override
    public void update() {
        y = 3;
        if (y >= 7){
            y = 7;
        }
        if (y <= 0){
            y = 0;
        }

    }
}
