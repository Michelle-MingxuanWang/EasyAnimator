package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
//import javax.swing.Timer;

import model.Canvas;
import model.IModel;
import model.IShape;
import model.Transformation;

/**
 * This class is an visual view of animation.
 *
 */
public class EditView extends JFrame implements IView, ActionListener {
  private DrawPanel panel;
  private List<IViewButton> listeners;
  private int speed;
  
  /**
   * Constructs a visual view with given speed.
   * @param speed input speed
   */
  public EditView(int speed) {
    this.speed = speed;
    this.panel = new DrawPanel();
    this.panel.setBackground(Color.WHITE);

    listeners = new ArrayList<>();
    JScrollPane scrollPane = new JScrollPane(this.panel);

    JButton startButton = new JButton("Start");
    JButton pauseButton = new JButton("Pause");
    JButton resumeButton = new JButton("Resume");
    JButton restartButton = new JButton("Restart");
    
    startButton.setActionCommand("Start");
    startButton.addActionListener(this);
    panel.add(startButton);
    
    pauseButton.setActionCommand("Pause");
    pauseButton.addActionListener(this);
    panel.add(pauseButton);
    
    resumeButton.setActionCommand("Resume");
    resumeButton.addActionListener(this);
    panel.add(resumeButton);
    
    restartButton.setActionCommand("Restart");
    restartButton.addActionListener(this);
    panel.add(restartButton);

    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    add(scrollPane);
    setVisible(true);
  }
  
  /**
   * Add the IViewButtons to listeners.
   * @param button button on panel
   */
  public void addListener(IViewButton button) {
    this.listeners.add(button);
  }
  
  /**
   * Return if the given view has a listener.
   * @return whether the view has a listener
   */
  public boolean hasListener() {
    return true;
  }
  
  /**
   * Action performed by the listener.
   *
   * @param e Action Event
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(listeners.size());
    for (IViewButton button : listeners) {
      System.out.println(button);
      switch (e.getActionCommand()) {
        case "Start":
          button.start();
          break;
        case "Resume":
          System.out.println("heqin");
          button.resume();
          break;
        case "Pause":
          button.paused();
          System.out.println("OK");
          break;
        case "Restart":
          button.restart();
          break;
        default:
          return;
      }
    }
  }
  
  /**
   * Render visual view and draw the shapes.
   * @param shapeList list of shapes in view
   */
  @Override
  public void renderVisual(List<IShape> shapeList) {
    panel.draw(shapeList);
  }
  
  /**
   * Set the canvas of animation.
   * @param canvas of animation
   */
  @Override
  public void setCanvas(Canvas canvas) {
    panel.setBounds((int)canvas.getPosition().getX(), (int)canvas.getPosition().getY(),
        (int)canvas.getDimension().getW(), (int)canvas.getDimension().getH());
    setSize(960, 1280);
    panel.setPreferredSize(new Dimension((int)canvas.getDimension().getW(),
        (int)canvas.getDimension().getH()));
  }
  
  /**
   * Get the speed of view.
   * @return speed of view
   */
  @Override
  public int getSpeed() {
    return this.speed;
  }
  
  /**
   * Render text view (This method is for inheritance purposes).
   */
  @Override
  public String renderText(HashMap<Integer, ArrayList<IShape>> shapeMap, 
      HashMap<String, ArrayList<Transformation>> transformationMap) {
    return null;
  }

  /**
   * Render SVG view (This method is for inheritance purposes).
   */
  @Override
  public String renderSVG(HashMap<Integer, ArrayList<IShape>> shapeMap,
      HashMap<String, ArrayList<Transformation>> transformationMap, IModel model) {
    return null;
  }

  
}