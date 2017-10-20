package com.chessapp.solution.Figures;

import com.chessapp.solution.ChessBoard;
import com.chessapp.solution.ChessPosition;
import com.chessapp.solution.enums.ChessColor;

import java.awt.*;
import java.util.List;

/**
 * Created by Stanislav on 20.10.2017.
 */
public class Pawn extends Figure {

    public Pawn(ChessColor chessColor) {
        color = chessColor;
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard, int x, int y) {
        return null;
    }

    @Override
    public void draw(Graphics g,int x, int y) {
        Color black = new Color(0);
        Color white = new Color(255, 255, 255);
        if (color == color.BLACK){
            g.setColor(black);
        }
        if (color == color.WHITE){
            g.setColor(white);
        }

        g.drawString("P", x, y);

    }
}
