import org.junit.Before;
import org.junit.Test;

import model.ColorRGB;
import model.Dimension2D;
import model.ModelImpl;
import model.Oval;
import model.Position2D;
import model.Rectangle;
import model.ShapeType;
import model.Transformation;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the ModelImpl class.
 */
public class ModelImplTest {
  private ModelImpl model;
  private Oval oval;
  
  private Transformation transformation;
  private Dimension2D dimension2;
  private Position2D position2;
  private ColorRGB color2;
  
  private Position2D positionCanvas;
  private Dimension2D dimensionCanvas;
  
  @Before
  public void setup() {
    model = new ModelImpl();
    Dimension2D dimension1 = new Dimension2D(10, 20);
    Position2D position1 = new Position2D(0, 10);
    ColorRGB color1 = new ColorRGB(50, 60, 70);
    oval = new Oval("O1", dimension1, position1, color1, ShapeType.OVAL, 10, 80);
  
    dimension2 = new Dimension2D(30, 20);
    position2 = new Position2D(10, 20);
    color2 = new ColorRGB(50, 160, 20);
    transformation = new Transformation(oval, 20, 40, position1, position2, 
        dimension1, dimension2, color1, color2);
    
    positionCanvas = new Position2D(0, 0);
    dimensionCanvas = new Dimension2D(360, 360);

  }
  
  /**
   * Test the addShape method and the getShapeMap method.
   */
  @Test
  public void testAddShape() {
    model.addShape(oval);
    assertEquals("[O1, (10.0,20.0), (0.0,10.0), (50,60,70), oval, "
        + "10, 80]", model.getShapeMap().get(10).toString());
  }
  
  /**
   * Test the addTransformation and getTransformationMap method.
   */
  @Test
  public void testAddTransformation() {
    model.addTransformation(transformation);
    assertEquals("[O1 changes from color (50,60,70) to (50,160,20) from time t=20 to t=40\n"
        + "O1 moves from (0.0,10.0) to (10.0,20.0) from time t=20 to t=40\n"
        + "O1 scales from (10.0,20.0) to (30.0,20.0) from time t=20 to t=40\n]",
        model.getTransformationMap().get("O1").toString());
  }
  

  /**
   * Test the setCanvas and getCanvas method.
   */
  @Test
  public void testSetGetCanvas() {
    model.setCanvas(positionCanvas, dimensionCanvas);
    assertEquals(360, model.getCanvas().getDimension().getH(), 0.01);
    assertEquals(360, model.getCanvas().getDimension().getW(), 0.01);
    assertEquals(0, model.getCanvas().getPosition().getX(), 0.01);
    assertEquals(0, model.getCanvas().getPosition().getY(), 0.01);
  }
  
  /**
   * Test the getShapeAtTime method.
   */
  @Test
  public void testGetShapeAtTime() {
    model.addShape(oval);
    Rectangle rec = new Rectangle("R1", dimension2, position2, color2, ShapeType.RECTANGLE, 20, 60);
    model.addShape(rec);
    assertEquals("O1, (10.0,20.0), (0.0,10.0), (50,60,70), oval, 10, 80", 
        model.getShapeAtTime(30).get(1).toString());
    assertEquals("R1, (30.0,20.0), (10.0,20.0), (50,160,20), rectangle, 20, 60", 
        model.getShapeAtTime(30).get(0).toString());
  }
  
  
}

