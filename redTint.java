import java.awt.Color;

/**
 * An image filter to set to the red tint color from an image.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 1.0
 */
public class redTint extends Filter
{
    /**
     * Constructor for objects of class redTint.
     * @param name The name of the filter.
     */
    public redTint(String name)
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
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();
                if(red + 50 >= 255)
                {
                    red = 255;
                }
                else image.setPixel(x, y, new Color(red + 50, green, blue));
            }
        }
    }
}
