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

    public Figure alphaBetaPruning(ChessColor chessColor){
        if (newChessBoard == null){
            newChessBoard = chessBoard;
        }

        Figure bestFi = null;
        int bestValue = -999;
        int boardValue;

        for (Figure fW: newChessBoard.figuresWhite){
            if (fW.move(newChessBoard).size() != 0){
                for (ChessPosition cPos: fW.move(newChessBoard)){
                    fW.step(cPos);
                    newChessBoard.stepsUp();
                    boardValue = evaluateBoard(newChessBoard);
                    fW.undo();
                    newChessBoard.undo();
                    if (boardValue > bestValue){
                        bestValue = boardValue;
                        bestFi = fW;
                        bestMove = cPos;
                    }else if (boardValue == 0){
                        List<ChessPosition> moveList;
                        int randNum = (int) (Math.random() * newChessBoard.figuresWhite.size());
                        moveList = newChessBoard.figuresWhite.get(randNum).move(newChessBoard);
                        while (moveList.size() == 0){
                            randNum = (int) (Math.random() * newChessBoard.figuresWhite.size());
                            moveList = newChessBoard.figuresWhite.get(randNum).move(newChessBoard);
                        }
                        if (moveList.size() != 0){
                            int randI = (int) (Math.random() * moveList.size());
                            bestFi =  newChessBoard.figuresWhite.get(randNum);
                            bestMove = moveList.get(randI);
                        }
                        for (ChessPosition chessPosition : moveList){

                            System.out.println(chessPosition.x + " : " + chessPosition.y);
                        }
                        break;
                    }

                }
            }
        }
        for (Figure f: chessBoard.figuresWhite){
            if (f.x == bestFi.x && f.y == bestFi.y){
                System.out.println(f.x + " " + f.y);
                 f.step(bestMove);
                chessBoard.stepsUp();
            }
        }
        bestFi.step(bestMove);
        newChessBoard.stepsUp();

        return bestFi;
    }

    public int evaluateBoard(ChessBoard chessBoard){
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

}