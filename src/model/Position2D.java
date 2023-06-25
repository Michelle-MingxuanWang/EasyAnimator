package model;

/**
 * This class represents a 2D position on the canvas.
 */
public class Position2D {
  private double x;
  private double y;
  
  /**
   * Constructs a Position2D object with given x and y coordinates.
   * @param x x coordinate of canvas
   * @param y y coordinate of canvas
   */
  public Position2D(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  /**
   * Get x coordinate of position.
   * @return x coordinate of position
   */
  public double getX() {
    return x;
  }
  
  /**
   * Get y coordinate of position.
   * @return y coordinate of position
   */
  public double getY() {
    return y;
  }
  
  /**
   * Return the string format of the position.
   */
  @Override
  public String toString() {
    return "(" + Double.toString(x) + "," + Double.toString(y) + ")";
  }
  
}