package UI;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainProject.Lists;
import mainProject.Main;
import mainProject.Output;

public class UI extends Application {

    public static ArrayList<Integer> values = new ArrayList<>();
    public static int hafiza = 1;

    @Override
    public void start(Stage stage) {
        Text sen1 = new Text("Varsayýlan Seneryo");
        Text sen2 = new Text("Özel Seneryo");

        Button button1 = new Button("Play");
        Button button2 = new Button("Play");
        Button button3 = new Button("Settings");
        Button button4 = new Button("Maksimum Verim");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 150);
        gridPane.setVgap(20);
        gridPane.setHgap(50);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(sen1, 0, 1);
        gridPane.add(sen2, 1, 1);
        gridPane.add(button1, 0, 2);
        gridPane.add(button2, 1, 2);
        gridPane.add(button3, 1, 3);
        gridPane.add(button4, 0, 3);

        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button3.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        button4.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        sen1.setStyle("-fx-font: normal bold 20px 'serif' ");
        sen2.setStyle("-fx-font: normal bold 20px 'serif' ");
        gridPane.setStyle("-fx-background-color: BEIGE;");

        Scene scene = new Scene(gridPane);
        stage.setTitle("Esnaf Lokantasý");
        stage.setScene(scene);
        stage.show();

        button3.setOnAction(arg0 -> {
            Button3 go = new Button3(stage, scene);
        });

        button1.setOnAction(arg0 -> {
            Main.seneryo1();
            UIAction action = new UIAction(stage, scene);

        });
        button2.setOnAction(arg0 -> {
            Button2 go = new Button2(stage, scene);
        });
        button4.setOnAction(arg0 -> {
            Button4 go = new Button4(stage, scene);
        });

        stage.setOnCloseRequest(event -> {
            System.out.println("Sahne kapatýlýyor. Uygulama kapanabilir.");

            for (String step : Lists.StepList) {
                System.out.println(step);
            }
            Output.Output(Lists.StepList);
            System.exit(0);
        });
    }

    public static void main(String args[]) {
        launch(args);
    }

}
