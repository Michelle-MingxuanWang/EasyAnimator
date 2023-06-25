package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import util.AnimationBuilder;

/**
 * This represents a class of ModelImpl that implemented 
 * IModel interface.
 * 
 */
public class ModelImpl implements IModel {
  
  private HashMap<Integer, ArrayList<IShape>> shapeMap;
  private HashMap<String, ArrayList<Transformation>> transformationMap; // Guaranteed to be sorted
  private Canvas canvas;
  
  /**
   * Constructs a ModelImpl object.
   */
  public ModelImpl() {
    this.shapeMap = new HashMap<Integer, ArrayList<IShape>>();
    this.transformationMap = new HashMap<String, ArrayList<Transformation>>();
    Position2D defaultPosition = new Position2D(200,70);
    Dimension2D defaultDimension = new Dimension2D(360,360);
    this.canvas = new Canvas(defaultPosition, defaultDimension);
  }
  
  /**
   * This represents a Builder class to build animations.
   *
   */
  public static final class Builder implements AnimationBuilder<IModel> {

    private HashMap<String, IShape> nameMap;
    private HashMap<String, ArrayList<Transformation>> transformationMap; 
    private Position2D position;
    private Dimension2D dimension;
    private int addedShape = 0;
    
    /**
     * Constructs the Builder.
     */
    public Builder() {
      this.nameMap = new HashMap<String, IShape>();
      this.transformationMap = new HashMap<String, ArrayList<Transformation>>();
    }
    
    /**
     * Constructs a final document.
     * @return the newly constructed document
     */
    @Override
    public IModel build() {
      IModel newModel = new ModelImpl();
      for (String key : nameMap.keySet()) {
        
        if (transformationMap.get(key).size() == 0) {
          IShape curShape = nameMap.get(key);
          Transformation curTransformation = new Transformation(curShape, 
              1, Integer.MAX_VALUE, curShape.getPosition(), 
              curShape.getPosition(), curShape.getDimension(), curShape.getDimension(),
              curShape.getColor(),  curShape.getColor());
          newModel.addTransformation(curTransformation);
          
        } else {
          newModel.addShape(nameMap.get(key));
          for (int i = 0; i < transformationMap.get(key).size(); i++) {
            newModel.addTransformation(transformationMap.get(key).get(i));
          }
        }
        
        if (key.equals("B0")) {
          //System.out.println(transformationMap.get(key));
        }
      }
      newModel.setCanvas(position, dimension);
      return newModel;
    }

    /**
     * Specify the bounding box to be used for the animation.
     * @param x The leftmost x value
     * @param y The topmost y value
     * @param width The width of the bounding box
     * @param height The height of the bounding box
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
      position = new Position2D(x, y);
      dimension = new Dimension2D(width, height);
      return this;
    }

    /**
     * Adds a new shape to the growing document.
     *
     * @param name The unique name of the shape to be added.  
     *             No shape with this name should already exist.
     * @param type The type of shape (e.g. "ellipse", "rectangle") to be added.  
     *             The set of supported shapes is unspecified, but should 
     *             include "ellipse" and "rectangle" as a minimum.
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder<IModel> declareShape(String name, String type) {
      if (nameMap.containsKey(name)) {
        return null;
      }
      this.addedShape++;
      if (type.equals("ellipse")) {
        IShape newShape = new EmptyShape(name, ShapeType.OVAL);
        newShape.setOrder(addedShape);
        nameMap.put(name, newShape);
      } else if (type.equals("rectangle")) {
        IShape newShape = new EmptyShape(name, ShapeType.RECTANGLE);
        newShape.setOrder(addedShape);
        nameMap.put(name, newShape);
      }
      return this;
    }

    /**
     * Adds a transformation to the growing document.
     * 
     * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
     * @param t1   The start time of this transformation
     * @param x1   The initial x-position of the shape
     * @param y1   The initial y-position of the shape
     * @param w1   The initial width of the shape
     * @param h1   The initial height of the shape
     * @param r1   The initial red color-value of the shape
     * @param g1   The initial green color-value of the shape
     * @param b1   The initial blue color-value of the shape
     * @param t2   The end time of this transformation
     * @param x2   The final x-position of the shape
     * @param y2   The final y-position of the shape
     * @param w2   The final width of the shape
     * @param h2   The final height of the shape
     * @param r2   The final red color-value of the shape
     * @param g2   The final green color-value of the shape
     * @param b2   The final blue color-value of the shape
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder<IModel> addMotion(String name, int t1, int x1,
        int y1, int w1, int h1, int r1, int g1,int b1, int t2, int x2, 
        int y2, int w2, int h2, int r2, int g2, int b2) {
      
      if (!nameMap.containsKey(name)) {
        return null;
      } 
      
      IShape curShape;
      
      Dimension2D startDimension = new Dimension2D(w1, h1);
      Position2D startPosition = new Position2D(x1, y1);
      ColorRGB startColor = new ColorRGB(r1, g1, b1);
      Dimension2D endDimension = new Dimension2D(w2, h2);
      Position2D endPosition = new Position2D(x2, y2);
      ColorRGB endColor = new ColorRGB(r2, g2, b2);
      
      Transformation curTransformation;
      
      ArrayList<Transformation> curTransformationList;
      
      if (!transformationMap.containsKey(name)) {
        curShape = ShapeBuilder.buildShape(name, startDimension, startPosition, startColor, 
            nameMap.get(name).getType(), t1, Integer.MAX_VALUE);
        curShape.setOrder(nameMap.get(name).getOrder());
        nameMap.put(name, curShape);
        
        curTransformationList = new ArrayList<Transformation>();
      } else {
        curShape = nameMap.get(name);
        curTransformationList = transformationMap.get(name);
      }
      curTransformation = new Transformation(curShape, t1, t2, 
          startPosition, endPosition, startDimension, endDimension, startColor, endColor);
      curTransformationList.add(curTransformation);
      transformationMap.put(name, curTransformationList);
      
      return this;
    }
     
  }
  
  /**
   * Add a shape to the ArrayList it belongs to in the hash map 
   * of shapes.
   * @param shape added shape object
   */
  public void addShape(IShape shape) {
    int startTime = shape.getAppearTime();
    ArrayList<IShape> curList;
    if (shapeMap.containsKey(startTime)) {
      curList = shapeMap.get(startTime);
    } else {
      curList = new ArrayList<IShape>();
    }
    curList.add(shape);
    shapeMap.put(startTime, curList);
  }
  
