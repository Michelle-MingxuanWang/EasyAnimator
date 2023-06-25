package model;

/**
 * This class represents a placeholder of a shape with only information of name and type.
 *
 */
public class EmptyShape implements IShape {
  
  private String name;
  private ShapeType type;
  private int orderNumber;
  
  /**
   * Constructs a EmptyShape object.
   * @param name name of the shape
   * @param type type of the shape
   */
  public EmptyShape(String name, ShapeType type) {
    this.name = name;
    this.type = type;
  }

  /**
   * Get the name of shape.
   * @return name of shape
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
    return null;
  }

  /**
   * Get the position.
   */
  @Override
  public Position2D getPosition() {
    return null;
  }

  /**
   * Get the color.
   */
  @Override
  public ColorRGB getColor() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Get the type.
   * @return type of shape
   */
  @Override
  public ShapeType getType() {
    // TODO Auto-generated method stub
    return this.type;
  }

  /**
   * Get the appear time.
   */
  @Override
  public int getAppearTime() {
    return 0;
  }

  /**
   * Get the disappear time.
   */
  @Override
  public int getDisappearTime() {
    return 0;
  }

  @Override
  public int getOrder() {
    return this.orderNumber;
  }

  @Override
  public void setOrder(int order) {
    this.orderNumber = order;
  }
}