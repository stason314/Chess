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

    public ChessTile() {
        //x = 0;
        //y = 0;
    }

    public void draw(Graphics2D g, Color color){
        g.setColor(color);
        g.drawRect(xReal, yReal, 50, 50);
        g.fillRect(xReal, yReal, 50, 50);


    }

    public void drawFigure(Graphics2D g, Figure figure){
        figure.draw(g, xReal, yReal);
    }

    public boolean haveFigure(Figure figure){
        if (figure.x == x && figure.y == y){
            return true;
        }else return false;
    }

}
