import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class BufferedImageLoader {
    private BufferedImage image;

    public BufferedImageLoader() {
    }

    public BufferedImage loadImage(String path) throws IOException {
        this.image = ImageIO.read(getClass().getResource(path));
        return this.image;
    }
}