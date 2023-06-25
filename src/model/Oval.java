package model;

/**
 * This class represents an oval object.
 *
 */
public class Oval extends GenericShape {
  
  /**
   * Constructs a Oval object.
   * @param name name of the oval
   * @param dimension dimension of the oval
   * @param position position of the oval
   * @param color color of the oval
   * @param type type of the oval
   * @param appearTime time of the oval appears
   * @param disappearTime time of the oval disappears
   */
  public Oval(String name, Dimension2D dimension, Position2D position, 
      ColorRGB color, ShapeType type, int appearTime, int disappearTime) {
    super(name, dimension, position, color, type, appearTime, disappearTime);
  }
}