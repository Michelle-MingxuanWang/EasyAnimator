package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import model.IModel;
import model.IShape;
import view.IView;
import view.IViewButton;

/**
 * This class represents a controller for visual view.
 *
 */
public class EditViewController implements ActionListener, IController, IViewButton {
  private Timer timer;
  private int tick = 0;
  private IModel model;
  private IView view;
  
  /**
   * Constructs a visual view controller.
   * @param model application model
   * @param view application view
   */
  public EditViewController(IModel model, IView view) {
    this.model = model;
    this.view = view;
    timer = new Timer(1000 / view.getSpeed(), this);
    view.setCanvas(model.getCanvas());
    
    try {
      view.addListener(this);
    } catch (UnsupportedOperationException e) {
      // do nothing
    }
    
  }

  /**
   * Render view with shape at time when action performed.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    List<IShape> currListOfShape = model.getShapeAtTime(tick);
    this.view.renderVisual(currListOfShape);
    this.tick++;

  }

  /**
   * Start the timer and run application.
   */
  @Override
  public void run(Appendable appendable) {
    //timer.start();
  }
  
  /**
   * Pauses the animation.
   */
  public void paused() {
    timer.stop();
  }
  
  /**
   * Pauses the animation.
   */
  public void start() {
    timer.start();
  }

  /**
   * Resumes the animation.
   */
  public void resume() {
    if (tick > 0) {
      timer.start();
    }
  }

  /**
   * Restarts the animation.
   */
  public void restart() {
    tick = 0;
    timer.start();
  }
  
  
}