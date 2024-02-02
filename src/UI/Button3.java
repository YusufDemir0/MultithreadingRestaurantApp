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
import mainProject.Main;

/**
 *
 * @author yusuf
 */
public class Button3 {

    public Button3(Stage stage, Scene scene) {

        Spinner<Integer> spinner1 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
        Spinner<Integer> spinner2 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
        Spinner<Integer> spinner3 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
        Spinner<Integer> spinner4 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
        Spinner<Integer> spinner5 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);
        Spinner<Integer> spinner6 = new Spinner<>(0, Integer.MAX_VALUE, 0, 1);

        ToggleButton toggleButton = new ToggleButton(hafiza + "");

        // ToggleButton durumu deðiþtiðinde bu olay dinleyici çalýþýr
        toggleButton.setOnAction(e -> {
            if (toggleButton.isSelected()) {
                hafiza = 1;
                toggleButton.setText(hafiza + "");
            } else {
                hafiza = 2;
                toggleButton.setText(hafiza + "");
            }
            System.out.println("Hafýza: " + hafiza);
        });

        Text text1 = new Text("Müþteri Bekleme Süresi");
        Text text2 = new Text("Garson Sipariþ Alma Süresi");
        Text text3 = new Text("Þef Sipariþ Hazýrlama Süresi");
        Text text4 = new Text("Kasa Ödeme Alma Süresi");
        Text text5 = new Text("Gruplar Arasý Süre");
        Text text6 = new Text("Grup Kiþi Sayýsý");
        Text text7 = new Text("Þef Piþirme Sayýsý");

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
        pane.add(text7, 0, 6);
        pane.add(toggleButton, 1, 6);

        Scene settings = new Scene(pane, 300, 200);
        stage.setScene(settings);
        stage.setTitle("Ayarlar");

        Button onayla = new Button("Onayla");
        onayla.setOnAction(arg1 -> {
            values.add(spinner1.getValue());
            values.add(spinner2.getValue());
            values.add(spinner3.getValue());
            values.add(spinner4.getValue());
            values.add(spinner5.getValue());
            values.add(spinner6.getValue());
            /*for (int i = 0; i < values.size(); i++) {
                    System.out.println(values.get(i));
                }*/
            if (values.get(0) > 0) {
                Main.musterisn = values.get(0);
            }
            if (values.get(1) > 0) {
                Main.garsonsn = values.get(1);
            }
            if (values.get(2) > 0) {
                Main.sefsn = values.get(2);
            }
            if (values.get(3) > 0) {
                Main.kasasn = values.get(3);
            }
            if (values.get(4) > 0) {
                Main.dalgasn = values.get(4);
            }
            if (values.get(5) > 0) {
                Main.dalgasay = values.get(5);
            }
            Main.sefpisir = hafiza;
            stage.setScene(scene);
        });

        pane.add(onayla, 0, 7);

        stage.setOnCloseRequest(event -> stage.setScene(scene));
    }

}
