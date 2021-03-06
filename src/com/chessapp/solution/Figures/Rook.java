package com.chessapp.solution.Figures;

import com.chessapp.solution.ChessBoard;
import com.chessapp.solution.ChessPosition;
import com.chessapp.solution.enums.ChessColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stanislav on 05.11.2017.
 */
public class Rook extends Figure {

    double eval[][] = {
            {  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0},
            {  0.5,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  0.5},
            { -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
            { -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
            { -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
            { -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
            { -0.5,  0.0,  0.0,  0.0,  0.0,  0.0,  0.0, -0.5},
            {  0.0,   0.0, 0.0,  0.5,  0.5,  0.0,  0.0,  0.0},
    };

    int defaultWeight;

    public Rook(ChessColor chessColor) {
        color = chessColor;
        weight = 50;
        defaultWeight =weight;

        if (chessColor == ChessColor.BLACK){
            for (int i = 0; i < eval.length; i++){
                for (int j = 0; j < eval.length / 2; j++){
                    double tmp = eval[i][j];
                    eval[i][j] = eval[eval.length - i - 1][eval.length - j - 1];
                    eval[eval.length - i - 1][eval.length - j - 1] = tmp;
                }
            }
        }
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard) {
        List<ChessPosition> moveList = new ArrayList<>();

        for (int countY = y - 1; countY >= 0; countY--){
            if (chessBoard.chessTiles[x][countY].figure == null){
                moveList.add(new ChessPosition(x, countY, this));
            }
            if (chessBoard.chessTiles[x][countY].figure != null){
                if (chessBoard.chessTiles[x][countY].figure.color != color){
                    moveList.add(new ChessPosition(x, countY, this));
                }
                break;
            }
        }
        for (int countY = y + 1; countY < 8; countY++){
            if (chessBoard.chessTiles[x][countY].figure == null){
                moveList.add(new ChessPosition(x, countY, this));
            }
            if (chessBoard.chessTiles[x][countY].figure != null){
                if (chessBoard.chessTiles[x][countY].figure.color != color){
                    moveList.add(new ChessPosition(x, countY, this));
                }
                break;
            }
        }
        for (int countX = x - 1; countX >= 0; countX--){
            if (chessBoard.chessTiles[countX][y].figure == null){
                moveList.add(new ChessPosition(countX, y, this));
            }
            if (chessBoard.chessTiles[countX][y].figure != null){
                if (chessBoard.chessTiles[countX][y].figure.color != color){
                    moveList.add(new ChessPosition(countX, y, this));
                }
                break;
            }
        }
        for (int countX = x + 1; countX < 8; countX++){
            if (chessBoard.chessTiles[countX][y].figure == null){
                moveList.add(new ChessPosition(countX, y, this));
            }
            if (chessBoard.chessTiles[countX][y].figure != null){
                if (chessBoard.chessTiles[countX][y].figure.color != color){
                    moveList.add(new ChessPosition(countX, y, this));
                }
                break;
            }
        }
        for (ChessPosition chessPosition: moveList){
          //  System.out.println(chessPosition.x + " ----" + chessPosition.y);
        }

        return moveList;
    }

    @Override
    public void draw(Graphics2D g, int x, int y) {
        try {
            if (color == ChessColor.WHITE){
                image = ImageIO.read(new File("img/whiteRook.png"));
            }
            if (color == ChessColor.BLACK){
                image = ImageIO.read(new File("img/blackRook.png"));
            }

        }catch (IOException e){

        }
        g.drawImage(image, x , y , null);
    }

    @Override
    public void step(ChessPosition chessPosition) {
        savePos = new ChessPosition(x, y, this);
        x = chessPosition.x;
        y = chessPosition.y;
        weight = defaultWeight + (int)eval[x][y];
    }

    @Override
    public void undo() {
        step(savePos);
    }

}
