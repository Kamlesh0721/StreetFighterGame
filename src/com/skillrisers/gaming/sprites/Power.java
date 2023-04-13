package com.skillrisers.gaming.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Power extends MasterPlayer {
    String playerName;

    public Power(int x, String playerName) {
        this.x = x;
        y = 50;
        h = 40;
        w = health;
        this.playerName = playerName;

    }

    @Override
    protected BufferedImage actionManager() {
        return null;
    }

    public void printRectangle(Graphics pen) {
        pen.setColor(Color.RED);
        pen.fillRect(x, y, MAX_HEALTH, h);
        pen.setColor(Color.GREEN);
        pen.fillRect(x, y, health, h);
        pen.setColor(Color.WHITE);
        pen.setFont(new Font("consolas", Font.BOLD, 20));
        pen.drawString(playerName, x, y + 65);

    }
}
