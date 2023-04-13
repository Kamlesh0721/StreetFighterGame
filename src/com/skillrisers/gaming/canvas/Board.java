package com.skillrisers.gaming.canvas;
// Board will contain all designing of game
// We will use class JPanel for designing - JPanel can do painting

import com.skillrisers.gaming.sprites.Power;
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

    private Power ryuFullPower;
    private Power kenFullPower;

    private Timer timer;

    private void gameLoop() {
        timer = new Timer(GAME_FRAME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ryu.fall();
                ken.fall();
                isCollision();
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
        loadPower();

    }

    public void bindEvents() {
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Player 1
                if (e.getKeyCode() == D_KEY) {
                    ryu.setSpeed(SPEED);
                    isCollision();
                    ryu.move();
                    repaint();  // Calls paintComponent internally
                }

                if (e.getKeyCode() == A_KEY) {
                    ryu.setSpeed(-SPEED);
                    ryu.move();
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    ryu.setCurrAction(GameConstraints.JUMP);
                    repaint();
                }

                // Player 2
                if (e.getKeyCode() == RIGHT_KEY) {
                    ken.setSpeed(SPEED);
                    ken.move();
                    repaint();
                }

                if (e.getKeyCode() == LEFT_KEY) {
                    ken.setSpeed(-SPEED);
                    isCollision();
                    ken.move();
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    ken.setCurrAction(GameConstraints.JUMP);
                    repaint();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

                // Player 1
                if (e.getKeyCode() == KeyEvent.VK_F) {
                    ryu.setCurrAction(GameConstraints.PUNCH);
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    ryu.setCurrAction(GameConstraints.KICK);
                    repaint();
                }

                if (e.getKeyCode() == KeyEvent.VK_X) {
                    ryu.setCurrAction(GameConstraints.HADOKEN);
                    repaint();
                }


                // Player 2


                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    ken.setCurrAction(GameConstraints.PUNCH);
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    ken.setCurrAction(GameConstraints.KICK);
                    repaint();
                }

                if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
                    ken.setCurrAction(GameConstraints.HADOKEN);
                    repaint();
                }

            }
        };

        this.addKeyListener(listener);
    }

    // Collision

    private boolean isCollide() {
        int xDist = Math.abs(ryu.getX() - ken.getX());
        int yDist = Math.abs(ryu.getY() - ken.getY());
        int maxW = Math.max(ryu.getW(), ken.getW());
        int maxH = Math.max(ryu.getH(), ken.getH());
        return xDist <= maxW && yDist <= maxH;
    }

    private void isCollision() {
        if (isCollide()) {
            ryu.setSpeed(0);
            ken.setSpeed(0);

            if (ryu.isAttacking && ken.isAttacking) {
                ryu.isAttacking=false;
                ken.isAttacking=false;
                System.out.println("Ryu attacking -> ken taking damage");
                ken.setCurrAction(GameConstraints.DAMAGE);
                System.out.println("Ken attacking -> ryu taking damage");
                ryu.setCurrAction(GameConstraints.DAMAGE);
            } else if (ryu.isAttacking) {
                ryu.isAttacking=false;
                System.out.println("Ryu attacking -> ken taking damage");
                ken.setCurrAction(GameConstraints.DAMAGE);
                ken.setHealth(ken.getHealth() - 10);
                kenFullPower.setHealth(ken.getHealth());
            } else if (ken.isAttacking) {
                ken.isAttacking=false;
                System.out.println("Ken attacking -> ryu taking damage");
                ryu.setCurrAction(GameConstraints.DAMAGE);
                ryu.setHealth(ryu.getHealth()-10);
                ryuFullPower.setHealth(ryu.getHealth());
            }
        }
    }


    @Override
    public void paintComponent(Graphics pen) {  // Present in Parent Class.
        // It runs automatically after constructor we do not need to call i
        // It is used for rendering and painting
        paintBackground(pen);
        ryu.drawPlayer(pen);
        ken.drawPlayer(pen);
        paintFullPower(pen);


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

    private void loadPower() {
        ryuFullPower = new Power(30, "RYU");
        kenFullPower = new Power(GWIDTH - 400, "KEN");
    }

    private void paintFullPower(Graphics pen) {
        ryuFullPower.printRectangle(pen);
        kenFullPower.printRectangle(pen);
    }

}
