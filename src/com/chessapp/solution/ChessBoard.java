package com.chessapp.solution;


import com.chessapp.solution.Figures.Pawn;
import com.chessapp.solution.enums.ChessColor;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 19.10.2017.
 */
public class ChessBoard {

    public ChessTile[][] chessTiles;

    public List<Pawn> pawnsWhite;
    public List<Pawn> pawnsBlack;
    public List<ChessPosition> moveList;


    public ChessBoard() {
        moveList = new ArrayList<>();
        chessTiles = new ChessTile[8][8];
        pawnsWhite = new ArrayList<>();
        pawnsBlack = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                chessTiles[i][j] = new ChessTile();
                chessTiles[i][j].xC = i * 50;
                chessTiles[i][j].yC = j * 50;
                chessTiles[i][j].x = i;
                chessTiles[i][j].y = j;
            }
        }

        for (int i = 0; i < 8; i ++){
            pawnsWhite.add(new Pawn(ChessColor.WHITE));
            pawnsWhite.get(i).x = i;
            pawnsWhite.get(i).y = 6;
            pawnsBlack.add(new Pawn(ChessColor.BLACK));
            pawnsBlack.get(i).x = i;
            pawnsBlack.get(i).y = 1;

        }
        for (ChessPosition chessPosition : moveList){
            System.out.println(" " + chessPosition.x + "   :" + chessPosition.y);
        }

    }

    public void update() throws InterruptedException {
        int randNum = (int) (Math.random() * pawnsWhite.size());
        pawnsWhite.get(randNum).update();

        for (int i = 0; i < pawnsBlack.size(); i++){
            for (int j = 0; j < pawnsWhite.size(); j++){

                moveList.addAll(pawnsWhite.get(j).move(this));

               /* if (pawnsBlack.get(i).y + 1 == pawnsWhite.get(j).y || pawnsBlack.get(i).y + 2 == pawnsWhite.get(j).y){
                    pawnsBlack.get(i).y = pawnsWhite.get(j).y;
                }
                if (pawnsBlack.get(i).y == pawnsWhite.get(j).y && pawnsBlack.get(i).x == pawnsWhite.get(j).x){
                    pawnsWhite.remove(j);
                }*/
            }

        }

//        System.out.println(pawnsWhite.get(randNum).y + ": " + randNum);
        TimeUnit.SECONDS.sleep(2);
        randNum = (int) (Math.random() * pawnsBlack.size());
        pawnsBlack.get(randNum).update();

        for (int i = 0; i < pawnsWhite.size(); i++){
            for (int j = 0; j < pawnsBlack.size(); j++){

                /*if (pawnsWhite.get(i).y - 1 == pawnsBlack.get(j).y || pawnsWhite.get(i).y - 2 == pawnsBlack.get(j).y){
                    pawnsWhite.get(i).y = pawnsBlack.get(j).y;
                }

                if (pawnsWhite.get(i).y == pawnsBlack.get(j).y && pawnsWhite.get(i).x == pawnsBlack.get(j).x){
                    pawnsBlack.remove(j);
                }*/
            }
        }
        for (ChessPosition chessPosition : moveList){
            System.out.println(" " + chessPosition.x + "   :" + chessPosition.y);
        }
        moveList.clear();


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

        for (int i = 0; i < pawnsWhite.size(); i ++){
            chessTiles[pawnsWhite.get(i).x][pawnsWhite.get(i).y].drawFigure(g, pawnsWhite.get(i));
        }
        if (pawnsBlack.size() != 0)
        for (int i = 0; i < pawnsBlack.size(); i ++){
            chessTiles[pawnsBlack.get(i).x][pawnsBlack.get(i).y].drawFigure(g, pawnsBlack.get(i));
        }
    }

}
