package model;

/**
 * This represents a Shape.
 *
 */
public interface IShape {

  /**
   * Get the name of shape.
   */
  String getName();
  
  /**
   * Get the dimension.
   */
  Dimension2D getDimension();

  /**
   * Get the position.
   */
  Position2D getPosition();

  /**
   * Get color of shape.
   */
  ColorRGB getColor();
  
  /**
   * Get the type of the shape.
   */
  ShapeType getType();
  
  /**
   * Get the appear time of the shape.
   */
  int getAppearTime();

  /**
   * Get the disappear time of shape.
   */
  int getDisappearTime();

  /**
   * Return the string format for shapes. 
   * This method is for test uses.
   */
  public String toString();

  /**
   * Get the order of the shape.
   */
  int getOrder();

  /**
   * Set the order of the shape.
   */
  void setOrder(int order);


}