import java.awt.Color;

/**
 * An image filter to set to the blue channel color from an image.
 * 
 * @author Brandon Magistrado
 * @version 1.0
 */
public class blueChannel extends Filter
{
    /**
     * Constructor for objects of class blueChannel.
     * @param name The name of the filter.
     */
    public blueChannel(String name)
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int blue = (pix.getBlue());
                //int avg = (pix.getRed() + pix.getGreen() + pix.getBlue()) / 3;
                image.setPixel(x, y, new Color(0, 0,blue));
            }
        }
    }
}
