package com.chessapp.solution.Figures;

import com.chessapp.solution.ChessBoard;
import com.chessapp.solution.ChessPosition;
import com.chessapp.solution.enums.ChessColor;

import java.awt.*;
import java.util.List;

/**
 * Created by Admin on 19.10.2017.
 */
public abstract class Figure {

    public int x;
    public int y;
    public ChessColor color;
    protected Image image;

    public abstract List<ChessPosition> move(ChessBoard chessBoard);

    public abstract void draw(Graphics2D g, int x, int y);
    public abstract void update();


}
