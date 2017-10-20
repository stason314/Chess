package com.chessapp.solution.console;

import com.chessapp.solution.ChessBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 19.10.2017.
 */
public class Starter {
    

    public static void main(String args[]){

        ChessBoard chessBoard = new ChessBoard();

        JFrame jFrame = new JFrame();
        jFrame.setSize(440, 440);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout(1,1));
        jFrame.add(chessBoard);
        jFrame.setVisible(true);

    }
}
