package com.chessapp.solution;

import com.chessapp.solution.Figures.Figure;
import com.chessapp.solution.enums.ChessColor;

import java.util.List;

/**
 * Created by Stanislav on 22.11.2017.
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

    public AIalpha(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;


    }

    public int alphaBetaPruning(ChessColor chessColor){
        if (chessColor == ChessColor.WHITE){
            coastFun = 0;
            max = 0;
            for (Figure whiteFig: chessBoard.figuresWhite){
                whiteCF = 0;
                blackCF = 0;
                if (whiteFig.move(chessBoard).size() != 0){
                    for (ChessPosition move: whiteFig.move(chessBoard)){
                        whiteFig.step(move);
                        for (Figure whiteFigCF: chessBoard.figuresWhite){
                            whiteCF += whiteFigCF.weight + whiteFigCF.weight/whiteFigCF.attackWeight;
                        }
                        for (Figure blackFigCF: chessBoard.figuresBlack){
                            blackCF += blackFigCF.weight + blackFigCF.weight/blackFigCF.attackWeight;
                        }
                        coastFun = whiteCF - blackCF;
                        if (coastFun == 0){
                            figure = whiteFig;
                            bestMove = move;
                            return 0;

                        }
                        if (coastFun > max ){
                            max = coastFun;
                            figure = whiteFig;
                            bestMove = move;
                        }
                        whiteFig.undo();
                    }
                }
            }
        }
        return 0;
    }

}
