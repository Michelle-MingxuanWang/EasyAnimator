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
import view.SVGView;

import static org.junit.Assert.assertEquals;


/**
 * This class tests the SVGView class.
 */
public class SVGViewTest {
  private SVGView view;
  private ModelImpl model;
  private Oval oval;
  private Rectangle rectangle;
  Transformation transformationOval;
  Transformation transformationRectangle;
  
  @Before
  public void setup() {
    view = new SVGView(2);
    
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
   * Test the renderSVG method.
   */
  @Test
  public void testRenderSVG() {
    model.addShape(oval);
    model.addShape(rectangle);
    model.addTransformation(transformationOval);
    model.addTransformation(transformationRectangle);
    
    String result = view.renderSVG(model.getShapeMap(), model.getTransformationMap(), model);
    assertEquals("<?xml version=\"1.0\" standalone=\"no\"?>\n"
        + "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \n"
        + "  \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
        + "<svg width=\"25cm\" height=\"15cm\"  viewBox=\"0.0 0.0 360.0 360.0\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n"
        + "  <ellipse id=\"O1\" cx=\"0.000000\" cy=\"10.000000\" "
        + "rx=\"10.000000\" rt=\"20.000000\"\n"
        + "        fill=\"rgb(50,60,70)\"\n"
        + "  >\n"
        + "    <animate attributeName=\"cx\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"0.000000\" to=\"30.000000\" />\n"
        + "    <animate attributeName=\"cy\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"10.000000\" to=\"50.000000\" />\n"
        + "    <animate attributeName=\"rx\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"10.000000\" to=\"30.000000\" />\n"
        + "    <animate attributeName=\"ry\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"20.000000\" to=\"30.000000\" />\n"
        + "    <animate attributeName=\"fill\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"rgb(50,60,70)\" to=\"rgb(50,60,70)\" />\n"
        + "    <animate attributeName=\"x\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"30.000000\" to=\"100.000000\" />\n"
        + "    <animate attributeName=\"y\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"50.000000\" to=\"150.000000\" />\n"
        + "    <animate attributeName=\"width\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"30.000000\" to=\"30.000000\" />\n"
        + "    <animate attributeName=\"height\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"20.000000\" to=\"20.000000\" />\n"
        + "    <animate attributeName=\"fill\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"rgb(50,160,20)\" to=\"rgb(200,100,80)\" />\n"
        + "  </ellipse>\n"
        + "  <rect id=\"O1\" x=\"30.000000\" y=\"50.000000\""
        + " width=\"30.000000\" height=\"20.000000\"\n"
        + "        fill=\"rgb(50,160,20)\"\n"
        + "  >\n"
        + "    <animate attributeName=\"cx\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"0.000000\" to=\"30.000000\" />\n"
        + "    <animate attributeName=\"cy\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"10.000000\" to=\"50.000000\" />\n"
        + "    <animate attributeName=\"rx\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"10.000000\" to=\"30.000000\" />\n"
        + "    <animate attributeName=\"ry\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"20.000000\" to=\"30.000000\" />\n"
        + "    <animate attributeName=\"fill\" attributeType=\"XML\"\n"
        + "             begin=\"10.000000s\" dur=\"20.000000s\""
        + " from=\"rgb(50,60,70)\" to=\"rgb(50,60,70)\" />\n"
        + "    <animate attributeName=\"x\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"30.000000\" to=\"100.000000\" />\n"
        + "    <animate attributeName=\"y\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"50.000000\" to=\"150.000000\" />\n"
        + "    <animate attributeName=\"width\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"30.000000\" to=\"30.000000\" />\n"
        + "    <animate attributeName=\"height\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"20.000000\" to=\"20.000000\" />\n"
        + "    <animate attributeName=\"fill\" attributeType=\"XML\"\n"
        + "             begin=\"15.000000s\" dur=\"10.000000s\""
        + " from=\"rgb(50,160,20)\" to=\"rgb(200,100,80)\" />\n"
        + "  </rect>\n"
        + "</svg>", result);
  }
  
  
}

