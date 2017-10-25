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
 * Created by Stanislav on 20.10.2017.
 */
public class Pawn extends Figure {

    public Pawn(ChessColor chessColor) {
        color = chessColor;
        x = 0;
        y = 0;

        loadImage();

    }

    @Override
    public List<ChessPosition> move(ChessBoard chessBoard) {
        List<ChessPosition> moveList = new ArrayList<>();
        if (color == ChessColor.WHITE){
            for (Pawn pawn: chessBoard.pawnsBlack){
                if (y - 1 != pawn.y && x == pawn.x && y - 1 >= 0){
                    moveList.add(new ChessPosition(x, y - 1));
                }
                if (y - 2 != pawn.y && x == pawn.x && y - 2 >= 0){
                    moveList.add(new ChessPosition(x, y - 2));
                }
            }
            for (int i = 0; i < moveList.size(); i++){
                if (moveList.get(i).y == y){
                    moveList.remove(i);
                }
                if (moveList.get(i).y < 0){
                    moveList.remove(i);
                }
            }
        }




        return moveList;
    }

    @Override
    public void draw(Graphics2D g,int x, int y) {
        Color black = new Color(0);
        Color white = new Color(255, 2, 0);
        if (color == color.BLACK){
            g.setColor(black);
        }
        if (color == color.WHITE){
            g.setColor(white);
        }

        g.drawImage(image, x , y , null);
        //g.drawString("P", x + 25, y + 25);
    }

    @Override
    public void update() {
        int randYB = 1 +(int) (Math.random() * 2);
        int randYW = 1 +(int) (Math.random() * 3);

        if (color == color.BLACK){
            y += randYB;
        }
        if (color == color.WHITE){
           // y -= randYW;
        }
        if (y >= 7){
            y = 7;
        }
        if (y <= 0){
            y = 0;
        }
    }

    @Override
    protected void loadImage() {
        try {
            if (color == ChessColor.WHITE){
                image = ImageIO.read(new File("img/whitePawn.png"));
            }
            if (color == ChessColor.BLACK){
                image = ImageIO.read(new File("img/blackPawn.png"));
            }

        }catch (IOException e){

        }
    }
}
