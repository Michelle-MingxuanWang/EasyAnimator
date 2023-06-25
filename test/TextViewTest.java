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
import view.TextView;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the TextView class.
 */
public class TextViewTest {
  private TextView view;
  private ModelImpl model;
  private Oval oval;
  private Rectangle rectangle;
  Transformation transformationOval;
  Transformation transformationRectangle;
  
  @Before
  public void setup() {
    view = new TextView(2);
    
    model = new ModelImpl();
    model.setCanvas(new Position2D(0, 0), new Dimension2D(360, 360));

    Dimension2D dimension1 = new Dimension2D(10, 20);
    Position2D position1 = new Position2D(0, 10);
    ColorRGB color1 = new ColorRGB(50, 60, 70);
    oval = new Oval("O1", dimension1, position1, color1, ShapeType.OVAL, 10, 80);
    
    Dimension2D dimension2 = new Dimension2D(30, 20);
    Position2D position2 = new Position2D(30, 50);
    ColorRGB color2 = new ColorRGB(50, 160, 20);
    rectangle = new Rectangle("O1", dimension2, position2, color2,
        ShapeType.RECTANGLE, 15, 70);
    
    Dimension2D dimension3 = new Dimension2D(30, 30);
    Position2D position3 = new Position2D(100, 150);
    ColorRGB color3 = new ColorRGB(200, 100, 80);
    
    transformationOval = new Transformation(oval, 20, 60, position1, position2, 
        dimension1, dimension3, color1, color1);
    transformationRectangle = new Transformation(rectangle, 30, 50, position2, position3, 
        dimension2, dimension2, color2, color3);
  }
  
  /**
   * Test the getSpeed method.
   */
  @Test
  public void testGetSpeed() {
    assertEquals(2, view.getSpeed());
  }

  /**
   * Test the renderText method.
   */
  @Test
  public void testRenderText() {
    model.addShape(oval);
    model.addShape(rectangle);
    model.addTransformation(transformationOval);
    model.addTransformation(transformationRectangle);
    
    String result = view.renderText(model.getShapeMap(), model.getTransformationMap());
    assertEquals("Create oval O1 with color (50,60,70) with corner "
        + "at (0.0,10.0), radius 10.0 and 20.0\n"
        + "Create rectangle O1 with color (50,160,20) with corner "
        + "at (30.0,50.0), width 30.0 and height 20.0\n"
        + "O1 appears at time t=10 and disappears at time t=80\n"
        + "O1 appears at time t=15 and disappears at time t=70\n"
        + "O1 moves from (0.0,10.0) to (30.0,50.0) from time t=20 to t=60\n"
        + "O1 scales from (10.0,20.0) to (30.0,30.0) from time t=20 to t=60\n"
        + "O1 changes from color (50,160,20) to (200,100,80) from time t=30 to t=50\n"
        + "O1 moves from (30.0,50.0) to (100.0,150.0) from time t=30 to t=50\n", result);
  }
  
  
}

