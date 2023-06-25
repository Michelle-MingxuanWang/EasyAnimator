package model;

/**
 * This class represents an rectangle object.
 *
 */
public class Rectangle extends GenericShape {
  
  /**
   * Constructs a rectangle object.
   * @param name name of the rectangle
   * @param dimension dimension of the rectangle
   * @param position position of the rectangle
   * @param color color of the rectangle
   * @param type type of the rectangle
   * @param appearTime time of the rectangle appears
   * @param disappearTime time of the rectangle disappears
   */
  public Rectangle(String name, Dimension2D dimension, Position2D position, 
      ColorRGB color, ShapeType type, int appearTime, int disappearTime) {
    super(name, dimension, position, color, type, appearTime, disappearTime);
  }
}