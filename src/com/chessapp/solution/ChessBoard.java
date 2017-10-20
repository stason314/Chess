package com.chessapp.solution;

import com.chessapp.solution.Figures.Pawn;
import com.chessapp.solution.enums.ChessColor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 19.10.2017.
 */
public class ChessBoard extends JComponent{

    public ChessTile[][] chessTiles;
    Pawn pawn;


    public ChessBoard() {
        chessTiles = new ChessTile[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                chessTiles[i][j] = new ChessTile();
                chessTiles[i][j].x = 0 + i * 50;
                chessTiles[i][j].y = 0 + j * 50;
            }
        }


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color tileBlack = new Color(166, 83, 0);
        Color tileWhite = new Color(0xD9D9D9);
        int x = 0;
        int y = 0;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    chessTiles[i][j].draw(g, tileWhite);
                }
                else {
                    chessTiles[i][j].draw(g, tileBlack);
                }
            }
        }

        for (int i = 0; i < 8; i ++){
            pawn = new Pawn(ChessColor.WHITE);
            chessTiles[i][6].drawFigure(g, pawn);
        }
        for (int i = 0; i < 8; i ++){
            pawn = new Pawn(ChessColor.BLACK);
            chessTiles[i][1].drawFigure(g, pawn);
        }



    }

}
