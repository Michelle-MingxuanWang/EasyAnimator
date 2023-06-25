import org.junit.Before;
import org.junit.Test;

import model.ColorRGB;
import model.Dimension2D;
import model.Oval;
import model.Position2D;
import model.Rectangle;
import model.ShapeType;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the Oval and Rectangle class.
 */
public class ShapeTest {
  private Oval oval;
  private Rectangle rectangle;
  
  @Before
  public void setup() {
    Dimension2D dimension1 = new Dimension2D(10, 20);
    Position2D position1 = new Position2D(20, 20);
    ColorRGB color1 = new ColorRGB(40, 50, 60);
    
    Dimension2D dimension2 = new Dimension2D(20, 20);
    Position2D position2 = new Position2D(20, 50);
    ColorRGB color2 = new ColorRGB(60, 80, 100);
    
    oval = new Oval("O", dimension1, position1, color1, ShapeType.OVAL, 0, 100);
    rectangle = new Rectangle("R", dimension2, position2, color2, ShapeType.RECTANGLE, 20, 80);
  }
  
  /**
   * Test the getter methods.
   */
  @Test
  public void testGetters() {
    assertEquals("O", oval.getName());
    assertEquals("(10.0,20.0)", oval.getDimension().toString());
    assertEquals("(20.0,20.0)", oval.getPosition().toString());
    assertEquals("(40,50,60)", oval.getColor().toString());
    assertEquals(ShapeType.OVAL, oval.getType());
    assertEquals(0, oval.getAppearTime());
    assertEquals(100, oval.getDisappearTime());
    
    assertEquals("R", rectangle.getName());
    assertEquals("(20.0,20.0)", rectangle.getDimension().toString());
    assertEquals("(20.0,50.0)", rectangle.getPosition().toString());
    assertEquals("(60,80,100)", rectangle.getColor().toString());
    assertEquals(ShapeType.RECTANGLE, rectangle.getType());
    assertEquals(20, rectangle.getAppearTime());
    assertEquals(80, rectangle.getDisappearTime());
  }
}