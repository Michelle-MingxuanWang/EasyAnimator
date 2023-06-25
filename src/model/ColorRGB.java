package model;

/**
 * This class represents a color with RGB values.
 */
public class ColorRGB {
  private int r;
  private int g;
  private int b;
  
  /**
   * Constructs a ColorRGB object with given r, g, b value.
   * @param r r of RGB value
   * @param g g of RGB value
   * @param b b of RGB value
   */
  public ColorRGB(int r, int g, int b) {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("RGB value should be in the range of (0, 255)");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }
  
  /**
   * Get r of RGB value.
   * @return r of RGB value
   */
  public int getR() {
    return r;
  }
  
  /**
   * Get g of RGB value.
   * @return g of RGB value
   */
  public int getG() {
    return g;
  }
  
  /**
   * Get b of RGB value.
   * @return b of RGB value
   */
  public int getB() {
    return b;
  }
  
  /**
   * Return the RGB value of the shape.
   * @return string format of the RGB value
   */
  public String toString() {
    return "(" + Integer.toString(r) + "," + Integer.toString(g) + "," + Integer.toString(b) + ")";
  }
  
}