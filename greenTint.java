import java.awt.Color;

/**
 * An image filter to set to the green tint color from an image.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 1.0
 */
public class greenTint extends Filter
{
    /**
     * Constructor for objects of class greenTint.
     * @param name The name of the filter.
     */
    public greenTint(String name)
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
                if(green + 50 >= 255)
                {
                    green = 255;
                }
                else image.setPixel(x, y, new Color(red, green + 50, blue));
            }
        }
    }
}
