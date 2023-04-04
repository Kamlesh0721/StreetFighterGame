package com.skillrisers.gaming.canvas;
// Board will contain all designing of game
// We will use class JPanel for designing - JPanel can do painting

import com.skillrisers.gaming.sprites.Player1;
import com.skillrisers.gaming.sprites.Player2;
import com.skillrisers.gaming.utils.GameConstraints;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Board extends JPanel implements GameConstraints {
    BufferedImage bgImg;
    private Player1 player1;
    private Player2 player2;

    public Board() throws Exception {
        loadBackground();
        player1 = new Player1();
        player2 = new Player2();

        // focus on board ->when we click is register
        setFocusable(true);
        bindEvents();

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
                    player1.speed = SPEED;
                    player1.move();
                    repaint();  // Calls paintComponent internally
                }

                if (e.getKeyCode() == A_KEY) {
                    player1.speed = -SPEED;
                    player1.move();
                    repaint();
                }


                // Player 2

                if (e.getKeyCode() == RIGHT_KEY) {
                    player2.speed = SPEED;
                    player2.move();
                    repaint();
                }

                if (e.getKeyCode() == LEFT_KEY) {
                    player2.speed = -SPEED;
                    player2.move();
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
        player1.drawPlayer(pen);
        player2.drawPlayer(pen);
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
