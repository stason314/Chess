package com.chessapp.solution;

import com.chessapp.solution.Figures.Figure;
import com.chessapp.solution.enums.ChessColor;

import java.util.ArrayList;
import java.util.List;

/**

 Created by Stanislav on 22.11.2017.
 */
public class AIalpha implements Runnable{


    private ChessBoard chessBoard;


    public AIalpha(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;

    }


    public ChessPosition minMaxRoot(int depth, ChessBoard newChessBoard, ChessColor chessColor){
        List<ChessPosition> moveList = new ArrayList<>();
        List<ChessPosition> bestMoves = new ArrayList<>();
        int bestValue;
        int boardValue;
        ChessPosition bestMoveFounded = null;
        int count = 0;

        if (chessColor == ChessColor.WHITE){
            bestValue = -9999;

            for (Figure fW: newChessBoard.figuresWhite) {
                moveList.addAll(fW.move(newChessBoard));
            }
            for (ChessPosition cPos : moveList) {
                newChessBoard = new ChessBoard();
                combine(newChessBoard);
                newChessBoard.step(cPos);
                boardValue = minMax(depth - 1, newChessBoard, ChessColor.BLACK, -10000, 10000);
                newChessBoard.undo();
               // System.out.println(boardValue + " " + cPos.figure.x + " " + cPos.figure.y + " " + cPos.figure);
                if (boardValue >= bestValue){
                    bestValue = boardValue;
                   // bestMoves.add(cPos);
                    bestMoveFounded = cPos;
                }
            }
            /*if (bestMoves.size() == 1){
                return bestMoves.get(0);
            }else {
                int rand = (int) (Math.random() * bestMoves.size());
                return bestMoves.get(rand);
            }*/
            //System.out.println(bestValue + " WHITE");
           return bestMoveFounded;
        }
        if (chessColor == ChessColor.BLACK){
            bestValue = 9999;

            for (Figure fW: newChessBoard.figuresBlack) {
                moveList.addAll(fW.move(newChessBoard));
            }
            for (ChessPosition cPos : moveList) {
                newChessBoard = new ChessBoard();
                combine(newChessBoard);
                newChessBoard.step(cPos);
                boardValue = minMax(depth - 1, newChessBoard, ChessColor.WHITE, -10000, 10000);
                newChessBoard.undo();
               // System.out.println(boardValue);
                if (boardValue <= bestValue){
                    bestValue = boardValue;
                    bestMoveFounded = cPos;
                }

            }
            return bestMoveFounded;
        }


        return null;
    }


    private int minMax(int depth, ChessBoard newChessBoard,ChessColor chessColor, int alpha, int beta){
        if (depth == 0){
            return evaluateBoard(newChessBoard);
        }

      // System.out.println(count++ +  " zz");
        List<ChessPosition> moveList = new ArrayList<>();
        int bestValue = 0;


        if (chessColor == ChessColor.WHITE){
            bestValue = -9999;

            for (Figure fW: newChessBoard.figuresWhite) {
                moveList.addAll(fW.move(newChessBoard));
            }
            for (ChessPosition cPos : moveList) {
                newChessBoard = new ChessBoard();
                combine(newChessBoard);
                newChessBoard.step(cPos);
                bestValue = Math.max(bestValue, minMax(depth - 1, newChessBoard, ChessColor.BLACK, alpha, beta));
                //cPos.figure.undo();
                newChessBoard.undo(); // return removed figures
                alpha = Math.max(alpha, bestValue);
                if (beta <= alpha){
                    return bestValue;
                }
            }
            return bestValue;
        }

        if (chessColor == ChessColor.BLACK){
            bestValue = 9999;
            for (Figure fW: newChessBoard.figuresBlack) {
                moveList.addAll(fW.move(newChessBoard));
            }
            for (ChessPosition cPos : moveList) {
                newChessBoard = new ChessBoard();
                combine(newChessBoard);
                newChessBoard.step(cPos);
                bestValue = Math.min(bestValue, minMax(depth - 1, newChessBoard, ChessColor.WHITE, alpha, beta));
                newChessBoard.undo(); // return removed figures

                beta = Math.min(beta, bestValue);
                if (beta <= alpha){
                    return  bestValue;
                }
            }
            return bestValue;
        }

        return bestValue;
    }

    private int evaluateBoard(ChessBoard chessBoard){
        int summW = 0;
        int summB = 0;
        for (int i = 0; i < chessBoard.chessTiles.length; i++){
            for (int j = 0; j < chessBoard.chessTiles.length; j++){

                if (chessBoard.chessTiles[i][j].figure != null){
                    if (chessBoard.chessTiles[i][j].figure.color == ChessColor.BLACK){
                        summB += chessBoard.chessTiles[i][j].figure.weight;
                    }
                    if (chessBoard.chessTiles[i][j].figure.color == ChessColor.WHITE){
                        summW += chessBoard.chessTiles[i][j].figure.weight;
                    }
                }
            }

        }
        return summW - summB;
    }

    private void combine(ChessBoard combinedBoard){
        /**List<Figure> comAllFig = new ArrayList<>();
        comAllFig.addAll(combinedBoard.figuresWhite);
        comAllFig.addAll(combinedBoard.figuresBlack);
        //for (Figure )*/
        combinedBoard.figuresBlack = chessBoard.figuresBlack;
        combinedBoard.figuresWhite = chessBoard.figuresWhite;
    }

    @Override
    public void run() {

    }
}