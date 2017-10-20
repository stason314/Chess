package com.chessapp.solution;

import com.chessapp.solution.Figures.Figure;
import com.chessapp.solution.enums.ChessColor;

import java.awt.*;

/**
 * Created by Admin on 19.10.2017.
 */
public class ChessTile {
    ChessColor color;
    Figure figure;
    Graphics g;

    public ChessTile() {
    }

    public void draw(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.drawRect(x, y, 50, 50);
        g.fillRect(x, y, 50, 50);
    }

    public void test(){
        System.out.println("HUY");
    }
}
