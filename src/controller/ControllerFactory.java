package controller;

import model.IModel;

import view.IView;

/**
 * This represents a factory for generating controllers. 
 *
 */
public class ControllerFactory {

  /**
   * Make controllers with given controller type.
   * @param type controller type
   * @param model application model
   * @param view application view
   * @return builded controller
   * @throws IllegalArgumentException when the controller type is invalid.
   */
  public static IController makeController(String type, IModel model, IView view)
      throws IllegalArgumentException {
    if (type == null) {
      throw new IllegalArgumentException("Not a valid controller");
    }
    switch (type) {
      case "text":
        return new TextViewController(model, view);
      case "visual":
        return new VisualViewController(model, view);
      case "edit":
        return new EditViewController(model, view);
      case "svg":
        return new SVGViewController(model, view);
      default:
        throw new IllegalArgumentException("Not a valid controller");
    }
  }
}
