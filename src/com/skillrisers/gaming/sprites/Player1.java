package com.skillrisers.gaming.sprites;

import com.skillrisers.gaming.utils.GameConstraints;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player1 extends MasterPlayer implements GameConstraints {
    public Player1() throws Exception {
        x = 200;
        w = h = 120;
        y = FLOOR - h;
        playerMovementImg = ImageIO.read(Player1.class.getResource(PLAYER1_IMG));
    }



    @Override
    protected BufferedImage playerImg(){
        return playerMovementImg.getSubimage(64, 240, 72, 94);
    }

}
