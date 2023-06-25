package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import model.Canvas;
import model.IModel;
import model.IShape;
import model.ShapeType;
import model.Transformation;

/**
 * This class is an SVG view of animation.
 *
 */
public class SVGView implements IView {
  Integer speed;
  

  /**
   * Constructs a SVG view with given speed.
   * @param speed input speed
   */
  public SVGView(int speed) {
    this.speed = speed;
  }


  /**
   * Get the speed of view.
   * @return speed of view
   */
  @Override
  public int getSpeed() {
    return this.speed;
  }

  /**
   * Render visual view (This method is for inheritance purposes).
   */
  @Override
  public void renderVisual(List<IShape> shapeList) {
    // do nothing
  }

  /**
   * Render text view (This method is for inheritance purposes).
   */
  @Override
  public String renderText(HashMap<Integer, ArrayList<IShape>> shapeMap,
      HashMap<String, ArrayList<Transformation>> transformationMap) {
    return null;
  }

  /**
   * Render the SVG view.
   * @param shapeMap map of shapes in view
   * @param transformationMap map of transformations in view
   * @param model model of application
   * @return rendered output in SVG view
   */
  @Override
  public String renderSVG(HashMap<Integer, ArrayList<IShape>> shapeMap,
                           HashMap<String, ArrayList<Transformation>> transformationMap,
                           IModel model) {
    StringBuilder text = new StringBuilder();
    ArrayList<IShape> curList = null;
    String shapeType = null;
    
    text.append("<?xml version=\"1.0\" standalone=\"no\"?>\n"
        + "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \n"
        + "  \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
        + "<svg width=\"25cm\" height=\"15cm\"  viewBox=\"" 
        + model.getCanvas().getPosition().getX() + " " 
        + model.getCanvas().getPosition().getY() + " "
        + model.getCanvas().getDimension().getW() + " " 
        + model.getCanvas().getDimension().getH() + "\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n"
    );
    
      
    for (Integer key: shapeMap.keySet()) {
      curList = shapeMap.get(key);
      Collections.sort(curList, Comparator.comparingInt(IShape :: getOrder));
      for (IShape shape : curList) {
        String shapeInfo;
        if (shape.getType() == ShapeType.RECTANGLE) {
          shapeInfo = String.format("  <rect id=\"%s\" x=\"%f\" "
              + "y=\"%f\" width=\"%f\" height=\"%f\"\n"
              + "        fill=\"rgb%s\"\n  >\n", 
              shape.getName(), shape.getPosition().getX(), 
              shape.getPosition().getY(), shape.getDimension().getW(), 
              shape.getDimension().getH(), shape.getColor().toString());
          text.append(shapeInfo);
          shapeType = "  </rect>";
        } else if (shape.getType() == ShapeType.OVAL) {
          shapeInfo = String.format("  <ellipse id=\"%s\" cx=\"%f\" "
              + "cy=\"%f\" rx=\"%f\" rt=\"%f\"\n"
              + "        fill=\"rgb%s\"\n  >\n", 
              shape.getName(), shape.getPosition().getX(), 
              shape.getPosition().getY(), shape.getDimension().getW(), 
              shape.getDimension().getH(), shape.getColor().toString());
          text.append(shapeInfo);
          shapeType = "  </ellipse>";
        }
        
        ArrayList<Transformation> curTransformationList = transformationMap.get(shape.getName());
        for (Transformation transformation: curTransformationList) {
          String transformationInfo;
          
          double begin = (1.0 * transformation.getStartTime()) / (1.0 * this.speed);
          double dur = (1.0 * transformation.getEndTime() - 1.0 * transformation.getStartTime()) 
              / (1.0 * this.speed);
          if (transformation.getShape().getType() == ShapeType.RECTANGLE) {
            transformationInfo = String.format("    <animate attributeName=\"x\" "
                + "attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"%f\" to=\"%f\" />\n"
                + "    <animate attributeName=\"y\" attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"%f\" to=\"%f\" />\n"
                + "    <animate attributeName=\"width\" attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"%f\" to=\"%f\" />\n"
                + "    <animate attributeName=\"height\" attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"%f\" to=\"%f\" />\n"
                + "    <animate attributeName=\"fill\" attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"rgb%s\" to=\"rgb%s\" />\n",
                begin, dur, 
                transformation.getStartPosition().getX(), 
                transformation.getEndPosition().getX(), 
                begin, dur, 
                transformation.getStartPosition().getY(), 
                transformation.getEndPosition().getY(), 
                begin, dur, 
                transformation.getStartDimension().getW(), 
                transformation.getEndDimension().getW(), 
                begin, dur, 
                transformation.getStartDimension().getH(), 
                transformation.getEndDimension().getH(), 
                begin, dur, 
                transformation.getStartColor().toString(), 
                transformation.getEndColor().toString()
                );
            text.append(transformationInfo);
          } else if (transformation.getShape().getType() == ShapeType.OVAL) {
            transformationInfo = String.format("    <animate attributeName=\"cx\""
                + " attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"%f\" to=\"%f\" />\n"
                + "    <animate attributeName=\"cy\" attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"%f\" to=\"%f\" />\n"
                + "    <animate attributeName=\"rx\" attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"%f\" to=\"%f\" />\n"
                + "    <animate attributeName=\"ry\" attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"%f\" to=\"%f\" />\n"
                + "    <animate attributeName=\"fill\" attributeType=\"XML\"\n"
                + "             begin=\"%fs\" dur=\"%fs\" "
                + "from=\"rgb%s\" to=\"rgb%s\" />\n",
                begin, dur, 
                transformation.getStartPosition().getX(), 
                transformation.getEndPosition().getX(), 
                begin, dur, 
                transformation.getStartPosition().getY(), 
                transformation.getEndPosition().getY(), 
                begin, dur, 
                transformation.getStartDimension().getW(), 
                transformation.getEndDimension().getW(), 
                begin, dur, 
                transformation.getStartDimension().getH(), 
                transformation.getEndDimension().getH(), 
                begin, dur, 
                transformation.getStartColor().toString(), 
                transformation.getEndColor().toString()
                );
            text.append(transformationInfo);
          } 
          
        }
        
        text.append(shapeType);
        text.append("\n");
      } 
    }
    
    text.append("</svg>");
    return text.toString();
  }

  /**
   * Set the canvas of animation.
   * @param canvas of animation
   */
  @Override
  public void setCanvas(Canvas canvas) {
    // Do nothing
  }


  /**
   * Add action listeners. This method is for inheritance purposes.
   * @param button button on edit view
   */
  @Override
  public void addListener(IViewButton button) {
    // Do nothing
  }

}
