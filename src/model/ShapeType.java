package model;

/**
 * This enum represents the type of the shape.
 */
public enum ShapeType {
  OVAL,
  RECTANGLE;
  
  /**
   * Return the string format of the enum.
   * @return string format of enum
   */
  @Override
  public String toString() {
    if (this == OVAL) {
      return "oval";
    } else if (this == RECTANGLE) {
      return "rectangle";
    }
    return null;
  }
}