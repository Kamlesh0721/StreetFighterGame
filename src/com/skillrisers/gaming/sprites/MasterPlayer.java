package com.skillrisers.gaming.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MasterPlayer {
    protected int x;  // Protected because we want them to be used by their child but not by every one
    protected int y;
    protected int w;
    protected int h;
    public int speed;
    protected BufferedImage playerMovementImg;

    protected abstract BufferedImage playerImg(); // abstract so it is necessary to make

    public void move() {
        x = x + speed;
    }

    public void drawPlayer(Graphics pen) {
        pen.drawImage(playerImg(), x, y, w, h, null);

    }
}
