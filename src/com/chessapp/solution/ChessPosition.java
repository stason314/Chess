package com.chessapp.solution;

import com.chessapp.solution.Figures.Figure;

/**
 * Created by Admin on 19.10.2017.
 */
public class ChessPosition {

    public int x;
    public int y;
    public Figure figure;


    public ChessPosition(int x1, int y1, Figure figure) {
        x = x1;
        y = y1;
        this.figure = figure;
    }
}
