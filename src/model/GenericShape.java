package model;

/**
 * This represents an abstract class of shapes which implements Shape interface.
 */
public abstract class GenericShape implements IShape {
  
  protected Dimension2D dimension;
  protected Position2D position;
  protected ColorRGB color;
  protected String name;
  protected ShapeType type;
  protected int appearTime;
  protected int disappearTime;
  protected int orderNumber;
  
  /**
   * Constructs a GenericShape abstract class.
   * @param name name of the shape
   * @param dimension dimension of the shape
   * @param position position of the shape
   * @param color color of the shape
   * @param type type of the shape
   * @param appearTime time of the shape appears
   * @param disappearTime time of the shape disappears
   */
  public GenericShape(String name, Dimension2D dimension, Position2D position, 
      ColorRGB color, ShapeType type, int appearTime, int disappearTime) 
          throws IllegalArgumentException {
    if (appearTime < 0 || disappearTime < 0 || appearTime > disappearTime) {
      throw new IllegalArgumentException("Invalid appear or disappear time");
    }
    this.name = name;
    this.dimension = dimension;
    this.position = position;
    this.color = color;
    this.type = type;
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
  }
  
  /**
   * Get the name of shape.
   */
  @Override
  public String getName() {
    return this.name;
  }
  
  /**
   * Get the dimension.
   */
  @Override
  public Dimension2D getDimension() {
    return this.dimension;
  }
  
  /**
   * Get the position.
   */
  @Override
  public Position2D getPosition() {
    return this.position;
  }
  
  /**
   * Get the type of the shape.
   */
  @Override
  public ShapeType getType() {
    return this.type;
  }
  
  /**
   * Get color of shape.
   */
  @Override
  public ColorRGB getColor() {
    return this.color;
  }
  
  /**
   * Get the appear time of the shape.
   */
  @Override
  public int getAppearTime() {
    return this.appearTime;
  }
  
  /**
   * Get the disappear time of shape.
   */
  @Override
  public int getDisappearTime() {
    return this.disappearTime;
  }
  
  /**
   * Get the order of the shape.
   */
  @Override
  public int getOrder() {
    return this.orderNumber;
  }
  
  /**
   * Set the order of the shape.
   */
  @Override
  public void setOrder(int order) {
    this.orderNumber = order;
  }
  
  /**
   * Return the string format for shapes. 
   * This method is for test uses.
   */
  @Override
  public String toString() {
    return name + ", " + dimension.toString() + ", " 
      + position.toString() + ", " + color.toString() + ", " 
      + type.toString() + ", " + Integer.toString(appearTime) + ", "
      + Integer.toString(disappearTime);
  }
}