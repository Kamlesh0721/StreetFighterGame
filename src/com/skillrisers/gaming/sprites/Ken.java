package com.skillrisers.gaming.sprites;

import com.skillrisers.gaming.utils.GameConstraints;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Ken extends MasterPlayer implements GameConstraints {
    private BufferedImage[] defaultImage = new BufferedImage[4];
    private BufferedImage[] punchImage = new BufferedImage[5];
    private BufferedImage[] kickImage = new BufferedImage[5];
    private BufferedImage[] jumpImage = new BufferedImage[7];
    private BufferedImage[] hadokenImage = new BufferedImage[5];

    public Ken() throws Exception {
        x = GWIDTH - 300;
        h = PLAYER_HEIGHT;
        w = PLAYER_WIDTH;
        y = FLOOR - h;
        playerImgSheet = ImageIO.read(Ryu.class.getResource(Ken_IMG));

        defaultImageLoader();
        kickImageLoader();
        punchImageLoader();
        jumpImageLoader();
        hadokenImageLoader();
    }

    // Setters
    public void setCurrAction(int currAction) {
        this.currAction = currAction;
        moveIndex = 0;
    }

    // Player image loaders
    private void defaultImageLoader() {
        defaultImage[0] = playerImgSheet.getSubimage(672, 242, 131, 246);
        defaultImage[1] = playerImgSheet.getSubimage(892, 242, 123, 246);
        defaultImage[2] = playerImgSheet.getSubimage(1106, 242, 123, 246);
        defaultImage[3] = playerImgSheet.getSubimage(1324, 242, 123, 246);

    }

    private void punchImageLoader() {
        punchImage[0] = playerImgSheet.getSubimage(469, 749, 118, 228);
        punchImage[1] = playerImgSheet.getSubimage(892, 487, 132, 244);
        punchImage[2] = playerImgSheet.getSubimage(1057, 487, 179, 244);
        punchImage[3] = playerImgSheet.getSubimage(1329, 487, 125, 244);
        punchImage[4] = playerImgSheet.getSubimage(469, 749, 118, 228);
    }

    private void kickImageLoader() {
        kickImage[0] = playerImgSheet.getSubimage(460, 1456, 125, 249);
        kickImage[1] = playerImgSheet.getSubimage(686, 1456, 125, 249);
        kickImage[2] = playerImgSheet.getSubimage(852, 1450, 215, 244);
        kickImage[3] = playerImgSheet.getSubimage(1119, 1456, 125, 244);
        kickImage[4] = playerImgSheet.getSubimage(1318, 749, 118, 244);
    }


    private void jumpImageLoader() {
        jumpImage[0] = playerImgSheet.getSubimage(52, 1957, 103, 227);
        jumpImage[1] = playerImgSheet.getSubimage(273, 1940, 109, 253);
        jumpImage[2] = playerImgSheet.getSubimage(484, 1940, 104, 248);
        jumpImage[3] = playerImgSheet.getSubimage(692, 1943, 106, 214);
        jumpImage[4] = playerImgSheet.getSubimage(904, 1947, 106, 235);
        jumpImage[5] = playerImgSheet.getSubimage(1130, 1944, 106, 249);
        jumpImage[6] = playerImgSheet.getSubimage(1343, 1955, 90, 235);

    }

    private void hadokenImageLoader() {
        hadokenImage[0] = playerImgSheet.getSubimage(484, 749, 104, 226);
        hadokenImage[1] = playerImgSheet.getSubimage(1299, 5, 165, 229);
        hadokenImage[2] = playerImgSheet.getSubimage(1084, 10, 169, 226);
        hadokenImage[3] = playerImgSheet.getSubimage(852, 22, 197, 217);
        hadokenImage[4] = playerImgSheet.getSubimage(635, 20, 197, 217);
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
        if (moveIndex == 4) {
            moveIndex = 0;
        }

        return img;

    }

    private BufferedImage punchAction() {
        BufferedImage img = punchImage[moveIndex];
        moveIndex++;
        if (moveIndex == 5) {
            moveIndex = 0;
            currAction = DEFAULT;
        }
        return img;
    }

    private BufferedImage kickAction() {
        BufferedImage img = kickImage[moveIndex];
        moveIndex++;
        if (moveIndex == 5) {
            moveIndex = 0;
            currAction = DEFAULT;
        }
        return img;
    }


    private BufferedImage jumpAction() {
        if (!isJump) {
            isJump = true;
            force = FORCE;
            y = y + force;
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
