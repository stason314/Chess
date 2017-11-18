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
public class Queen extends Figure {

    public Queen(ChessColor chessColor) {
        color = chessColor;
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard) {
        List<ChessPosition> moveList = new ArrayList<>();

        for (int countY = y - 1; countY >= 0; countY--){
            if (chessBoard.chessTiles[x][countY].figure == null){
                moveList.add(new ChessPosition(x, countY));
            }
            if (chessBoard.chessTiles[x][countY].figure != null){
                break;
            }
        }
        for (int countY = y + 1; countY < 8; countY++){
            if (chessBoard.chessTiles[x][countY].figure == null){
                moveList.add(new ChessPosition(x, countY));
            }
            if (chessBoard.chessTiles[x][countY].figure != null){
                break;
            }
        }
        for (int countX = x - 1; countX >= 0; countX--){
            if (chessBoard.chessTiles[countX][y].figure == null){
                moveList.add(new ChessPosition(countX, y));
            }
            if (chessBoard.chessTiles[countX][y].figure != null){
                break;
            }
        }
        for (int countX = x + 1; countX < 8; countX++){
            if (chessBoard.chessTiles[countX][y].figure == null){
                moveList.add(new ChessPosition(countX, y));
            }
            if (chessBoard.chessTiles[countX][y].figure != null){
                break;
            }
        }

        //diagonal
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
                image = ImageIO.read(new File("img/whiteQueen.png"));
            }
            if (color == ChessColor.BLACK){
                image = ImageIO.read(new File("img/blackQueen.png"));
            }

        }catch (IOException e){

        }
        g.drawImage(image, x , y , null);
    }
}
