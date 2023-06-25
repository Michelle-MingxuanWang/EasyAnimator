package model;

/**
 * A class to build a shape according to its type.
 *
 */
public class ShapeBuilder {
  
  /**
   * Build shapes with given shape type.
   * @param name name of shape
   * @param dimension dimension of shape
   * @param position position of shape
   * @param color color of shape
   * @param type type of shape
   * @param appearTime appear time of shape
   * @param disappearTime disappear time of shape
   * @return builded shape
   */
  public static IShape buildShape(String name, Dimension2D dimension,
      Position2D position, ColorRGB color, ShapeType type, 
      int appearTime, int disappearTime) {
    IShape newShape = null;
    if (type == null) {
      throw new IllegalArgumentException("Type cannot be null");
    } 
    if (type == ShapeType.OVAL) {
      try {
        newShape = new Oval(name, dimension, position, color, type, appearTime, disappearTime);
      } catch (Exception e) {
        throw new IllegalArgumentException(e);
      }
    } else if (type == ShapeType.RECTANGLE) {
      try {
        newShape = new Rectangle(name, dimension, position, color, 
            type, appearTime, disappearTime);
      } catch (Exception e) {
        throw new IllegalArgumentException(e);
      }
    }
    return newShape;
  }
}