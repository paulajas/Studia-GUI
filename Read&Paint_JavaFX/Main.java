package sample2;

import javafx.application.Application;	// Application
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;					// Stage
import javafx.scene.layout.*;			// Pane, GridPane
import javafx.scene.shape.*;			// Circle, Rectangle
import javafx.geometry.*;				// Pos

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void init() {
        System.out.println("init: " + Thread.currentThread().getName());
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();

        ArrayList<Integer> lineList = new ArrayList<Integer> ();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter ("Text Files", "*.txt", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(null);
        try {
            BufferedReader reader = new BufferedReader ( new FileReader ( selectedFile ) );
            Scanner scanner = new Scanner ( reader );
            while (scanner.hasNext ()) {
                //wait(100);
                int r = (int) (Math.random () * 255);
                int g = (int) (Math.random () * 255);
                int b = (int) (Math.random () * 255);
                String line = scanner.nextLine ();
                Scanner sc = new Scanner ( line );
                while(sc.hasNextInt()) {
                    //wait(100);
                    lineList.add(sc.nextInt());
                }
                if (lineList.size () == 4) {
                    Rectangle rectangle = new Rectangle ( (int) lineList.get ( 0 ), (int) lineList.get ( 1 ), (int) lineList.get ( 2 ), (int) lineList.get ( 3 ) );
                    rectangle.setFill ( Color.rgb ( r, g, b ) );
                    rectangle.setStroke ( Color.rgb ( r, g, b ) );
                    root.getChildren ().add ( rectangle );
                    System.out.println ( lineList );
                } else if (lineList.size () == 3) {
                    Circle circle = new Circle ( (int) lineList.get ( 0 ), (int) lineList.get ( 1 ), (int) lineList.get ( 2 ), Color.TRANSPARENT );
                    circle.setFill ( Color.rgb ( r, g, b ) );
                    circle.setStroke ( Color.rgb ( r, g, b ) );
                    root.getChildren ().add ( circle );
                }
                lineList.clear ();
            }
        }catch (IOException e){
            e.printStackTrace ();
        }
        Scene sc = new Scene(root,500,500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Zadanie ostatnie");
        primaryStage.show();
}

    @Override
    public void stop() {
        System.out.println("stop: " + Thread.currentThread().getName());
    }

}
