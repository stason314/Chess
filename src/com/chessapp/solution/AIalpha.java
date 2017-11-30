package com.chessapp.solution;

import com.chessapp.solution.Figures.Figure;
import com.chessapp.solution.enums.ChessColor;

import java.util.ArrayList;
import java.util.List;

/**

 Created by Stanislav on 22.11.2017.
 */
public class AIalpha implements Runnable{

    private int alpha;
    private int beta;
    private int depth;
    private ChessBoard chessBoard;
    private double coastFun, max = 0, min = 0;
    private double whiteCF = 0, blackCF = 0;

    public Figure figure;
    public ChessPosition bestMove;

    ChessBoard newChessBoard;

    public AIalpha(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;

    }

    public int minMax(int depth, ChessBoard newChessBoard,ChessColor chessColor){
        if (depth == 0){
            return evaluateBoard(newChessBoard);
        }
        List<ChessPosition> moveList = new ArrayList<>();
        int bestValue = 0;

        if (chessColor == ChessColor.WHITE){
            bestValue = -999;
            int boardValue;

            for (Figure fW: newChessBoard.figuresWhite) {
                moveList.addAll(fW.move(newChessBoard));
            }
            for (ChessPosition cPos : moveList) {
                newChessBoard = new ChessBoard();
                combine(newChessBoard);
                newChessBoard.step(cPos);
                boardValue = minMax(depth - 1, newChessBoard, ChessColor.BLACK);
                cPos.figure.undo();
                newChessBoard.undo(); // return removed figures
                if (boardValue > bestValue){
                    bestValue = boardValue;
                    bestMove = cPos;
                }
            }
        }

        if (chessColor == ChessColor.BLACK){
            bestValue = 999;
            int boardValue;

            for (Figure fW: newChessBoard.figuresBlack) {
                moveList.addAll(fW.move(newChessBoard));
            }
            for (ChessPosition cPos : moveList) {
                newChessBoard = new ChessBoard();
                combine(newChessBoard);
                newChessBoard.step(cPos);
                boardValue = -minMax(depth - 1, newChessBoard, ChessColor.WHITE);
                cPos.figure.undo();
                newChessBoard.undo(); // return removed figures
                if (boardValue < bestValue) {
                    bestValue = boardValue;
                    bestMove = cPos;
                }
            }
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