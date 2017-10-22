package com.chessapp.solution;

import com.chessapp.solution.Figures.Pawn;
import com.chessapp.solution.enums.ChessColor;

import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 19.10.2017.
 */
public class ChessBoard {

    public ChessTile[][] chessTiles;
    public Pawn[] pawnsWhite;
    public Pawn[] pawnsBlack;
    java.util.List<ChessPosition> moveList;


    public ChessBoard() {
        moveList = new ArrayList<>();
        chessTiles = new ChessTile[8][8];
        pawnsWhite = new Pawn[8];
        pawnsBlack = new Pawn[8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                chessTiles[i][j] = new ChessTile();
                chessTiles[i][j].x = 0 + i * 50;
                chessTiles[i][j].y = 0 + j * 50;
            }
        }

        for (int i = 0; i < 8; i ++){
            pawnsWhite[i] = new Pawn(ChessColor.WHITE);
            pawnsWhite[i].x = i;
            pawnsWhite[i].y = 6;
            pawnsBlack[i] = new Pawn(ChessColor.BLACK);
            pawnsBlack[i].x = i;
            pawnsBlack[i].y = 1;
        }
    }

    public void update() throws InterruptedException {
        int randNum = (int) (Math.random() * 8);
        pawnsWhite[randNum].update();
        TimeUnit.SECONDS.sleep(2);
        randNum = (int) (Math.random() * 8);
        pawnsBlack[randNum].update();
    }


    public void draw(Graphics2D g) {
        Color tileBlack = new Color(166, 83, 0);
        Color tileWhite = new Color(0xD9D9D9);
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
            chessTiles[pawnsWhite[i].x][pawnsWhite[i].y].drawFigure(g, pawnsWhite[i]);
        }
        for (int i = 0; i < 8; i ++){
            chessTiles[pawnsBlack[i].x][pawnsBlack[i].y].drawFigure(g, pawnsBlack[i]);
        }

    }

}
