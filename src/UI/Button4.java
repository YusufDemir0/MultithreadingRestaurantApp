/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainProject.Formula;
import mainProject.Lists;
import mainProject.Main;
import mainProject.Output;

/**
 *
 * @author yusuf
 */
public class Button4 {

    public String hafiza = "Sabit";
    public boolean sabit = true;

    public Button4(Stage stage, Scene scene) {

        Spinner<Integer> spinner1 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);

        ToggleButton toggleButton = new ToggleButton(hafiza);

        Text text1 = new Text("Müþteri Sayýsý");

        GridPane pane = new GridPane();
        pane.add(spinner1, 1, 0);
        pane.add(text1, 0, 0);

        Spinner<Integer> spinner2 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);

        Text text2 = new Text("Toplam Süre");

        pane.add(spinner2, 1, 1);
        pane.add(text2, 0, 1);

        pane.add(toggleButton, 1, 8);

        Scene settings = new Scene(pane, 300, 200);
        stage.setScene(settings);
        stage.setTitle("Ýdeal Kazanç");

        // ToggleButton durumu deðiþtiðinde bu olay dinleyici çalýþýr
        toggleButton.setOnAction(e -> {
            if (toggleButton.isSelected()) {
                hafiza = "Sabit";
                sabit = true;
                toggleButton.setText(hafiza);
            } else {
                hafiza = "Dinamik";
                sabit = false;
                toggleButton.setText(hafiza);
            }
            System.out.println("Müþteri Rotasyon Biçimi: " + hafiza);
        });

        Button onayla = new Button("Onayla");
        onayla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg1) {
                pane.getChildren().removeIf(node -> node instanceof Text);
                System.out.println(spinner2.getValue());
                ArrayList<Integer> liste = Formula.Formul(spinner1.getValue(), sabit, spinner2.getValue());
                int a = liste.get(0);
                int b = liste.get(1);
                int c = liste.get(2);
                int d = liste.get(3);
                int e = liste.get(4);
                int f = liste.get(5);
                int g = liste.get(6);
                Text text2 = new Text("Müþteri Sayýsý:  " + g);
                Text text3 = new Text("Masa Sayýsý:  " + b);
                Text text4 = new Text("Garson Sayýsý:  " + c);
                Text text5 = new Text("Þef Sayýsý:  " + d);
                Text text6 = new Text("Kasa Sayýsý:  " + e);
                Text text7 = new Text("Ýdeal Kazanç:  " + f);
                pane.add(text2, 0, 2);
                pane.add(text3, 0, 3);
                pane.add(text4, 0, 4);
                pane.add(text5, 0, 5);
                pane.add(text6, 0, 6);
                pane.add(text7, 0, 7);
                Button devam = new Button("Devam");
                pane.add(devam, 2, 8);
                devam.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent arg1) {
                        System.out.println("a=" + a);
                        System.out.println("musteri=" + spinner1.getValue());
                        Main.custom(b, d, e, g, c, 0);

                        UIAction action = new UIAction(stage, scene);
                    }
                });
            }
        });

        pane.add(onayla, 0, 8);

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
