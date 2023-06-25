import org.junit.Before;
import org.junit.Test;

import controller.IController;
import controller.TextViewController;

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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * This class tests the TextController class.
 */
public class TextControllerTest {

  private IController controller;
  Transformation transformationOval;
  Transformation transformationRectangle;

  
  @Before
  public void setup() {
    TextView view = new TextView(2);
    
    ModelImpl model = new ModelImpl();
    model.setCanvas(new Position2D(0, 0), new Dimension2D(360, 360));

    Dimension2D dimension1 = new Dimension2D(10, 20);
    Position2D position1 = new Position2D(0, 10);
    ColorRGB color1 = new ColorRGB(50, 60, 70);
    Oval oval = new Oval("O1", dimension1, position1, color1, ShapeType.OVAL, 10, 80);
    
    Dimension2D dimension2 = new Dimension2D(30, 20);
    Position2D position2 = new Position2D(30, 50);
    ColorRGB color2 = new ColorRGB(50, 160, 20);
    Rectangle rectangle = new Rectangle("O1", dimension2, position2, color2,
        ShapeType.RECTANGLE, 15, 70);
    
    Dimension2D dimension3 = new Dimension2D(30, 30);
    Position2D position3 = new Position2D(100, 150);
    ColorRGB color3 = new ColorRGB(200, 100, 80);
    
    transformationOval = new Transformation(oval, 20, 60, position1, position2, 
        dimension1, dimension3, color1, color1);
    transformationRectangle = new Transformation(rectangle, 30, 50, position2, position3, 
        dimension2, dimension2, color2, color3);
    
    model.addShape(oval);
    model.addShape(rectangle);
    model.addTransformation(transformationOval);
    model.addTransformation(transformationRectangle);

    controller = new TextViewController(model, view);
  }
  
  /**
   * Test the run method.
   */
  @Test
  public void runTest() {
    try {
      File output = new File("testOutput.txt");
      output.createNewFile();
      FileWriter writer = new FileWriter("testOutput.txt");
      controller.run(writer);
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    Path path1 = Paths.get("testOutput.txt");
    Path path2 = Paths.get("answer.txt");
    
    try {
      this.filesCompareByLine(path1, path2);
      assertEquals(-1, this.filesCompareByLine(path1, path2));
    } catch (IOException e) {
      
      e.printStackTrace();
    }
    
    
  }
  
  /**
   * This is a helper method to help compare two files.
   * @param path1 path of the first file
   * @param path2 path of the second file
   * @return the line number of different lines
   * @throws IOException when unable to read
   */
  public long filesCompareByLine(Path path1, Path path2) throws IOException {
    try (BufferedReader bf1 = Files.newBufferedReader(path1);
         BufferedReader bf2 = Files.newBufferedReader(path2)) {
        
      long lineNumber = 1;
      String line1 = "";
      String line2 = "";
      while ((line1 = bf1.readLine()) != null) {
        line2 = bf2.readLine();
        if (line2 == null || !line1.equals(line2)) {
          return lineNumber;
        }
        lineNumber++;
      }
      if (bf2.readLine() == null) {
        return -1;
      }
      else {
        return lineNumber;
      }
    }
  }

  
}

