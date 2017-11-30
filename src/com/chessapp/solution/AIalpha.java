package com.chessapp.solution;

import com.chessapp.solution.Figures.Figure;
import com.chessapp.solution.enums.ChessColor;

import java.util.ArrayList;
import java.util.List;

/**

 Created by Stanislav on 22.11.2017.
 */
public class AIalpha {

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

    public int alphaBetaPruning(int depth, ChessColor chessColor){
        newChessBoard = chessBoard;
        if (depth == 0){
            return evaluateBoard(newChessBoard);
        }
        List<ChessPosition> moveList = new ArrayList<>();

        if (chessColor == ChessColor.WHITE){

        }


        int bestValue = -999;
        int boardValue;


        for (Figure fW: newChessBoard.figuresWhite) {
            moveList.addAll(fW.move(newChessBoard));
        }
        for (ChessPosition cPos : moveList) {
            newChessBoard = new ChessBoard();
            combine(newChessBoard);
            newChessBoard.step(cPos);
            boardValue = evaluateBoard(newChessBoard);
            cPos.figure.undo();
            newChessBoard.undo(); // return removed figures
            if (boardValue > bestValue){
                bestValue = boardValue;
                bestMove = cPos;
            }
        }

        newChessBoard.stepsUp();


        return 0;
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

}