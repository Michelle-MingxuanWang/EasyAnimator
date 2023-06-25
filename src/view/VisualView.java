package view;

import java.awt.Color;
import java.awt.Dimension;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.Canvas;
import model.IModel;
import model.IShape;
import model.Transformation;

/**
 * This class is an visual view of animation.
 *
 */
public class VisualView extends JFrame implements IView {
  private DrawPanel panel;
  private int speed;
  
  /**
   * Constructs a visual view with given speed.
   * @param speed input speed
   */
  public VisualView(int speed) {
    this.speed = speed;
    this.panel = new DrawPanel();
    this.panel.setBackground(Color.WHITE);

    JScrollPane scrollPane = new JScrollPane(this.panel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    add(scrollPane);
    setVisible(true);
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

  /**
   * Add action listeners. This method is for inheritance purposes.
   * @param button button on edit view
   */
  @Override
  public void addListener(IViewButton button) {
    // Do nothing
  }
}