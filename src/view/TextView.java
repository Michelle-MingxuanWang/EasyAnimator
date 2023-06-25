package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Canvas;
import model.IModel;
import model.IShape;
import model.ShapeType;
import model.Transformation;

/**
 * This class is an text view of animation.
 *
 */
public class TextView implements IView {
  Integer speed;

  /**
   * Constructs a text view with given speed.
   * @param speed input speed
   */
  public TextView(int speed) {
    this.speed = speed;
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
   * Render visual view (This method is for inheritance purposes).
   */
  @Override
  public void renderVisual(List<IShape> shapeList) {
    // do nothing
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
   * Render the text view.
   * @param shapeMap map of shapes in view
   * @param transformationMap map of transformations in view
   * @return rendered output in text view
   */
  @Override
  public String renderText(HashMap<Integer, ArrayList<IShape>> shapeMap,
                           HashMap<String, ArrayList<Transformation>> transformationMap) {
    StringBuilder text = new StringBuilder();
    ArrayList<IShape> curList = null;
    for (Integer key: shapeMap.keySet()) {
      curList = shapeMap.get(key);
      for (IShape shape : curList) {
        if (shape.getType() == ShapeType.RECTANGLE) {
          text.append("Create " + shape.getType().toString() + " " + shape.getName() 
              + " with color " + shape.getColor().toString() + " with corner at " 
              + shape.getPosition().toString() + ", width " 
              + Double.toString(shape.getDimension().getW())
              + " and height " + Double.toString(shape.getDimension().getH()) + "\n");
        } if (shape.getType() == ShapeType.OVAL) {
          text.append("Create " + shape.getType().toString() + " " + shape.getName() 
              + " with color " + shape.getColor().toString() + " with corner at "
              + shape.getPosition().toString() + ", radius " 
              + Double.toString(shape.getDimension().getW()) 
              + " and " + Double.toString(shape.getDimension().getH()) + "\n");
        }
      } 
    }
    
    for (Integer key: shapeMap.keySet()) {
      curList = shapeMap.get(key);
      for (IShape shape : curList) {
        text.append(shape.getName() + " appears at time t=" + Integer.toString(key) 
            + " and disappears at time t=" + Integer.toString(shape.getDisappearTime()) + "\n");
      } 
    }
    
    ArrayList<Transformation> curTransformationList = null;
    for (String key: transformationMap.keySet()) {
      curTransformationList = transformationMap.get(key);
      for (Transformation transformation : curTransformationList) {
        text.append(transformation.toString());
      } 
    }
    
    return text.toString();
    
  }

  /**
   * Set the canvas of animation.
   * @param canvas of animation
   */
  @Override
  public void setCanvas(Canvas canvas) {
    // Do nothing
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