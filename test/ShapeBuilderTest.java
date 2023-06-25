import org.junit.Before;
import org.junit.Test;

import model.ColorRGB;
import model.Dimension2D;
import model.IShape;
import model.Position2D;
import model.ShapeBuilder;
import model.ShapeType;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the shapeBuilder class.
 */
public class ShapeBuilderTest {
  private Dimension2D dimension;
  private Position2D position;
  private ColorRGB color;
  
  @Before
  public void setup() {
    dimension = new Dimension2D(10, 20);
    position = new Position2D(20, 20);
    color = new ColorRGB(40, 50, 60);
  }
  
  /**
   * Test the buildShape method.
   */
  @Test
  public void testbuildShape() {
    IShape buildedShape = ShapeBuilder.buildShape("O1", dimension, position, color, 
        ShapeType.OVAL, 10, 50);
    assertEquals("O1, (10.0,20.0), (20.0,20.0), (40,50,60), "
        + "oval, 10, 50", buildedShape.toString());
  }
}