package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import model.IModel;
import model.IShape;
import view.IView;

/**
 * This class represents a controller for visual view.
 *
 */
public class VisualViewController implements ActionListener, IController {
  private Timer timer;
  private int tick = 0;
  private IModel model;
  private IView view;
  
  /**
   * Constructs a visual view controller.
   * @param model application model
   * @param view application view
   */
  public VisualViewController(IModel model, IView view) {
    this.model = model;
    this.view = view;
    timer = new Timer(1000 / view.getSpeed(), this);
    view.setCanvas(model.getCanvas());
    
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
    timer.start();
  }
  
  
  
}