package com.chessapp.solution;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 19.10.2017.
 */
public class ChessBoard extends JComponent{

    public ChessTile[][] chessTiles;

    public ChessBoard() {
        chessTiles = new ChessTile[8][8];

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                chessTiles[i][j] = new ChessTile();
            }
        }

        chessTiles[0][6].test();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color tileBlack = new Color(166, 83, 0);
        Color tileWhite = new Color(0xFFFFFF);
        int x = 0;
        int y ;
        for (int i = 0; i < 8; i++){
            y = 0;
            for (int j = 0; j < 8; j++) {
                //chessTiles[i][j + 1].draw(g, tileWhite, y, x);

                //chessTiles[i][j+1].draw(g,newColor, y+ 50, x + 50);
                if ((i + j) % 2 == 0) {
                    chessTiles[i][j].draw(g, tileWhite, y, x);

                }
                else {
                    chessTiles[i][j].draw(g, tileBlack, y, x);
                }y += 50;
            }
            x += 50;
        }

    }

}
