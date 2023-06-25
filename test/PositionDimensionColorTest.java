import org.junit.Before;
import org.junit.Test;

import model.ColorRGB;
import model.Dimension2D;
import model.Position2D;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the Position2D class.
 */
public class PositionDimensionColorTest {
  private Position2D position;
  private Dimension2D dimension;
  private ColorRGB color;
  
  @Before
  public void setup() {
    position = new Position2D(0, 0);
    dimension = new Dimension2D(10, 20);
    color = new ColorRGB(40, 50, 60);
  }
  
  /**
   * Test the Dimension2D constructor when it should throw exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDimension() {
    new Dimension2D(0, 0);
  }
  
  /**
   * Test the ColorRGB constructor when it should throw exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidColor() {
    new ColorRGB(-2, 256, 60);
  }
  
  /**
   * Test the getters.
   */
  @Test
  public void testGetter() {
    assertEquals(0, position.getX(), 0.0001);
    assertEquals(0, position.getY(), 0.0001);
    
    assertEquals(10, dimension.getW(), 0.0001);
    assertEquals(20, dimension.getH(), 0.0001);
    
    assertEquals(40, color.getR());
    assertEquals(50, color.getG());
    assertEquals(60, color.getB());
  }
  
  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("(0.0,0.0)", position.toString());
    assertEquals("(10.0,20.0)", dimension.toString());
    assertEquals("(40,50,60)", color.toString());
  }
  
  
}