package com.skillrisers.gaming.sprites;

import com.skillrisers.gaming.utils.GameConstraints;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Ryu extends MasterPlayer implements GameConstraints {
    // Array to store Player Moves
    private BufferedImage[] defaultImage = new BufferedImage[7];
    private BufferedImage[] punchImage = new BufferedImage[6];
    private BufferedImage[] kickImage = new BufferedImage[6];
    private BufferedImage[] jumpImage = new BufferedImage[7];
    private BufferedImage[] hadokenImage = new BufferedImage[5];

    public Ryu() throws Exception {
        x = 200;
        h = PLAYER_HEIGHT;
        w = PLAYER_WIDTH;
        y = FLOOR - h;
        playerImgSheet = ImageIO.read(Ryu.class.getResource(Ryu_IMG));

        defaultImageLoader();
        punchImageLoader();
        kickImageLoader();
        jumpImageLoader();
        hadokenImageLoader();
    }

    // Setters
    public void setCurrAction(int currAction) {
        this.currAction = currAction;
        y = FLOOR - h;
        moveIndex = 0;
    }

    // Player image loaders
    private void defaultImageLoader() {
        defaultImage[0] = playerImgSheet.getSubimage(37, 121, 63, 101);
        defaultImage[1] = playerImgSheet.getSubimage(106, 124, 75, 99);
        defaultImage[2] = playerImgSheet.getSubimage(184, 124, 75, 99);
        defaultImage[3] = playerImgSheet.getSubimage(265, 124, 75, 99);
        defaultImage[4] = playerImgSheet.getSubimage(345, 124, 75, 99);
        defaultImage[5] = playerImgSheet.getSubimage(421, 124, 75, 98);
        defaultImage[6] = playerImgSheet.getSubimage(503, 120, 70, 102);
    }

    private void punchImageLoader() {
        punchImage[0] = playerImgSheet.getSubimage(25, 820, 69, 97);
        punchImage[1] = playerImgSheet.getSubimage(105, 820, 76, 100);
        punchImage[2] = playerImgSheet.getSubimage(189, 821, 112, 96);
        punchImage[3] = playerImgSheet.getSubimage(308, 820, 83, 97);
        punchImage[4] = playerImgSheet.getSubimage(400, 820, 109, 98);
        punchImage[5] = playerImgSheet.getSubimage(515, 819, 81, 98);
    }

    private void kickImageLoader() {
        kickImage[0] = playerImgSheet.getSubimage(37, 1044, 66, 100);
        kickImage[1] = playerImgSheet.getSubimage(120, 1044, 69, 100);
        kickImage[2] = playerImgSheet.getSubimage(200, 1046, 119, 98);
        kickImage[3] = playerImgSheet.getSubimage(328, 1044, 68, 98);
        kickImage[4] = playerImgSheet.getSubimage(404, 1044, 68, 98);
        kickImage[5] = playerImgSheet.getSubimage(483, 1043, 96, 100);
    }

    private void jumpImageLoader() {
        jumpImage[0] = playerImgSheet.getSubimage(34, 457, 67, 93);
        jumpImage[1] = playerImgSheet.getSubimage(114, 459, 65, 111);
        jumpImage[2] = playerImgSheet.getSubimage(193, 458, 65, 114);
        jumpImage[3] = playerImgSheet.getSubimage(271, 458, 65, 118);
        jumpImage[4] = playerImgSheet.getSubimage(344, 458, 65, 114);
        jumpImage[5] = playerImgSheet.getSubimage(424, 458, 65, 110);
        jumpImage[6] = playerImgSheet.getSubimage(505, 449, 63, 122);
    }

    private void hadokenImageLoader() {
        hadokenImage[0] = playerImgSheet.getSubimage(2, 1808, 119, 95);
        hadokenImage[1] = playerImgSheet.getSubimage(125, 1810, 119, 93);
        hadokenImage[2] = playerImgSheet.getSubimage(252, 1811, 121, 93);
        hadokenImage[3] = playerImgSheet.getSubimage(384, 1813, 101, 93);
        hadokenImage[4] = playerImgSheet.getSubimage(491, 1813, 143, 92);
    }

    // Player Moves/Action Selector
    @Override
    protected BufferedImage actionManager() {
        if (currAction == PUNCH) {
            return punchAction();
        } else if (currAction == KICK) {
            return kickAction();
        } else if (currAction == JUMP) {
            return jumpAction();
        } else if (currAction == HADOKEN) {
            return hadokenAction();
        }
        return defaultAction();
    }

    private BufferedImage defaultAction() {
        BufferedImage img = defaultImage[moveIndex];
        moveIndex++;
        if (moveIndex == 7) {
            moveIndex = 0;
        }
        return img;

    }

    private BufferedImage punchAction() {
        BufferedImage img = punchImage[moveIndex];
        moveIndex++;
        if (moveIndex == 6) {
            moveIndex = 0;
            currAction = DEFAULT;
        }
        return img;
    }

    private BufferedImage kickAction() {
        BufferedImage img = kickImage[moveIndex];
        moveIndex++;
        if (moveIndex == 6) {
            moveIndex = 0;
            currAction = DEFAULT;
        }
        return img;
    }

    private BufferedImage jumpAction() {
        if (moveIndex == 3) {
            y -= 30;
        } else if (moveIndex == 4) {
            y -= 15;
        } else if (moveIndex == 5) {
            y += 15;
        } else if (moveIndex == 6) {
            y += 30;
        }
        BufferedImage img = jumpImage[moveIndex];
        moveIndex++;

        if (moveIndex == 7) {
            moveIndex = 0;
            currAction = DEFAULT;
        }
        return img;
    }

    private BufferedImage hadokenAction() {
        BufferedImage img = hadokenImage[moveIndex];
        moveIndex++;
        if (moveIndex == 5) {
            moveIndex = 0;
            currAction = DEFAULT;
        }
        return img;
    }
}
