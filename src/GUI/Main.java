package GUI;

import Player.Player;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.ArrayList;


public class Main  extends  Application{
    public static void main(String[] args) {
        launch(args);
    }

    Stage window;
    Scene scene1,scene2;
    int numberoplayers=0;
    GUIArena guiArena = new GUIArena();
    @Override
    public void start(Stage stage) {
        window = stage;
        window.setTitle("Tactical Chaos");
        //////////////////making the grid pane and in it there will be the buttons we want
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        /////////////////start game button to take us to a new window with the game in it
        Button arena = new Button("Start Game");
        GridPane.setConstraints(arena,1,3);
        arena.setOnAction(e -> guiArena.display("Title of Window", "Welcome to Tactical Chaos"));
        ///////////entering number of player
        TextField PlayersNumber1 = new TextField();
        PlayersNumber1.setPromptText("Number of players");
        GridPane.setConstraints(PlayersNumber1, 1, 2);
        Button PlayersNumber = new Button("Enter");
        GridPane.setConstraints(PlayersNumber,2,2);


        PlayersNumber.setOnAction(e->
        {

            numberoplayers=Integer.valueOf(PlayersNumber1.getText());
            System.out.println(numberoplayers);
        });

//        x=PlayersNumber1.getText();
//        System.out.println(x);

//        System.out

        grid.getChildren().addAll(arena,PlayersNumber1,PlayersNumber);
        Scene scene = new Scene(grid, 300, 250);
        window.setScene(scene);
        window.show();

    }
}