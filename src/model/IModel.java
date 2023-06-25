package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This represents an interface of Animation.
 * @author mingxuanwang
 *
 */
public interface IModel {

  /**
   * Add a shape to the ArrayList it belongs to in the hash map 
   * of shapes.
   * @param shape added shape object
   */
  void addShape(IShape shape);

  /**
   * Add a transformation to the ArrayList it belongs to in the hash map 
   * of transformations.
   * @param transformation added transformation object
   */
  void addTransformation(Transformation transformation);

  /**
   * Get the canvas.
   * @return the canvas
   */
  Canvas getCanvas();

  /**
   * Set up the canvas.
   * @param position position of top left corner of canvas
   * @param dimension dimension of width and height of canvas
   */
  void setCanvas(Position2D position, Dimension2D dimension);

  /**
   * Get the shape at given time in the animation.
   * @param time the given time
   * @return shape object at time
   */
  List<IShape> getShapeAtTime(int time);

  /**
   * Get the map of shapes.
   * @return hash map of shapes
   */
  HashMap<Integer, ArrayList<IShape>> getShapeMap();

  /**
   * Get the map of transformations.
   * @return hash map of transformations
   */
  HashMap<String, ArrayList<Transformation>> getTransformationMap();
}