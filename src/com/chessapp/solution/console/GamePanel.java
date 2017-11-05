package com.chessapp.solution.console;

import com.chessapp.solution.ChessBoard;
import javax.swing.*;
import java.awt.*;
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

        sleepTime = 500;
        final boolean[] flag = {true};

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g =(Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        //init
        chessBoard = new ChessBoard();


        gameRender();
        gameDraw();
        gameRender();
        gameDraw();
       // chessBoard.updateWhite();


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    if (flag[0]){
                        chessBoard.updateWhite();
                        flag[0] = false;
                    }else {
                        chessBoard.updateBlack();
                        flag[0] = true;
                    }
                    gameRender();
                    gameDraw();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });


    }

    /*private void gameUpdate() throws InterruptedException {
        chessBoard.update();
    }*/


    private void gameRender(){
        chessBoard.draw(g);

    }

    private void gameDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();

    }

}
