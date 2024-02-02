/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import static UI.UI.hafiza;
import static UI.UI.values;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainProject.Lists;
import mainProject.Main;
import mainProject.Output;

/**
 *
 * @author yusuf
 */
public class Button2 {
    public Button2(Stage stage,Scene scene){

            Spinner<Integer> spinner1 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
            Spinner<Integer> spinner2 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
            Spinner<Integer> spinner3 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
            Spinner<Integer> spinner4 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
            Spinner<Integer> spinner5 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
            Spinner<Integer> spinner6 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);

            Text text1 = new Text("Masa Sayýsý");
            Text text2 = new Text("Þef Sayýsý");
            Text text3 = new Text("Kasa Sayýsý");
            Text text4 = new Text("Müþteri Sayýsý");
            Text text5 = new Text("Garson Sayýsý");
            Text text6 = new Text("Özel Müþteri Sayýsý");

            GridPane pane = new GridPane();
            pane.add(spinner1, 1, 0);
            pane.add(spinner2, 1, 1);
            pane.add(spinner3, 1, 2);
            pane.add(spinner4, 1, 3);
            pane.add(spinner5, 1, 4);
            pane.add(spinner6, 1, 5);
            pane.add(text1, 0, 0);
            pane.add(text2, 0, 1);
            pane.add(text3, 0, 2);
            pane.add(text4, 0, 3);
            pane.add(text5, 0, 4);
            pane.add(text6, 0, 5);

            Scene settings = new Scene(pane, 300, 200);
            stage.setScene(settings);
            stage.setTitle("Özel Seneryo");

            Button onayla = new Button("Onayla");
            onayla.setOnAction(arg1 -> {
                int a = spinner1.getValue();
                int b = spinner2.getValue();
                int c = spinner3.getValue();
                int d = spinner4.getValue();
                int e = spinner5.getValue();
                int f = spinner6.getValue();
                Main.custom(a,b,c,d,e,f);
                UIAction action = new UIAction(stage, scene);
            });

            pane.add(onayla, 0, 7);

            stage.setOnCloseRequest(event -> {
                stage.setScene(scene);

                for (String step : Lists.StepList) {
                    System.out.println(step);
                }
                Output.Output(Lists.StepList);
                System.exit(0);
            });

        }
    
}
