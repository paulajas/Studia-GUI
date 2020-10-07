package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        stage.setTitle ( "Quadratic Equation" );
        GridPane gridpane = new GridPane ();

        Button solve = new Button ( "_Solve" );
        solve.setMaxWidth ( 300 );
        GridPane.setHalignment ( solve, HPos.CENTER );
        GridPane.setValignment ( solve, VPos.CENTER );
        solve.setMnemonicParsing ( true );

        Button clear = new Button ( "_Clear" );
        clear.setMaxWidth ( 300 );
        GridPane.setHalignment ( clear, HPos.CENTER );
        GridPane.setValignment ( clear, VPos.CENTER );
        clear.setMnemonicParsing ( true );

        Label label = new Label ( "" );
        label.setMaxWidth ( 300 );
        label.setAlignment ( Pos.CENTER );

        TextField a = new TextField ();
        a.setAlignment(Pos.CENTER);
        Tooltip aTool = new Tooltip ();
        aTool.setText ( "Enter a" );
        a.setTooltip ( aTool );

        TextField b = new TextField ();
        Tooltip bTool = new Tooltip ();
        bTool.setText ( "Enter b" );
        b.setTooltip ( bTool );
        b.setAlignment(Pos.CENTER);

        TextField c = new TextField ();
        Tooltip cTool = new Tooltip ();
        cTool.setText ( "Enter c" );
        c.setTooltip ( cTool );
        c.setAlignment(Pos.CENTER);

        gridpane.add ( label, 0, 0, 3, 1 );
        gridpane.add ( a, 0, 1, 1, 1 );
        gridpane.add ( b, 1, 1, 1, 1 );
        gridpane.add ( c, 2, 1, 1, 1 );
        gridpane.add ( solve, 0, 2, 3, 1 );
        gridpane.add ( clear, 0, 3, 3, 3 );

        clear.setOnAction ( (e) -> {
                a.clear ();
                b.clear ();
                c.clear ();
                label.setText ( "" );
                label.setStyle ( "-fx-background-color: none" );
            });


        solve.setOnAction ( (e) -> {
            try {
                double a1 = Double.parseDouble ( a.getText () );
                if (a1 == 0) {
                    label.setStyle ( "-fx-background-color: red" );
                    label.setStyle("-fx-text-fill: black");
                    label.setText ( "Not a quadratic equation!" );

                } else {
                    double b1 = Double.parseDouble ( b.getText () );
                    double c1 = Double.parseDouble ( c.getText () );
                    Mathematic eq = new Mathematic ( a1, b1, c1 );
                    label.setText ( eq.wyniki () );
                    label.setStyle("-fx-text-fill: blue");
                    label.setStyle ( "-fx-background-color: none" );
                }
            } catch (NumberFormatException exc) {
                label.setStyle ( "-fx-background-color: red" );
                label.setStyle("-fx-text-fill: black");
                label.setText ( "Wrong number!" );
            }
        } );
        Scene scene = new Scene ( gridpane, 300, 100 );
        stage.setScene ( scene );
        stage.show ();
        stage.setResizable ( false );
    }
    public static void main(String[] args) {
        launch(args);
    }
}
