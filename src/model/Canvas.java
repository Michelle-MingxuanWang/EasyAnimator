package model;

/**
 * Constructs a canvas for the animation with given position of
 * the top left corner and the dimension of width and height of canvas.
 *
 */
public class Canvas {
  private Position2D position;
  private Dimension2D dimension;
  
  /**
   * Constructs a canvas object with the given position and dimension.
   * @param position position of the top left corner of canvas
   * @param dimension width and height of canvas
   */
  public Canvas(Position2D position, Dimension2D dimension) {
    this.position = position;
    this.dimension = dimension;
  }
  
  /**
   * Get position.
   * @return position of the top left corner
   */
  public Position2D getPosition() {
    return this.position;
  }
  
  /**
   * Get dimension.
   * @return dimension of the canvas
   */
  public Dimension2D getDimension() {
    return this.dimension;
  }
}