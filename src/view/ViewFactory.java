package view;

/**
 * This represents a factory for generating views. 
 *
 */
public class ViewFactory {
  
  /**
   * Make views with given view type.
   * @param type view type
   * @param speed animation speed
   * @return builded view
   * @throws IllegalArgumentException when the view type is invalid.
   */
  public static IView makeView(String type, int speed) throws IllegalArgumentException {
    if (type == null) {
      throw new IllegalArgumentException("Not a valid view");
    }
    switch (type) {
      case "text":
        return new TextView(speed);
      case "visual":
        return new VisualView(speed);
      case "edit":
        return new EditView(speed);
      case "svg":
        return new SVGView(speed);
      default:
        throw new IllegalArgumentException("Not a valid view");
    }
  }
}
