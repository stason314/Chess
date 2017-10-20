package com.chessapp.solution;

import com.chessapp.solution.Figures.Figure;
import com.chessapp.solution.Figures.Pawn;
import com.chessapp.solution.enums.ChessColor;

import java.awt.*;

/**
 * Created by Admin on 19.10.2017.
 */
public class ChessTile {

    ChessColor chessColor;
    public int x, y;

    public ChessTile() {
        //x = 0;
        //y = 0;
    }

    public void draw(Graphics g, Color color){
        g.setColor(color);
        g.drawRect(x, y, 50, 50);
        g.fillRect(x, y, 50, 50);


    }

    public void drawFigure(Graphics g, Figure figure){
        figure.draw(g, x, y);
    }

}
