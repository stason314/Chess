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
        weight = 3;
        attackWeight = weight;
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard) {
        List<ChessPosition> moveList = new ArrayList<>();
        List<Figure> allFig = new ArrayList<>();
        allFig.addAll(chessBoard.figuresBlack);
        allFig.addAll(chessBoard.figuresWhite);

        ChessPosition y1 = new ChessPosition(x + 1, y - 2, this);
        ChessPosition y2 = new ChessPosition(x - 1, y - 2, this);
        ChessPosition y3 = new ChessPosition(x + 1, y + 2, this);
        ChessPosition y4 = new ChessPosition(x - 1, y + 2, this);

        ChessPosition x1 = new ChessPosition(x + 2, y + 1, this);
        ChessPosition x2 = new ChessPosition(x + 2, y - 1, this);
        ChessPosition x3 = new ChessPosition(x - 2, y + 1, this);
        ChessPosition x4 = new ChessPosition(x - 2, y - 1, this);

        moveList.add(y1);
        moveList.add(y2);
        moveList.add(y3);
        moveList.add(y4);

        moveList.add(x1);
        moveList.add(x2);
        moveList.add(x3);
        moveList.add(x4);

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

            if ((y + 1 == figure.y && x + 2 == figure.x) || y + 1 > 7 || x + 2 > 7){
                moveList.remove(x1);
            }
            if ((y - 1 == figure.y && x + 2 == figure.x) || y - 1 < 0 || x + 2 > 7){
                moveList.remove(x2);
            }
            if ((y + 1 == figure.y && x - 2 == figure.x) || y + 1 > 7 || x - 2 < 0){
                moveList.remove(x3);
            }
            if ((y - 1 == figure.y && x - 2 == figure.x) || y - 1 < 0 || x - 2 < 0){
                moveList.remove(x4);
            }

            if (y1.y == figure.y && y1.x == figure.x && figure.color != color){
                moveList.add(y1);
            }
            if (y2.y == figure.y && y2.x == figure.x && figure.color != color){
                moveList.add(y2);
            }
            if (y3.y == figure.y && y3.x == figure.x && figure.color != color){
                moveList.add(y3);
            }
            if (y4.y == figure.y && y4.x == figure.x && figure.color != color){
                moveList.add(y4);
            }
            if (x1.y == figure.y && x1.x == figure.x && figure.color != color){
                moveList.add(x1);
            }
            if (x2.y == figure.y && x2.x == figure.x && figure.color != color){
                moveList.add(x2);
            }
            if (x3.y == figure.y && x3.x == figure.x && figure.color != color){
                moveList.add(x3);
            }
            if (x4.y == figure.y && x4.x == figure.x && figure.color != color){
                moveList.add(x1);
            }
        }

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

    @Override
    public void step(ChessPosition chessPosition) {
        savePos = new ChessPosition(x, y, this);
        x = chessPosition.x;
        y = chessPosition.y;

    }

    @Override
    public void undo() {
        step(savePos);
    }
}
