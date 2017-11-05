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
        if (color == ChessColor.WHITE) {
            for (Figure pawn : chessBoard.figuresBlack) {
                if (y - 1 != pawn.y && x == pawn.x && y - 1 >= 0) {
                    moveList.add(new ChessPosition(x, y - 1));
                }
                if (y - 2 != pawn.y && x == pawn.x && y - 2 >= 0) {
                    moveList.add(new ChessPosition(x, y - 2));
                }
            }
            for (int i = 0; i < moveList.size(); i++) {
                if (moveList.get(i).y == y) {
                    moveList.remove(i);
                }
                if (moveList.get(i).y < 0) {
                    moveList.remove(i);
                }
            }
        }

        if (color == ChessColor.BLACK) {
            for (Figure pawn : chessBoard.figuresWhite) {
                if (y + 1 != pawn.y && x == pawn.x && y + 1 <= 7) {
                    moveList.add(new ChessPosition(x, y + 1));
                }
                if (y + 2 != pawn.y && x == pawn.x && y + 2 <= 7) {
                    moveList.add(new ChessPosition(x, y + 2));
                }
            }
            for (int i = 0; i < moveList.size(); i++) {
                if (moveList.get(i).y == y) {
                    moveList.remove(i);
                }
                if (moveList.get(i).y > 7) {
                    moveList.remove(i);
                }
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
