import org.junit.Before;
import org.junit.Test;

import model.ColorRGB;
import model.Dimension2D;
import model.Oval;
import model.Position2D;
import model.ShapeType;
import model.Transformation;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the Transformation class.
 */
public class TransformationTest {
  
  private Transformation transformation;
  
  @Before
  public void setup() {
    Dimension2D dimension1 = new Dimension2D(10, 20);
    Position2D position1 = new Position2D(0, 10);
    ColorRGB color1 = new ColorRGB(50, 60, 70);
    Oval oval = new Oval("O1", dimension1, position1, color1, ShapeType.OVAL, 10, 80);
  
    Dimension2D dimension2 = new Dimension2D(30, 20);
    Position2D position2 = new Position2D(10, 20);
    ColorRGB color2 = new ColorRGB(50, 160, 20);
    transformation = new Transformation(oval, 20, 40, position1, position2, 
        dimension1, dimension2, color1, color2);
  }
  
  /**
   * Test the getter methods.
   */
  @Test
  public void testGetters() {
    System.out.println();
    assertEquals("O1, (10.0,20.0), (0.0,10.0), (50,60,70), oval, 10, 80", 
        transformation.getShape().toString());  
    assertEquals(20, transformation.getStartTime());
    assertEquals(40, transformation.getEndTime());
    assertEquals("(0.0,10.0)", transformation.getStartPosition().toString());
    assertEquals("(10.0,20.0)", transformation.getEndPosition().toString());
    assertEquals("(10.0,20.0)", transformation.getStartDimension().toString());
    assertEquals("(30.0,20.0)", transformation.getEndDimension().toString());
    assertEquals("(50,60,70)", transformation.getStartColor().toString());
    assertEquals("(50,160,20)", transformation.getEndColor().toString());
  }
  
  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("O1 changes from color (50,60,70) to (50,160,20) from time t=20 to t=40\n"
        + "O1 moves from (0.0,10.0) to (10.0,20.0) from time t=20 to t=40\n"
        + "O1 scales from (10.0,20.0) to (30.0,20.0) from time t=20 to t=40\n", 
        transformation.toString());  
  }
  
  /**
   * Test the shapeAtCurTime method.
   */
  @Test
  public void testShapeAtCurTime() {
    assertEquals("O1, (20.0,20.0), (5.0,15.0), (50,110,45), oval, 10, 80",
        transformation.shapeAtCurTime(30).toString());
  }
}