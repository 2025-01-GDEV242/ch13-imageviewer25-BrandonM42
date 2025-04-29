import java.awt.Color;
import javax.swing.*;
/**
 * An image filter to set to the red channel color from an image.
 * 
 * @author Brandon Magistrado
 * @version 1.0
 */
public class WarholMirror extends Filter
{
    private ImagePanel imagePanel;
    
    
    /**
     * Constructor for objects of class testWarhol.
     * @param name The name of the filter.
     */
    public WarholMirror(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
            // create new image with double size
            int width = image.getWidth() / 2;
            int height = image.getHeight() / 2;
            OFImage tinyPic = new OFImage(width, height);
            int red = 0;
            //OFImage topRight = new OFImage(width * 2, height);
            
            //tiny pic
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    tinyPic.setPixel(x, y, image.getPixel(x * 2, y * 2));
                }
            }

            
            
            
            //top left pic place
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x + width, y, tinyPic.getPixel(x, y));
                }
            }
            
            
            //top right pic place
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x, y, tinyPic.getPixel(x, y));
                    Color pix = tinyPic.getPixel(x, y);
                    int redC = pix.getRed();
                    int greenC = pix.getGreen();
                    int blueC = pix.getBlue();
                    if(redC + 50 >= 255)
                    {
                    redC = 255;
                    }
                    else image.setPixel(x, y, new Color
                    (redC + 50,greenC,blueC));
                }
            }
            
            
            
            //bottom left pic place
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x + width, y + height, tinyPic.getPixel(x, y));
                    Color pix = tinyPic.getPixel(x, y);
                    int redC = pix.getRed();
                    int greenC = pix.getGreen();
                    int blueC = pix.getBlue();
                    if(greenC + 50 >= 255)
                    {
                    greenC = 255;
                    }
                    else image.setPixel(x + width, y + height, new Color
                    (redC,greenC + 50,blueC));
                }
            }
            
            //bottom right pic place
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x, y + height, tinyPic.getPixel(x, y));
                    Color pix = tinyPic.getPixel(x, y);
                    int redC = pix.getRed();
                    int greenC = pix.getGreen();
                    int blueC = pix.getBlue();
                    if(blueC + 50 >= 255)
                    {
                    blueC = 255;
                    }
                    else image.setPixel(x, y + height, new Color
                    (redC,greenC,blueC + 50));
                }
            }
            
    }
   
}
