package com.skillrisers.gaming.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface GameConstraints {
    String TITLE = "Street Fighter";
    String GAME_BG = "bg.jpg";
    int GWIDTH = 1280;
    int GHEIGHT = 720;
    int GAME_FRAME = 120;
    int PLAYER_HEIGHT = 120;
    int PLAYER_WIDTH = 100;
    int FLOOR = GHEIGHT - 125;
    int GRAVITY = 4;
    int FORCE = -20;

    String Ryu_IMG = "Ryu.gif";
    String Ken_IMG = "Ken.png";
    int SPEED = 15;


    // Player Movement Keys
    int RIGHT_KEY = KeyEvent.VK_RIGHT; // 39
    int LEFT_KEY = KeyEvent.VK_LEFT;  // 37

    int A_KEY = KeyEvent.VK_A;
    int D_KEY = KeyEvent.VK_D;

    // Player Moves
    int DEFAULT = 0;
    int PUNCH = 1;
    int KICK = 2;
    int JUMP = 3;
    int HADOKEN = 4;
    int DAMAGE = 5;
    int MAX_HEALTH = 300;
}
