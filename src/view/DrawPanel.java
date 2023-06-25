package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import model.IShape;
import model.ShapeType;

/**
 * This class draw a panel in the visual view.
 *
 */
public class DrawPanel extends JPanel {
  private List<IShape> shapeList;
  
  /**
   * Constructs a panel to draw on.
   */
  public DrawPanel() {
    super();
  }
  
  /**
   * Paint a shape component.
   * @param g given Graphics object
   */
  @Override
  public void paintComponent(Graphics g) {
    
    super.paintComponent(g);
    if (this.shapeList != null) {
      Graphics2D g2d = (Graphics2D) g;
      g.setColor(Color.BLACK);
      
      
      
      for (IShape shape : shapeList) {
        g2d.setColor(new Color(shape.getColor().getR(), 
            shape.getColor().getG(), shape.getColor().getB()));
        
        if (shape.getType() == ShapeType.OVAL) {
          g2d.fillOval((int)shape.getPosition().getX(), (int)shape.getPosition().getY(), 
              (int)shape.getDimension().getW(), (int)shape.getDimension().getH());
        } else if (shape.getType() == ShapeType.RECTANGLE) {
          g2d.fillRect((int)shape.getPosition().getX(), (int)shape.getPosition().getY(), 
              (int)shape.getDimension().getW(), (int)shape.getDimension().getH());
          
        } 
      }
    }

  }
  
  
  /**
   * Draw the shapes.
   *
   * @param shapeList list of shapes
   */
  public void draw(List<IShape> shapeList) {
    this.shapeList = shapeList;
    repaint();
  }
  
  
}