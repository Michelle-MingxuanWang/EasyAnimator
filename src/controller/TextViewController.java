package controller;

import model.IModel;
import view.IView;
import java.io.IOException;

/**
 * This class represents a controller for text view.
 *
 */
public class TextViewController implements IController {
  private IModel model;
  private IView view;

  /**
   * Constructs a text view controller.
   * @param model application model
   * @param view application view
   */
  public TextViewController(IModel model, IView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * Render view and run application.
   * @param ap the input
   * @throws IllegalStateException when input is null
   * @throws IOException when cannot append rendered text
   */
  @Override
  public void run(Appendable ap) throws IOException {
    if (ap == null) {
      throw new IllegalStateException("Parameters can not be null");
    }
    String text = view.renderText(model.getShapeMap(), model.getTransformationMap());
    try {
      // write to file/stdin
      ap.append(text);
    } catch (IOException e) {
      throw new IOException("Cannot append");
    }
  }


}