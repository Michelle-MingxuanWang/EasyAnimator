package view;

import model.Canvas;
import model.IModel;
import model.IShape;
import model.Transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This represents an interface of AnimationView.
 *
 */
public interface IView {

  /**
   * Render the visual view.
   * @param shapeList list of shapes in view
   */
  void renderVisual(List<IShape> shapeList);

  /**
   * Render the text view.
   * @param shapeMap map of shapes in view
   * @param transformationMap map of transformations in view
   * @return rendered output in text view
   */
  String renderText(HashMap<Integer, ArrayList<IShape>> shapeMap,
      HashMap<String, ArrayList<Transformation>> transformationMap);
  
  /**
   * Render the SVG view.
   * @param shapeMap map of shapes in view
   * @param transformationMap map of transformations in view
   * @param model model of application
   * @return rendered output in SVG view
   */
  String renderSVG(HashMap<Integer, ArrayList<IShape>> shapeMap,
      HashMap<String, ArrayList<Transformation>> transformationMap, IModel model);
  
  /**
   * Get the speed of view.
   * @return speed of view
   */
  int getSpeed();
  
  /**
   * Set the canvas of animation.
   * @param canvas of animation
   */
  void setCanvas(Canvas canvas);
  
  /**
   * Add action listeners.
   * @param button button on edit view
   */
  void addListener(IViewButton button);


}