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
public class Knight extends Figure {

    public Knight(ChessColor chessColor) {
        color = chessColor;
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard) {
        List<ChessPosition> moveList = new ArrayList<>();
        List<Figure> allFig = new ArrayList<>();
        allFig.addAll(chessBoard.figuresBlack);
        allFig.addAll(chessBoard.figuresWhite);

        ChessPosition y1 = new ChessPosition(x + 1, y - 2);
        ChessPosition y2 = new ChessPosition(x - 1, y - 2);
        ChessPosition y3 = new ChessPosition(x + 1, y + 2);
        ChessPosition y4 = new ChessPosition(x - 1, y + 2);

        moveList.add(y1);
        moveList.add(y2);
        moveList.add(y3);
        moveList.add(y4);

        for (Figure figure : allFig) {
            if ((y - 2 == figure.y && x + 1 == figure.x) || y - 2 < 0 || x + 1 > 7){
                moveList.remove(y1);
            }
            if ((y - 2 == figure.y && x - 1 == figure.x) || y - 2 < 0 || x - 1 < 0) {
                moveList.remove(y2);
            }
            if ((y + 2 == figure.y && x + 1 == figure.x) || y + 2 > 7 || x + 1 > 7){
                moveList.remove(y3);
            }
            if ((y + 2 == figure.y && x - 1 == figure.x) || y + 2 > 7 || x - 1 < 0) {
                moveList.remove(y4);
            }
        }

       /* if (chessBoard.chessTiles[x + 1][y - 2].figure == null && y - 2 < 0 || x + 1 > 7){
            moveList.add(new ChessPosition(x + 1, y - 2));
        }
        if (chessBoard.chessTiles[x - 1][y - 2].figure == null && y - 2 < 0 || x - 1 < 0){
            moveList.add(new ChessPosition(x - 1, y - 2));
        }
        if (chessBoard.chessTiles[x + 1][y + 2].figure == null &&  y + 2 < 7 || x + 1 > 7){
            moveList.add(new ChessPosition(x + 1, y + 2));
        }
        if (chessBoard.chessTiles[x - 1][y + 2].figure == null &&  y + 2 < 7 || x - 1 < 0){
            moveList.add(new ChessPosition(x - 1, y + 2));
        }

        if (chessBoard.chessTiles[x + 2][y - 1].figure == null && y - 1 < 0 || x + 2 > 7){
            moveList.add(new ChessPosition(x + 2, y - 1));
        }
        if (chessBoard.chessTiles[x + 2][y + 1].figure == null && y + 1 < 0 || x + 2 > 7){
            moveList.add(new ChessPosition(x + 2, y + 1));
        }
        if (chessBoard.chessTiles[x - 2][y - 1].figure == null && y - 1 < 0 || x + 2 > 7){
            moveList.add(new ChessPosition(x - 2, y - 1));
        }
        if (chessBoard.chessTiles[x - 2][y + 1].figure == null && y + 1 < 7 || x + 2 > 7){
            moveList.add(new ChessPosition(x - 2, y + 1));
        }*/



        return moveList;
    }

    @Override
    public void draw(Graphics2D g, int x, int y) {
        try {
            if (color == ChessColor.WHITE){
                image = ImageIO.read(new File("img/whiteKnight.png"));
            }
            if (color == ChessColor.BLACK){
                image = ImageIO.read(new File("img/blackKnight.png"));
            }

        }catch (IOException e){

        }
        g.drawImage(image, x , y , null);
    }
}
