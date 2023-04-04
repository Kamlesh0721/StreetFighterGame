package com.skillrisers.gaming.sprites;

import com.skillrisers.gaming.utils.GameConstraints;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Player2 extends MasterPlayer implements GameConstraints {
    public Player2() throws Exception {
        x = GWIDTH-300;
        w = h = 120;
        y = FLOOR - h;
        playerMovementImg = ImageIO.read(Player1.class.getResource(PLAYER2_IMG));
    }

    @Override
    protected BufferedImage playerImg() {
        return playerMovementImg.getSubimage(11,5,85,108);

    }
}
