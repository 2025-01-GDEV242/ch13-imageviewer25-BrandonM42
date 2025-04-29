import java.awt.Color;
import javax.swing.*;
/**
 * An image filter to set to the red channel color from an image.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 1.0
 */
public class testWarhol extends Filter
{
    private ImagePanel imagePanel;
    
    
    /**
     * Constructor for objects of class testWarhol.
     * @param name The name of the filter.
     */
    public testWarhol(String name)
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
                    image.setPixel(x, y, tinyPic.getPixel(x, y));
                }
            }
            
            //top right pic place
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x + width, y, tinyPic.getPixel(x, y));
                }
            }
            
            //bottom left pic place
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x, y + height, tinyPic.getPixel(x, y));
                }
            }
            
            //bottom right pic place
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    image.setPixel(x + width, y + height, tinyPic.getPixel(x, y));
                }
            }
            
            
    }
    
    /*private void makeSmaller(OFImage image)
    {
        if(image != null) {
            // create new image with double size
            int width = image.getWidth() / 2;
            int height = image.getHeight() / 2;
            OFImage newImage = new OFImage(width, height);

            // copy pixel data into new image
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    newImage.setPixel(x, y, image.getPixel(x * 2, y * 2));
                }
            }
            
            image = newImage;
            imagePanel.setImage(image);
        }
    }
    */
   
}
