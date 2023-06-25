package model;

/**
 * This class represents a transformation of one shape in the animation .
 *
 */
public class Transformation {
  private IShape shape;
  private int startTime;
  private int endTime;
  private Position2D startPosition;
  private Position2D endPosition;
  private Dimension2D startDimension;
  private Dimension2D endDimension;
  private ColorRGB startColor;
  private ColorRGB endColor;
  
  
  /**
   * Constructs a Transformation object with given information.
   * @param shape shape that will be transformed
   * @param startTime start time of transformation animation
   * @param endTime end time of transformation animation
   * @param startPosition position at the start of transformation animation
   * @param endPosition position at the end of transformation animation
   * @param startDimension dimension at the start of transformation animation
   * @param endDimension dimension at the end of transformation animation
   * @param startColor color at the start of transformation animation
   * @param endColor color at the start of transformation animation
   */
  public Transformation(IShape shape, int startTime, int endTime, 
      Position2D startPosition, Position2D endPosition, 
      Dimension2D startDimension, Dimension2D endDimension,
      ColorRGB startColor, ColorRGB endColor) {
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startPosition = startPosition;
    this.endPosition = endPosition;
    this.startDimension = startDimension;
    this.endDimension = endDimension;
    this.startColor = startColor;
    this.endColor = endColor;
  }
  
  /**
   * Calculate the current value of one attributes of the transformation 
   * at the current time in the animation. 
   * @param curTime current time
   * @return current value
   */
  private double curValue(int curTime, double startState, double endState) {
    if (this.endTime == Integer.MAX_VALUE) {
      return startState;
    }
    if (this.endTime == this.startTime) {
      return startState;
    }
    double changeRate = (endState - startState) / ((double)this.endTime - (double)this.startTime);
    return changeRate * ((double)curTime - (double)this.startTime) + startState;
  }
  
  /**
   * Return the shape at current time in the transformation.
   * @param curTime current time
   * @return shape at current time
   */
  public IShape shapeAtCurTime(int curTime) {
    
    double curX = curValue(curTime, startPosition.getX(), endPosition.getX());
    double curY = curValue(curTime, startPosition.getY(), endPosition.getY());
    Position2D curPosition = new Position2D(curX, curY);
    
    double curW = curValue(curTime, startDimension.getW(), endDimension.getW());
    double curH = curValue(curTime, startDimension.getH(), endDimension.getH());
    Dimension2D curDimension = new Dimension2D(curW, curH);
    
    int curR = (int)curValue(curTime, startColor.getR(), endColor.getR());
    int curG = (int)curValue(curTime, startColor.getG(), endColor.getG());
    int curB = (int)curValue(curTime, startColor.getB(), endColor.getB());
    ColorRGB curColor = new ColorRGB(curR, curG, curB);
    
    return ShapeBuilder.buildShape(shape.getName(), curDimension, curPosition, curColor, 
        shape.getType(), shape.getAppearTime(), shape.getDisappearTime());
  }

  /**
   * Get the shape of the transformation.
   * @return the shape
   */
  public IShape getShape() {
    return this.shape;
  }

  /**
   * Get the start time of the transformation.
   * @return the startTime
   */
  public int getStartTime() {
    return startTime;
  }

  /**
   * Get the end time of the transformation.
   * @return the endTime
   */
  public int getEndTime() {
    return endTime;
  }

  /**
   * Get the start position of the transformation.
   * @return the startPosition
   */
  public Position2D getStartPosition() {
    return startPosition;
  }

  /**
   * Get the end position of the transformation.
   * @return the endPosition
   */
  public Position2D getEndPosition() {
    return endPosition;
  }

  /**
   * Get the start dimension of the transformation.
   * @return the startDimension
   */
  public Dimension2D getStartDimension() {
    return startDimension;
  }

  /**
   * Get the end dimension of the transformation.
   * @return the endDimension
   */
  public Dimension2D getEndDimension() {
    return endDimension;
  }

  /**
   * Get the start color of the transformation.
   * @return the startColor
   */
  public ColorRGB getStartColor() {
    return startColor;
  }

  /**
   * Get the end color of the transformation.
   * @return the endColor
   */
  public ColorRGB getEndColor() {
    return endColor;
  }
  
  /**
   * Get the string format of the transformation in the text view.
   * @return the string format of the transformation
   */
  public String toString() {
    String text = "";
    if (!this.endColor.toString().equals(this.startColor.toString())) {
      text = text + this.shape.getName() + " changes from color " + this.startColor.toString() 
        + " to " + this.endColor.toString() + " from time t=" 
        + this.startTime + " to t=" + this.endTime + "\n";
    } 
    if (!this.endPosition.toString().equals(this.startPosition.toString())) {
      text = text + this.shape.getName() + " moves from " + this.startPosition.toString() 
        + " to " + this.endPosition.toString() + " from time t=" 
        + this.startTime + " to t=" + this.endTime + "\n";
    } 
    if (!this.endDimension.toString().equals(this.startDimension.toString())) {
      text = text + this.shape.getName() + " scales from " + this.startDimension.toString() 
        + " to " + this.endDimension.toString() + " from time t="
        + this.startTime + " to t=" + this.endTime + "\n";
    } 
    return text;
    
  }
}