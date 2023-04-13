package com.skillrisers.gaming.sprites;

import com.skillrisers.gaming.utils.GameConstraints;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MasterPlayer implements GameConstraints {
    protected int x;  // Protected because we want them to be used by their child but not by every one
    protected int y;
    protected int w;
    protected int h;
    protected int health = MAX_HEALTH;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    protected int force;
    private int speed;
    public boolean isAttacking = false;
    boolean isJump = false;
    protected int currAction = DEFAULT;
    protected int moveIndex = 0;
    protected BufferedImage playerImgSheet;

    protected abstract BufferedImage actionManager();

    public void move() {
        x += speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void drawPlayer(Graphics pen) {
        pen.drawImage(actionManager(), x, y, w, h, null);

    }

    public void fall() {
        if (y > FLOOR - h) {
            isJump = false;
            return;
        }
        if (force == -FORCE) {
            force += -FORCE;
        }
        y += force;
        force += GRAVITY;
    }

}
