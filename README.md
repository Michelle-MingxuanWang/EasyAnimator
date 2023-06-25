# EasyAnimator

Easy Animator Design  

The animator is an application that can create animation of given descriptions. The application is built using a model-view-controller pattern.  


# Model

The model consists of models, transformations, shapes, and other helper vectors and builders.  

## Models
In the model part, it contains the class ModelImpl and its interface IModel.  
The interface IModel defines the way to add shape, add transformation, and get shape at the given time to run the animation.  
In the ModelImpl, it stores the shapes and transformations in hash maps. The key for shapes is their appear time in the animation, and the key for transformations is the name of the shape that presents the transformation. In this way, we can conveniently add and output shapes and transformations to build the animation.  

## Transformations
The Transformation class represents a transformation in one shape in the animation. Each time a transformation is performed, the shapeAtCurTime() method can be used to output a shape object at given time to draw the animation.  

## Shapes
In this project, we consider two kinds of shapes: oval and rectangle. Therefore, I used a GenericShape class to build an abstract class for these two shape classes (Oval and Rectangle) and created an interface IShape to define the methods.  
EmptyShape is created as a placeholder for the shapes with only information of name and type.  

## Helper classes
ColorRGB, Dimension2D, Position2D are built to represent the color, dimension, and position vectors.  
ShapeType is built to represent the enum of types of shapes.  
ShapeBuilder is a class with the static method buildShape() to generate shapes according to their type.   

# View
There are four kinds of views: SVG, text, visual, and edit. So, I created an interface IView to define the view methods. Moreover, I created a ViewFactory to make views according to the view type.  
## SVG View: 
output the animation in svg file.  
## Text View:
output the animation in txt file.  
## Visual View:
Create a panel and display the animations with given configuration parameters.  
To draw the component and print the panel in the visual and editor view, I created a DrawPanel class.   
## Edit View:
Create a panel and display the animations, and allow interactions with the users.  
An interface IViewButton is created to make the edit view controller implements this interface and control the timer when the user clicks buttons.  

# Controller
Since there are four kinds of views, we need four controllers. So, I created an interface IController to define the controller methods. Moreover, I created a ControllerFactory to make controllers according to the controller type.  

# Test
Tests are written separately for model, view, and controllers.   
For the model part, we have tests for ModelImpl, Transformation, Shape, ShapeBuilder, Position2D, Dimension2D, ColorRGB.  
For the view part, we have tests for SVG and text view. Moreover, we have tests for ViewFactory.  
For the controller part, we have tests for the SVG controller and text controller.   
