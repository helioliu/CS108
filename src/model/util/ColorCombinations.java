package model.util;

import model.RGBColor;


/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of
 * ways to combine colors, many may exist and we do not want to keep
 * modifying the RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorCombinations
{
    /**
     * Combine two colors by adding their components.
     */
    public static RGBColor add (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() + right.getRed(), 
                            left.getGreen() + right.getGreen(),
                            left.getBlue() + right.getBlue());
    }

    /**
     * Combine two colors by subtracting their components.
     */
    public static RGBColor subtract (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() - right.getRed(), 
                            left.getGreen() - right.getGreen(),
                            left.getBlue() - right.getBlue());
    }

    /**
     * Combine two colors by multiplying their components.
     */
    public static RGBColor multiply (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() * right.getRed(), 
                            left.getGreen() * right.getGreen(),
                            left.getBlue() * right.getBlue());
    }

    /**
     * Combine two colors by dividing their components.
     */
    public static RGBColor divide (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() / right.getRed(), 
                            left.getGreen() / right.getGreen(),
                            left.getBlue() / right.getBlue());
    }
    
    /**
     * Combine two colors by taking the modulus?
     */
    public static RGBColor modulus (RGBColor left, RGBColor right)
    {
    	return new RGBColor(left.getRed() % right.getRed(),
    						left.getGreen() % right.getGreen(),
    						left.getBlue() % right.getBlue());
    }
    
    /**
     * Combine two colors by raising one to the other
     */
    public static RGBColor exponentiate (RGBColor left, RGBColor right)
    {
    	return new RGBColor(Math.pow(left.getRed(), right.getRed()),
    						Math.pow(left.getGreen(), right.getGreen()),
    						Math.pow(left.getBlue(), right.getBlue()));
    }
    
    /**
     * Negate/invert a color
     */
    public static RGBColor negate (RGBColor left)
    {
    	return new RGBColor(left.getRed()*-1,
    						left.getGreen()*-1,
    						left.getBlue()*-1);
    }
    
    /**
     * Set a color
     */
    public static RGBColor colorize (RGBColor left, RGBColor center, RGBColor right)
    {
    	return new RGBColor(left.getRed(),
    						center.getRed(),
    						right.getRed());
    }
}
