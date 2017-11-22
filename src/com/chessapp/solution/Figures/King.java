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
public class King extends Figure {

    public King(ChessColor chessColor) {
        color = chessColor;
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard) {
        List<ChessPosition> moveList = new ArrayList<>();
        List<Figure> allFig = new ArrayList<>();
        allFig.addAll(chessBoard.figuresBlack);
        allFig.addAll(chessBoard.figuresWhite);


        ChessPosition y1 = new ChessPosition(x, y - 1);
        ChessPosition y2 = new ChessPosition(x, y + 1);
        ChessPosition x1 = new ChessPosition(x - 1, y);
        ChessPosition x2 = new ChessPosition(x + 1, y);
        ChessPosition xy1 = new ChessPosition(x - 1, y - 1);
        ChessPosition xy2 = new ChessPosition(x + 1, y + 1);
        ChessPosition xy3 = new ChessPosition(x - 1, y + 1);
        ChessPosition xy4 = new ChessPosition(x + 1, y - 1);

        moveList.add(y1);
        moveList.add(y2);
        moveList.add(x1);
        moveList.add(x2);
        moveList.add(xy1);
        moveList.add(xy2);
        moveList.add(xy3);
        moveList.add(xy4);

        for (Figure figure : allFig) {
            if ((y - 1 == figure.y && x == figure.x) || y - 1 < 0){
                moveList.remove(y1);
            }
            if ((y + 1 == figure.y && x == figure.x) || y + 1 > 7){
                moveList.remove(y2);
            }
            if ((x - 1 == figure.x && y == figure.y) || x - 1 < 0){
                moveList.remove(x1);
            }
            if ((x + 1 == figure.x && y == figure.y) || x + 1 > 7){
                moveList.remove(x2);
            }
            if ((y - 1 == figure.y && x - 1 == figure.x) || y - 1 < 0 || x - 1 < 0){
                moveList.remove(xy1);
            }
            if ((y + 1 == figure.y && x + 1 == figure.x) || y + 1 > 7 || x + 1 > 7){
                moveList.remove(xy2);
            }
            if ((x - 1 == figure.x && y + 1 == figure.y) || x - 1 < 0 || y + 1 > 7){
                moveList.remove(xy3);
            }
            if ((x + 1 == figure.x && y - 1 == figure.y) || x + 1 > 7 || y - 1 < 0){
                moveList.remove(xy4);
            }

            if (y1.y == figure.y && y1.x == figure.x && figure.color != color){
                moveList.add(y1);
            }
            if (y2.y == figure.y && y2.x == figure.x && figure.color != color){
                moveList.add(y2);
            }
            if (x1.y == figure.y && x1.x == figure.x && figure.color != color){
                moveList.add(x1);
            }
            if (x2.y == figure.y && x2.x == figure.x && figure.color != color){
                moveList.add(x2);
            }
            if (xy1.y == figure.y && xy1.x == figure.x && figure.color != color){
                moveList.add(xy1);
            }
            if (xy2.y == figure.y && xy2.x == figure.x && figure.color != color){
                moveList.add(xy2);
            }
            if (xy3.y == figure.y && xy3.x == figure.x && figure.color != color){
                moveList.add(xy3);
            }
            if (xy4.y == figure.y && xy4.x == figure.x && figure.color != color){
                moveList.add(xy4);
            }
        }

        return moveList;
    }

    @Override
    public void draw(Graphics2D g, int x, int y) {
        try {
            if (color == ChessColor.WHITE){
                image = ImageIO.read(new File("img/whiteKing.png"));
            }
            if (color == ChessColor.BLACK){
                image = ImageIO.read(new File("img/blackKing.png"));
            }

        }catch (IOException e){

        }
        g.drawImage(image, x , y , null);
    }
}