  /**
   * Add a transformation to the ArrayList it belongs to in the hash map 
   * of transformations.
   * @param transformation added transformation object
   */
  public void addTransformation(Transformation transformation) {
    String name = transformation.getShape().getName();
    ArrayList<Transformation> curList;
    if (transformationMap.containsKey(name)) {
      curList = transformationMap.get(name);
    } else {
      curList = new ArrayList<Transformation>();
    }
    curList.add(transformation);
    transformationMap.put(name, curList);
  }


  /**
   * Get the canvas.
   * @return the canvas
   */
  @Override
  public Canvas getCanvas() {
    return this.canvas; 
  }
  
  /**
   * Set up the canvas.
   * @param position position of top left corner of canvas
   * @param dimension dimension of width and height of canvas
   */
  @Override
  public void setCanvas(Position2D position, Dimension2D dimension) {
    this.canvas = new Canvas(position, dimension);
  }

  /**
   * Get the shape at given time in the animation.
   * @param time the given time
   * @return shape object at time
   */
  @Override
  public List<IShape> getShapeAtTime(int time) {
    int index = 0;
    List<IShape> shapeList = new ArrayList<IShape>();
    HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
    ArrayList<IShape> currShapes;

    // get all shapes suppose to appear at this tick
    for (Integer key : this.shapeMap.keySet()) {
      // appear time after this tick
      if (key > time) {
        continue;
      }
      // add shapes
      currShapes = this.shapeMap.get(key);
      for (IShape shape : currShapes) {
        shapeList.add(shape);
        indexMap.put(shape.getName(),index);
        index ++;
      }
    }

    // apply transformations
    int curOrder;
    for (IShape shape : shapeList) {
      curOrder = shape.getOrder();
      // no transformation
      if (! this.transformationMap.containsKey(shape.getName())) {
        continue;
      }
      ArrayList<Transformation> allTransformationOfShape = 
          this.transformationMap.get(shape.getName());
      for ( Transformation t : allTransformationOfShape) {
        if (t.getEndTime() >= time && t.getStartTime() <= time) {
          IShape updatedShape = t.shapeAtCurTime(time);
          updatedShape.setOrder(curOrder);
          shapeList.set(indexMap.get(shape.getName()), updatedShape);
        }
      }
    }
    Collections.sort(shapeList, Comparator.comparingInt(IShape ::getOrder));
    return shapeList;
  }

  /**
   * Get the map of shapes.
   * @return hash map of shapes
   */
  @Override
  public HashMap<Integer, ArrayList<IShape>> getShapeMap() {
    return this.shapeMap;
  }

  /**
   * Get the map of transformations.
   * @return hash map of transformations
   */
  @Override
  public HashMap<String, ArrayList<Transformation>> getTransformationMap() {
    return this.transformationMap;
  }
    
}