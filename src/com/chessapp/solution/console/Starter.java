package com.chessapp.solution.console;

import com.chessapp.solution.ChessBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 19.10.2017.
 */
public class Starter {
    

    public static void main(String args[]){

        GamePanel gamePanel = new GamePanel();

        JFrame jFrame = new JFrame("CHESS");
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(gamePanel);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        gamePanel.start();

    }
}
