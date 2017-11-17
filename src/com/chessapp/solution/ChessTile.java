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
    public int xReal, yReal;
    public int x, y;
    public Figure figure;

    public ChessTile() {
        //x = 0;
        //y = 0;
    }

    public void draw(Graphics2D g, Color color){
        g.setColor(color);
        g.fillRect(xReal, yReal, 50, 50);

    }

    public void drawFigure(Graphics2D g, Figure figure){
        figure.draw(g, xReal, yReal);
        this.figure = figure;
    }


}
