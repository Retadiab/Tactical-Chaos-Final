package GUI;

import Arena.Arena;
import Arena.SquaresState;
;

import Champion.Champion;
import GameStore.Bench;
import GameStore.TemporalStoreFilter;
import Player.Player;
import Player.ConsolePlayer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;


public class GUIArena {

    ArrayList<Player> players = new ArrayList<>();
    Player currentPlayer = new ConsolePlayer();
    TemporalStoreFilter tempstore = new TemporalStoreFilter();

    int SIZE = 55;
    int length = 14;
    int width = SIZE;
    Button field[][] = new Button[length][width];
    Arena arena = new Arena();
    int BoughtChampPerRound =0;

    public void initGame()
    {
        //set arena size
        //init players
        //manage the rounds from here

    }
    public  void display(String title, String message) {
        Stage window = new Stage();
        ///////

        GridPane root = new GridPane();
        for(int y = 0; y < length; y++){
            for(int x = 0; x < width; x++){

                Random rand = new Random();
                int rand1 = rand.nextInt(2);

                // Create a new TextField in each Iteration
                field[y][x] = new Button();
                field[y][x].setPrefHeight(15);
                field[y][x].setPrefWidth(25);
                field[y][x].setAlignment(Pos.CENTER);


                for(Player p: players)
                {
                    for(Champion c: p.getArenaChampions())
                    {
                        if(c.y == y && c.x == x)
                             field[x][y].setText(c.championName);
                    }
                }

                root.setRowIndex(field[y][x],y);
                root.setColumnIndex(field[y][x],x);
                root.getChildren().add(field[y][x]);
            }
        }

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        //label.setBackground();
        Button BenchButton = new Button("Bench");
        HBox Bench = new HBox();
        Bench.getChildren().add(label);
        Bench.setAlignment(Pos.CENTER);
        for(Champion champ : currentPlayer.getBenchChampions())
        {
            Button championbench= new Button();
            championbench.setOnAction(e->
            {
                for(int i=0; i<length ; i++)
                {
                    for(int j=0; j<width ; j++)
                    {
                        int finalI = i;
                        int finalJ = j;
                        field[i][j].setOnAction(e1->
                        {

                            champ.x = finalI; champ.y = finalJ;

                            arena.getSquare(finalI, finalJ).setState(SquaresState.Occupied);
                            currentPlayer.getArenaChampions().add(champ);
                            currentPlayer.getBenchChampions().remove(champ);
                            // note: the previous line may cause an error because you're deleting inside the loop
                            //if it caused an error, store the champion you want to remove from the list and call the function
                            // when the loop has finished (outside the loop)
                        });
                    }
                }

            });
            Bench.getChildren().add((championbench));
        }



        Button TemporalStoreButton = new Button("Temporal Store");
        HBox TemporalStore = new HBox();
        TemporalStore.getChildren().add(label);
        TemporalStore.setAlignment(Pos.CENTER);

        for(Champion champ : tempstore.GetOnlyForGUI())
        {
            Button champtobuy = new Button(champ.championName);
            champtobuy.setOnAction(e->
            {
                if(BoughtChampPerRound< 3 )
                    // add a condition to determine if you're in the first nine round

                {
                    BoughtChampPerRound++; //You should reset this counter when the turn changes
                    currentPlayer.getBenchChampions().add(champ);
                    Bench.getChildren().add(new Button(champ.championName));
                }

            });
            TemporalStore.getChildren().add(champtobuy);

        }


        Button TiersButton= new Button("Tiers");
        HBox Tiers = new HBox();
        Tiers.getChildren().add(label);
        Tiers.setAlignment(Pos.CENTER);
        for (int i = 0; i < 16; i++)
        {
            Tiers.getChildren().add(new Button("Champion "
                    + (int)(i + 1)));
        }

        VBox layout = new VBox(10);
        layout.setMargin(root, new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(label,root,BenchButton,Bench,TemporalStoreButton,TemporalStore,TiersButton,Tiers);

        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        scene.setFill(Color.TRANSPARENT);
        window.setScene(scene);
        window.showAndWait();
    }


}



