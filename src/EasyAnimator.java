import controller.ControllerFactory;
import controller.IController;
import model.IModel;
import model.IShape;
import model.ModelImpl;
import util.AnimationReader;
import view.IView;
import view.ViewFactory;

import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Run an animation interactively on the console.
 */
public final class EasyAnimator {
  /**
   * Run an animation.
   */
  public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame();
    
    boolean expectInputFile = false;
    boolean expectView = false;
    boolean expectOutputFile = false;
    boolean expectSpeed = false;
    
    String inputFile = "";
    String viewType = "";
    String outputFile = "";
    int speed = 1;
    
    for (String arg : args) {
      if (arg.equals("-in")) {
        expectInputFile = true;
      } else if (arg.equals("-view")) {
        expectView = true;
      } else if (arg.equals("-out")) {
        expectOutputFile = true;
      } else if (arg.equals("-speed")) {
        expectSpeed = true;
      } 
      else if (expectInputFile) {
        inputFile = arg;
        expectInputFile = false;
      } else if (expectView) {
        viewType = arg;
        expectView = false;
      } else if (expectOutputFile) {
        outputFile = arg;
        expectOutputFile = false;
      } else if (expectSpeed) {
        try {
          speed = Integer.parseInt(arg);
        } catch (Exception e) {
          throw new IllegalArgumentException("Speed must be integer.");
        }
        if (speed <= 0) {
          throw new IllegalArgumentException("Speed must be positive.");
        }
        expectSpeed = false;
      }
    }
    
    display(frame, inputFile, viewType, outputFile, speed);
    
    
  }
  
  /**
   * Display the animation with given input.
   * @param frame given Jframe
   * @param inputFile input file
   * @param viewType given type of view
   * @param outputFile output file
   * @param speed speed of animation
   * @throws IOException when encounter exception when output files
   */
  public static void display(Frame frame, String inputFile,
                      String viewType, String outputFile,
                      int speed) throws IOException {
    AnimationReader reader = new AnimationReader();
    IModel model = null;
    try {
      // read file
      InputStream inputStream = new FileInputStream(inputFile);
      // populate model
      model = AnimationReader.parseFile(new InputStreamReader(inputStream),
              new ModelImpl.Builder());
      for (Integer key : model.getShapeMap().keySet()) {
        for (IShape shape : model.getShapeMap().get(key)) {
          
          if (shape.getName().equals("B0")) {
            //System.out.println(shape.getName());
            //System.out.println(shape.getDisappearTime());
            //System.out.println(model.getTransformationMap().get("B0").size());
          }
        }
      }
      
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(frame,
              "FileNotFoundException: Could not find file",
              "Error", JOptionPane.ERROR_MESSAGE);
    }

    IView view = ViewFactory.makeView(viewType, speed);
    IController controller = ControllerFactory.makeController(viewType, model, view);
    // no output file, print to console
    if (outputFile.length() == 0) {
      controller.run(System.out);
    } else {
      try {
        File output = new File(outputFile);
        output.createNewFile();
        FileWriter writer = new FileWriter(outputFile);
        controller.run(writer);
        writer.flush();
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
}
