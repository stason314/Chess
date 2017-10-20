package com.chessapp.solution;

import com.chessapp.solution.Figures.Figure;
import com.chessapp.solution.Figures.Pawn;
import com.chessapp.solution.enums.ChessColor;

import java.awt.*;

/**
 * Created by Admin on 19.10.2017.
 */
public class ChessTile {

    Pawn[] pawns;
    ChessColor chessColor;

    public ChessTile() {
        pawns = new Pawn[16];


    }

    public void draw(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.drawRect(x, y, 50, 50);
        g.fillRect(x, y, 50, 50);
        for (int i = 0; i < 8; i++){
            if (i < 8){
                pawns[i] = new Pawn(chessColor.WHITE);
                pawns[i].draw(g, x+25, y+25);
            }else {
                pawns[i] = new Pawn(chessColor.BLACK);
                pawns[i].draw(g, x+25, y+25);
            }

        }

    }

}
