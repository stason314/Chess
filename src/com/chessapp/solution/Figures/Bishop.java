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
public class Bishop extends Figure {

    public Bishop(ChessColor chessColor) {
        color = chessColor;
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard) {
        List<ChessPosition> moveList = new ArrayList<>();

        int countXm = x - 1;
        for (int countY = y + 1; countY < 8; countY++){
            if (countXm >= 0){
                if (chessBoard.chessTiles[countXm][countY].figure != null){
                    break;
                }
                if (chessBoard.chessTiles[countXm][countY].figure == null){
                    moveList.add(new ChessPosition(countXm, countY));

                }
                countXm--;
            }

        }
        int countXp = x + 1;
        for (int countY = y + 1; countY < 8; countY++){

            if (countXp < 8){
                if (chessBoard.chessTiles[countXp][countY].figure != null){
                    break;
                }
                if (chessBoard.chessTiles[countXp][countY].figure == null){
                    moveList.add(new ChessPosition(countXp, countY));

                }
                countXp++;
            }
        }

        countXm = x - 1;
        for (int countY = y - 1; countY >= 0; countY--){

            if (countXm >= 0){
                if (chessBoard.chessTiles[countXm][countY].figure != null){
                    break;
                }
                if (chessBoard.chessTiles[countXm][countY].figure == null){
                    moveList.add(new ChessPosition(countXm, countY));

                }
                countXm--;
            }
        }
        countXp = x + 1;
        for (int countY = y - 1; countY >= 0; countY--){

            if (countXp < 8){
                if (chessBoard.chessTiles[countXp][countY].figure != null){
                    break;
                }
                if (chessBoard.chessTiles[countXp][countY].figure == null){
                    moveList.add(new ChessPosition(countXp, countY));

                }
                countXp++;
            }
        }
        return moveList;
    }

    @Override
    public void draw(Graphics2D g, int x, int y) {
        try {
            if (color == ChessColor.WHITE){
                image = ImageIO.read(new File("img/whiteBishop.png"));
            }
            if (color == ChessColor.BLACK){
                image = ImageIO.read(new File("img/blackBishop.png"));
            }

        }catch (IOException e){

        }
        g.drawImage(image, x , y , null);
    }
}
