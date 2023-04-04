package com.skillrisers.gaming.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface GameConstraints {
    String TITLE = "Street Fighter";
    String GAME_BG = "bg.jpg";
    int GWIDTH = 1280;
    int GHEIGHT = 720;
    int FLOOR = GHEIGHT - 125;


    String PLAYER1_IMG = "Ryu.gif";
    String PLAYER2_IMG = "Ken.png";
    int SPEED = 10;

    int RIGHT_KEY = KeyEvent.VK_RIGHT; // 39
    int LEFT_KEY = KeyEvent.VK_LEFT;  // 37

    int A_KEY = KeyEvent.VK_A;
    int D_KEY = KeyEvent.VK_D;
}
