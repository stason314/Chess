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
        if (color == ChessColor.WHITE) {
            for (Figure figure : chessBoard.figuresBlack) {
                while (moveList.size() < 2){
                    if (y - 1 != figure.y && y - 1 >= 0) {
                        moveList.add(new ChessPosition(x, y - 1));
                    }
                    if (y - 2 != figure.y && y - 2 >= 0) {
                        moveList.add(new ChessPosition(x, y - 2));
                    }
                }

            }
        }

        if (color == ChessColor.BLACK) {
            for (Figure figure : chessBoard.figuresWhite) {
                while (moveList.size() < 2){
                    if (y + 1 != figure.y && y + 1 <= 7) {
                        moveList.add(new ChessPosition(x, y + 1));
                    }
                    if (y + 2 != figure.y && y + 2 <= 7) {
                        moveList.add(new ChessPosition(x, y + 2));
                    }
                }

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
