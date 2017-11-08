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

    public Rook(ChessColor chessColor) {
        color = chessColor;
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard) {
        List<ChessPosition> moveList = new ArrayList<>();
        List<Figure> allFig = new ArrayList<>();
        allFig.addAll(chessBoard.figuresBlack);
        allFig.addAll(chessBoard.figuresWhite);
        int countY = y;
        moveList.add(new ChessPosition(x , y ));


        for (Figure figure : allFig) {

            if (x == figure.x){
                while (moveList.get(moveList.size() - 1).y != figure.y && moveList.get(moveList.size() - 1).x != figure.x){
                    moveList.add(new ChessPosition(x, countY--));
                }
            }



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

}
