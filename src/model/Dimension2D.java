package model;

/**
 * This class represents a 2D dimension of the shape.
 */
public class Dimension2D {
  private double w;
  private double h;
  
  /**
   * Constructs a Dimension2D object with given width and height.
   * For shapes with only width/height, the other dimension is 0.
   * (e.g., height of circle is 0)
   * @param w w dimension of the shape
   * @param h h dimension of the shape
   */
  public Dimension2D(double w, double h) throws IllegalArgumentException {
    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("Dimension should be positive");
    }
    this.w = w;
    this.h = h;
  }
  
  /**
   * Get w dimension of the shape.
   * @return w dimension of the shape
   */
  public double getW() {
    return w;
  }
  
  /**
   * Get h dimension of the shape.
   * @return h dimension of the shape
   */
  public double getH() {
    return h;
  }
  
  /**
   * Return the string format of the dimension.
   */
  @Override
  public String toString() {
    return "(" + Double.toString(w) + "," + Double.toString(h) + ")";
  }
  
}