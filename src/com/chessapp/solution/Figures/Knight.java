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
        weight = 30;
        attackWeight = weight;
    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard) {
        List<ChessPosition> moveList = new ArrayList<>();
        //up
        if (y - 2 >= 0 && x - 1 >= 0) {
            if (chessBoard.chessTiles[x - 1][y - 2].figure == null) {
                moveList.add(new ChessPosition(x - 1, y - 2,this));
            } else if (chessBoard.chessTiles[x - 1][y - 2].figure.color != color) {
                moveList.add(new ChessPosition(x - 1, y - 2,this));
            }
        }
        if (y - 2 >= 0 && x + 1 < 8) {
            if (chessBoard.chessTiles[x + 1][y - 2].figure == null) {
                moveList.add(new ChessPosition(x + 1, y - 2,this));
            } else if (chessBoard.chessTiles[x + 1][y - 2].figure.color != color){
                moveList.add(new ChessPosition(x + 1, y - 2,this));
            }
        }
        //down
        if (y + 2 < 8 && x - 1 >= 0) {
            if (chessBoard.chessTiles[x - 1][y + 2].figure == null) {
                moveList.add(new ChessPosition(x - 1, y + 2,this));
            } else if (chessBoard.chessTiles[x - 1][y + 2].figure.color != color) {
                moveList.add(new ChessPosition(x - 1, y + 2,this));
            }
        }
        if (y + 2 < 8 && x + 1 < 8) {
            if (chessBoard.chessTiles[x + 1][y + 2].figure == null) {
                moveList.add(new ChessPosition(x + 1, y + 2,this));
            } else if (chessBoard.chessTiles[x + 1][y + 2].figure.color != color){
                moveList.add(new ChessPosition(x + 1, y + 2,this));
            }
        }
        //left
        if (y + 1 < 8 && x - 2 >= 0) {
            if (chessBoard.chessTiles[x - 2][y + 1].figure == null) {
                moveList.add(new ChessPosition(x - 2, y + 1,this));
            } else if (chessBoard.chessTiles[x - 2][y + 1].figure.color != color) {
                moveList.add(new ChessPosition(x - 2, y + 1,this));
            }
        }
        if (y - 1 >= 0 && x - 2 >= 0) {
            if (chessBoard.chessTiles[x - 2][y - 1].figure == null) {
                moveList.add(new ChessPosition(x - 2, y - 1,this));
            } else if (chessBoard.chessTiles[x - 2][y - 1].figure.color != color){
                moveList.add(new ChessPosition(x - 2, y - 1,this));
            }
        }
        //right
        if (y + 1 < 8 && x + 2 < 8) {
            if (chessBoard.chessTiles[x + 2][y + 1].figure == null) {
                moveList.add(new ChessPosition(x + 2, y + 1,this));
            } else if (chessBoard.chessTiles[x + 2][y + 1].figure.color != color) {
                moveList.add(new ChessPosition(x + 2, y + 1,this));
            }
        }
        if (y - 1 >= 0 && x + 2 < 8) {
            if (chessBoard.chessTiles[x + 2][y - 1].figure == null) {
                moveList.add(new ChessPosition(x + 2, y - 1,this));
            } else if (chessBoard.chessTiles[x + 2][y - 1].figure.color != color){
                moveList.add(new ChessPosition(x + 2, y - 1,this));
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
