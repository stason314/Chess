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


        for (Figure figure : allFig) {
            /*for (int i = 0; i < 8; i++){
                moveList.add(new ChessPosition(x ,y + i));
                if (moveList.get(moveList.size() - 1).y == figure.y || moveList.get(moveList.size() - 1).y > 7){
                    break;
                }
                if (moveList.size() > 7){
                    break;
                }
            }
            for (int i = 0; i < 8; i++){
                moveList.add(new ChessPosition(x + i ,y));
                if (moveList.get(moveList.size() - 1).x == figure.x || moveList.get(moveList.size() - 1).x > 7){
                    break;
                }
                if (moveList.size() > 7){
                    break;
                }
            }*/

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
