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

    private BufferedImage[] damageEffectImages = new BufferedImage[5];
    private BufferedImage playerImageSheet2Temp;

    public Ken() throws Exception {
        x = GWIDTH - 300;
        h = PLAYER_HEIGHT;
        w = PLAYER_WIDTH;
        y = FLOOR - h;
        playerImgSheet = ImageIO.read(Ken.class.getResource(Ken_IMG));
        playerImageSheet2Temp = ImageIO.read(Ken.class.getResource("kenimage.png"));


        defaultImageLoader();
        kickImageLoader();
        punchImageLoader();
        jumpImageLoader();
        hadokenImageLoader();
        damageEffectLoader();
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

    private void damageEffectLoader() {
        damageEffectImages[0] = playerImageSheet2Temp.getSubimage(1365, 3276, 65, 95);
        damageEffectImages[1] = playerImageSheet2Temp.getSubimage(1437, 3271, 88, 99);
        damageEffectImages[2] = playerImageSheet2Temp.getSubimage(1537, 3278, 75, 91);
        damageEffectImages[3] = playerImageSheet2Temp.getSubimage(1627, 3277, 70, 92);
        damageEffectImages[4] = playerImageSheet2Temp.getSubimage(1712, 3274, 63, 98);
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
        } else if (currAction == DAMAGE) {
            return damageEffectAction();
        }
        return defaultAction();
    }

    private BufferedImage defaultAction() {
        BufferedImage img = defaultImage[moveIndex];
        moveIndex++;
        if (moveIndex == defaultImage.length) {
            moveIndex = 0;
        }

        return img;

    }

    private BufferedImage punchAction() {

        isAttacking = true;
        BufferedImage img = punchImage[moveIndex];
        moveIndex++;
        if (moveIndex == punchImage.length) {
            moveIndex = 0;
            currAction = DEFAULT;
            isAttacking = false;
        }
        return img;
    }

    private BufferedImage kickAction() {
        isAttacking = true;
        BufferedImage img = kickImage[moveIndex];
        moveIndex++;
        if (moveIndex == kickImage.length) {
            moveIndex = 0;
            currAction = DEFAULT;
            isAttacking = false;
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

        if (moveIndex == jumpImage.length) {
            moveIndex = 0;
            currAction = DEFAULT;
        }
        return img;
    }

    private BufferedImage hadokenAction() {
        BufferedImage img = hadokenImage[moveIndex];
        moveIndex++;
        if (moveIndex == hadokenImage.length) {
            moveIndex = 0;
            currAction = DEFAULT;
        }
        return img;
    }

    private BufferedImage damageEffectAction() {
        BufferedImage img = damageEffectImages[moveIndex];
        moveIndex++;
        if (moveIndex >= damageEffectImages.length) {
            moveIndex = 0;
            currAction = DEFAULT;
            isAttacking = false;
        }
        return img;

    }
}
