package com.skillrisers.gaming.sprites;

import com.skillrisers.gaming.utils.GameConstraints;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Ken extends MasterPlayer implements GameConstraints {
    public Ken() throws Exception {
        x = GWIDTH - 300;
        w = h = 120;
        y = FLOOR - h;
        playerImgSheet = ImageIO.read(Ryu.class.getResource(Ken_IMG));
    }


    @Override
    protected BufferedImage actionManager() {
        return playerImgSheet.getSubimage(11, 5, 85, 108);
    }
}
