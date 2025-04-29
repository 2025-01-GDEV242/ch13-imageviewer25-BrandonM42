import java.awt.Color;

/**
 * An image filter to set to the green channel color from an image.
 * 
 * @author Brandon Magistrado
 * @version 1.0
 */
public class greenChannel extends Filter
{
    /**
     * Constructor for objects of class greenChannel.
     * @param name The name of the filter.
     */
    public greenChannel(String name)
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
                int green = (pix.getGreen());
                //int avg = (pix.getRed() + pix.getGreen() + pix.getBlue()) / 3;
                image.setPixel(x, y, new Color(0, green,0));
            }
        }
    }
}
