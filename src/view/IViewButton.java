package view;

/**
 * This represents an interface of the interactive functions in edit view.
 */
public interface IViewButton {

  /**
   * Start the animation.
   */
  void start();
  
  /**
   * Pauses the animation.
   */
  void paused();

  /**
   * Resumes the animation.
   */
  void resume();

  /**
   * Restarts the animation.
   */
  void restart();
}