package com.chessapp.solution;


import com.chessapp.solution.Figures.*;
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

    public List<Figure> figuresWhite;
    public List<Figure> figuresBlack;
    public List<ChessPosition> moveList;
    AIalpha aIalpha;
    ChessTile[][] saveState;


    public ChessBoard() {
        moveList = new ArrayList<>();
        chessTiles = new ChessTile[8][8];
        saveState = new ChessTile[8][8];
        figuresWhite = new ArrayList<>();
        figuresBlack = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                chessTiles[i][j] = new ChessTile();
                chessTiles[i][j].xReal = i * 50;
                chessTiles[i][j].yReal = j * 50;
                chessTiles[i][j].x = i;
                chessTiles[i][j].y = j;
                saveState[i][j] = chessTiles[i][j];
            }
        }
        //Pawns
        for (int i = 0; i < 8; i ++){
            figuresWhite.add(new Pawn(ChessColor.WHITE));
            figuresWhite.get(i).x = i;
            figuresWhite.get(i).y = 6;
            figuresBlack.add(new Pawn(ChessColor.BLACK));
            figuresBlack.get(i).x = i;
            figuresBlack.get(i).y = 1;
        }
        //Rooks
        figuresBlack.add(new Rook(ChessColor.BLACK));
        figuresBlack.get(8).x = 0;
        figuresBlack.get(8).y = 0;
        figuresBlack.add(new Rook(ChessColor.BLACK));
        figuresBlack.get(9).x = 7;
        figuresBlack.get(9).y = 0;
        figuresWhite.add(new Rook(ChessColor.WHITE));
        figuresWhite.get(8).x = 0;
        figuresWhite.get(8).y = 7;
        figuresWhite.add(new Rook(ChessColor.WHITE));
        figuresWhite.get(9).x = 7;
        figuresWhite.get(9).y = 7;
        //Knights
        figuresBlack.add(new Knight(ChessColor.BLACK));
        figuresBlack.get(10).x = 1;
        figuresBlack.get(10).y = 0;
        figuresBlack.add(new Knight(ChessColor.BLACK));
        figuresBlack.get(11).x = 6;
        figuresBlack.get(11).y = 0;
        figuresWhite.add(new Knight(ChessColor.WHITE));
        figuresWhite.get(10).x = 1;
        figuresWhite.get(10).y = 7;
        figuresWhite.add(new Knight(ChessColor.WHITE));
        figuresWhite.get(11).x = 6;
        figuresWhite.get(11).y = 7;
        //Bishops
        figuresBlack.add(new Bishop(ChessColor.BLACK));
        figuresBlack.get(12).x = 2;
        figuresBlack.get(12).y = 0;
        figuresBlack.add(new Bishop(ChessColor.BLACK));
        figuresBlack.get(13).x = 5;
        figuresBlack.get(13).y = 0;
        figuresWhite.add(new Bishop(ChessColor.WHITE));
        figuresWhite.get(12).x = 2;
        figuresWhite.get(12).y = 7;
        figuresWhite.add(new Bishop(ChessColor.WHITE));
        figuresWhite.get(13).x = 5;
        figuresWhite.get(13).y = 7;
        //Queens
        figuresBlack.add(new Queen(ChessColor.BLACK));
        figuresBlack.get(14).x = 3;
        figuresBlack.get(14).y = 0;
        figuresWhite.add(new Queen(ChessColor.WHITE));
        figuresWhite.get(14).x = 3;
        figuresWhite.get(14).y = 7;
        //Kings
        figuresBlack.add(new King(ChessColor.BLACK));
        figuresBlack.get(15).x = 4;
        figuresBlack.get(15).y = 0;
        figuresWhite.add(new King(ChessColor.WHITE));
        figuresWhite.get(15).x = 4;
        figuresWhite.get(15).y = 7;

        aIalpha = new AIalpha(this);
        stepsUp();

    }


    public void stepsUp(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                if (chessTiles[i][j].figure != null)
                    saveState[i][j].figure = chessTiles[i][j].figure;
            }
        }
        for (int i = 0; i < figuresWhite.size(); i++){
//moveList.addAll(figuresWhite.get(i).move(this));
            for (int j = 0; j < figuresBlack.size(); j++){
                if (figuresWhite.get(i).y == figuresBlack.get(j).y && figuresWhite.get(i).x == figuresBlack.get(j).x){
                    figuresBlack.remove(j);
                }
            }
        }

        List<Figure> allFig = new ArrayList<>();
        allFig.addAll(figuresBlack);
        allFig.addAll(figuresWhite);

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    chessTiles[i][j].figure = null;
                }
                else {
                    chessTiles[i][j].figure = null;
                }
            }
        }
        for (Figure figure:allFig){
            chessTiles[figure.x][figure.y].figure = figure;
        }
    }

    public void undo(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                if (chessTiles[i][j].figure != saveState[i][j].figure){
                    chessTiles[i][j].figure = saveState[i][j].figure;
                    if (chessTiles[i][j].figure.color == ChessColor.WHITE){
                        figuresWhite.add(chessTiles[i][j].figure);
                    }
                    if (chessTiles[i][j].figure.color == ChessColor.BLACK){
                        figuresBlack.add(chessTiles[i][j].figure);
                    }
                }
            }
        }
        // Graphics2D g = new Graphics();
        // draw;

    }

    public void updateWhite(){

        stepsUp();

        Figure figure;
        figure = aIalpha.alphaBetaPruning(ChessColor.WHITE);

        System.out.println(figure + " --" + aIalpha.bestMove.x + " " + aIalpha.bestMove.y);
// aIalpha.figure.step(aIalpha.bestMove);
/* int randNum = (int) (Math.random() * figuresWhite.size());
 moveList = figuresWhite.get(randNum).move(this);
 while (moveList.size() == 0){
     randNum = (int) (Math.random() * figuresWhite.size());
     moveList = figuresWhite.get(randNum).move(this);
 }
 if (moveList.size() != 0){
     int randI = (int) (Math.random() * moveList.size());
     figuresWhite.get(randNum).step(moveList.get(randI));
 }*/
/* for (int i = 0; i < figuresWhite.size(); i++){
     //moveList.addAll(figuresWhite.get(i).move(this));
     for (int j = 0; j < figuresBlack.size(); j++){
         if (figuresWhite.get(i).y == figuresBlack.get(j).y && figuresWhite.get(i).x == figuresBlack.get(j).x){
             figuresBlack.remove(j);
         }
     }
 }*/

        for (ChessPosition chessPosition : moveList){
            System.out.println(chessPosition.x + " : " + chessPosition.y);
        }
        System.out.println("---------------------------------");
        stepsUp();
    }

    public void updateBlack(){

        stepsUp();

        int randNum = (int) (Math.random() * figuresBlack.size());

        moveList = figuresBlack.get(randNum).move(this);
        while (moveList.size() == 0){
            randNum = (int) (Math.random() * figuresBlack.size());
            moveList = figuresBlack.get(randNum).move(this);
        }
        if (moveList.size() != 0){
            int randI = (int) (Math.random() * moveList.size());
            figuresBlack.get(randNum).step(moveList.get(randI));
        }
        for (int i = 0; i < figuresBlack.size(); i++){
            for (int j = 0; j < figuresWhite.size(); j++){
                if (figuresBlack.get(i).y == figuresWhite.get(j).y && figuresBlack.get(i).x == figuresWhite.get(j).x){
                    figuresWhite.remove(j);
                }
            }
        }

        stepsUp();

        for (ChessPosition chessPosition : moveList){
            System.out.println(chessPosition.x + " : " + chessPosition.y);
        }
        System.out.println("---------------------------------");
    }



    public void draw(Graphics2D g) {
        Color tileBlack = new Color(166, 83, 0);
        Color tileWhite = new Color(0xD9D9D9);
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    chessTiles[i][j].draw(g, tileWhite);
                    chessTiles[i][j].figure = null;
                }
                else {
                    chessTiles[i][j].draw(g, tileBlack);
                    chessTiles[i][j].figure = null;
                }
            }
        }
        if (figuresWhite.size() != 0){
            for (Figure figure : figuresWhite){
                chessTiles[figure.x][figure.y].drawFigure(g, figure);
            }
        }
        System.out.println(figuresBlack.size());

        if (figuresBlack.size() != 0)
            for (Figure figure : figuresBlack){
                chessTiles[figure.x][figure.y].drawFigure(g, figure);
        }
    }

}
