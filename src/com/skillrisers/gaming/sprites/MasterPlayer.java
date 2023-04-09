package com.skillrisers.gaming.sprites;

import com.skillrisers.gaming.utils.GameConstraints;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MasterPlayer implements GameConstraints {
    protected int x;  // Protected because we want them to be used by their child but not by every one
    protected int y;
    protected int w;
    protected int h;
    protected int force;
    public int speed;
    boolean isJump = false;
    protected int currAction = DEFAULT;
    protected int moveIndex = 0;
    protected BufferedImage playerImgSheet;

    protected abstract BufferedImage actionManager();

    public void move() {
        x = x + speed;
    }

    public void drawPlayer(Graphics pen) {
        pen.drawImage(actionManager(), x, y, w, h, null);

    }

    public void fall() {
        if (y > FLOOR - h) {
            isJump = false;
            return;
        }
        y += force;
        force += GRAVITY;
    }

}
