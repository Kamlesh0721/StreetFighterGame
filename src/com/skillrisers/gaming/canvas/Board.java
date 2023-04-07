package com.skillrisers.gaming.canvas;
// Board will contain all designing of game
// We will use class JPanel for designing - JPanel can do painting

import com.skillrisers.gaming.sprites.Ryu;
import com.skillrisers.gaming.sprites.Ken;
import com.skillrisers.gaming.utils.GameConstraints;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Board extends JPanel implements GameConstraints {
    BufferedImage bgImg;
    private Ryu ryu;
    private Ken ken;

    private Timer timer;

    private void gameLoop() {
        timer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        timer.start();
    }

    public Board() throws Exception {
        loadBackground();
        ryu = new Ryu();
        ken = new Ken();

        // focus on board ->when we click is register
        setFocusable(true);
        bindEvents();

        gameLoop();

    }

    public void bindEvents() {
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //
            }

            @Override
            public void keyReleased(KeyEvent e) {

                // Player 1
                if (e.getKeyCode() == D_KEY) {
                    ryu.speed = SPEED;
                    ryu.move();
                    repaint();  // Calls paintComponent internally
                }

                if (e.getKeyCode() == A_KEY) {
                    ryu.speed = -SPEED;
                    ryu.move();
                    repaint();
                }


                // Player 2

                if (e.getKeyCode() == RIGHT_KEY) {
                    ken.speed = SPEED;
                    ken.move();
                    repaint();
                }

                if (e.getKeyCode() == LEFT_KEY) {
                    ken.speed = -SPEED;
                    ken.move();
                    repaint();
                }

                if(e.getKeyCode()==KeyEvent.VK_F){
                    ryu.setCurrAction(GameConstraints.PUNCH);
                    repaint();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    ryu.setCurrAction(GameConstraints.KICK);
                    repaint();
                }
                if(e.getKeyCode()==KeyEvent.VK_W){
                    ryu.setCurrAction(GameConstraints.JUMP);
                    repaint();
                }
                if(e.getKeyCode()==KeyEvent.VK_X){
                    ryu.setCurrAction(GameConstraints.HADOKEN);
                    repaint();
                }

            }
        };

        this.addKeyListener(listener);
    }


    @Override
    public void paintComponent(Graphics pen) {  // Present in Parent Class.
        // It runs automatically after constructor we do not need to call i
        // It is used for rendering and painting
        paintBackground(pen);
        ryu.drawPlayer(pen);
        ken.drawPlayer(pen);

    }

    private void paintBackground(Graphics pen) {
        pen.drawImage(bgImg, 0, 0, GWIDTH, GHEIGHT, null);
        // Here observer:null is used because we are not observing change in Image

    }


    private void loadBackground() {
        try {
            bgImg = ImageIO.read(Board.class.getResource(GAME_BG));
        } catch (Exception e) {
            System.out.println("Unable to Load ...\n");
            System.exit(0);
        }
    }

}
