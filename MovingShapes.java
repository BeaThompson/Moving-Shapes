import java.util.*;
import java.awt.*;

public class MovingShapes {
             static Scanner s = new Scanner(System.in);
             static int numShapes;
             static String arrShapes[] = new String[20];
             static int[] shapeSize = new int[20];
             static String[] arrayColor = new String[20];
             static int[] direction = new int[20];
             static int[] speed = new int[20];
             static int[] topLeftX = new int[20];
             static int[] topLeftY = new int[20];
             static int width;
             static int height;
             static int numMove;
             //All are Global variables and arrays that will be used for each shape
             //Each shape will have a specific index that will reference in all the arrays


              public static void main (String[] args) { // main method
                            System.out.println("UTSA - Spring 2022 - CS1083 - Project 3 - written by Brayden Thompson");
                            System.out.print("Please input width, height of the panel, # of shapes, # of times to move followed by the shape, size, color, orientation, and speed of every shape:");
                            width = s.nextInt();
                            height = s.nextInt(); // width and height taken
                            numShapes = s.nextInt();
                            numMove = s.nextInt();
                            getShapeInformation(numShapes); // getting nesessary info on all shapes
                            DrawingPanel panel = new DrawingPanel(width, height);
                            intitialPosition(panel); //declaring the opanel and drawing shapes
                            showShapesMoving(panel); // moving shapes
                            
                            
              }
              public static void getShapeInformation(int x) { //necessary info
                            int i;
                            for (i = 0; i < x; ++i) {
                                          arrShapes[i] = s.next();
                                          shapeSize[i] = s.nextInt();
                                          arrayColor[i] = s.next();
                                          direction[i] = s.nextInt();
                                          speed[i] = s.nextInt();
                                          

                            }
              }
              public static void intitialPosition(DrawingPanel x) { // where shapes start
                            int i;
                            for (i = 0; i < numShapes; ++i) {
                                     topLeftX[i] = (width / 2) - (shapeSize[i] /2);
                                     topLeftY[i] = (height / 2) - (shapeSize[i] /2);
                            }
                            showShapes(x, true);
                            x.sleep(100);


              }
              public static void showShapesMoving(DrawingPanel x) { //shapes will move
                            int i;
                            for (i = 0; i < numMove; ++i) {
                                          showShapes(x, false);
                                          changePositions();
                                          showShapes(x, true);
                                          x.sleep(100);
                            }
                            
              }
              public static void changePositions() { // new positions of shapes based on speed
                            int index;
                            for (index = 0; index < numShapes; ++index){
                                          if (direction[index] == 0){
                                                        topLeftX[index] -= speed[index];
                                          }else if (direction[index] == 1) {
                                                        topLeftX[index] -= speed[index];
                                                        topLeftY[index] -= speed[index];
                                          } else if (direction[index] == 2) {
                                                        topLeftY[index] -= speed[index];
                                          } else if (direction[index] == 3) {
                                                        topLeftY[index] -= speed[index];
                                                        topLeftX[index] += speed[index];
                                          } else if (direction[index] == 4){
                                                        topLeftX[index] += speed[index];
                                          }else if (direction[index] == 5){
                                                        topLeftX[index] += speed[index];
                                                        topLeftY[index] += speed[index];
                                          } else if (direction[index] == 6) {
                                                        topLeftY[index] += speed[index];
                                          } else if (direction[index] == 7) {
                                                        topLeftX[index] -= speed[index];
                                                        topLeftY[index] += speed[index];
                                          }
                                          

                            }
              }
              public static void showShapes(DrawingPanel x, boolean valid) { //decalres shapes
                            int i;
                            for (i = 0; i < numShapes; ++i) {
                                          if (valid) {
                                                        graphicsSetColor(x, i);
                                          } else {
                                                        setNoColor(x);
                                          }
                                          if (arrShapes[i].equals("Square")) {
                                                        showSquare(x, i, valid);
                                          } else {
                                                        showCircle(x, i, valid);
                                          }
                            }
              }
              public static void showSquare(DrawingPanel x, int index, boolean valid) { //draws square
                            Graphics g = x.getGraphics();
                             
                            g.fillRect(topLeftX[index], topLeftY[index], shapeSize[index], shapeSize[index]);
                            if (valid){
                                          g.setColor(Color.BLACK);
                            }
                            g.drawRect(topLeftX[index], topLeftY[index], shapeSize[index], shapeSize[index]);
              }
              public static void showCircle(DrawingPanel x, int index, boolean valid) { //draw circle
                            Graphics g = x.getGraphics();
                            g.fillOval(topLeftX[index], topLeftY[index], shapeSize[index], shapeSize[index]);
                            if (valid){
                                          g.setColor(Color.BLACK);
                            }
                            g.drawOval(topLeftX[index], topLeftY[index], shapeSize[index], shapeSize[index]);
              }
              public static void setNoColor(DrawingPanel x) { // Set color to white
                            Graphics g = x.getGraphics();
                            g.setColor(Color.WHITE);
              }
              public static void graphicsSetColor(DrawingPanel x, int index) { // seting color based on array
                            Graphics g = x.getGraphics();
                            switch (arrayColor[index]) { // tried swithc didnt work for some reason
                                          case "Red":
                                                        g.setColor(Color.RED);
                                                        break;
                                          case "Blue":
                                                        g.setColor(Color.BLUE);
                                                        break;
                                          case "Pink":
                                                        g.setColor(Color.PINK);
                                                        break;
                                          case "Yellow":
                                                        g.setColor(Color.YELLOW);
                                                        break;
                                          case "Green":
                                                        g.setColor(Color.GREEN);
                                                        break;
                                          case "Magenta":
                                                        g.setColor(Color.MAGENTA);
                                                        break;
                                          case "Orange":
                                                        g.setColor(Color.ORANGE);
                                                        break;
                                          case "Dark_gray":
                                                        g.setColor(Color.DARK_GRAY);
                                                        break;
                                          case "Light_gray":
                                                        g.setColor(Color.LIGHT_GRAY);
                                                        break;
                                          case "Gray":
                                                        g.setColor(Color.GRAY);
                                                        break;
                            }
              }

              
}