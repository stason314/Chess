package com.chessapp.solution.console;

import com.chessapp.solution.ChessBoard;
import com.chessapp.solution.Figures.Pawn;
import com.chessapp.solution.enums.ChessColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by Stanislav on 21.10.2017.
 */
public class GamePanel extends JPanel implements Runnable {

    public static int WIDTH=400;//600
    public static int HEIGHT=400;//600

    private Thread thread;

    private Graphics2D g;
    private BufferedImage image;

    private int FPS;
    private double millisToFPS;
    private long timerFPS;
    private int sleepTime;

    ChessBoard chessBoard;

    //CONSTRUCTOR
    public GamePanel(){
        super();

        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        FPS = 1;
        millisToFPS = 1000/FPS;
        sleepTime = 0;

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g =(Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        //init
        chessBoard = new ChessBoard();




        while (true){//TODO rendering
            timerFPS = System.nanoTime();

            try {
                gameUpdate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameRender();
            gameDraw();
            timerFPS = (System.nanoTime()-timerFPS )/1000000;
            if (millisToFPS > timerFPS){
                sleepTime = (int) (millisToFPS - timerFPS);
            }else sleepTime = 1;
            try {

                thread.sleep(sleepTime); //TODO FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(sleepTime);
            timerFPS = 0;
            sleepTime = 1;

        }
    }

    private void gameUpdate() throws InterruptedException {
        chessBoard.update();
    }


    private void gameRender(){
        chessBoard.draw(g);

    }

    private void gameDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();

    }

}
