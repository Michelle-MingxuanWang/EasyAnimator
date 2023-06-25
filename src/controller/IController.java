package controller;

import java.io.IOException;

/**
 * This represents an interface for controllers.
 *
 */
public interface IController {

  /**
   * Run the application.
   * @param appendable the input
   * @throws IOException when cannot append rendered text
   */
  void run(Appendable appendable) throws IOException;
}