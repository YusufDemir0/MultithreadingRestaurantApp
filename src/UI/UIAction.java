/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import mainProject.Lists;
import mainProject.Output;

/**
 *
 * @author yusuf
 */
public final class UIAction {

    public Timeline timeline;
    public Timeline timeline1;

    public UIAction(Stage stage, Scene scene) {

        GridPane newpane = new GridPane();
        newpane.setVgap(20);
        newpane.setHgap(20);
        Scene goster = new Scene(newpane);
        stage.setTitle("Esnaf Lokantasý");
        stage.setScene(goster);
        stage.show();
        Text musteri = new Text(Lists.kisisayList.size() + " Müþteri Kaldý");
        Text info1 = new Text("Mavi: Yeni Oturdum");
        Text info2 = new Text("Mor: Sipariþ Verdim");
        Text info3 = new Text("Turuncu: Yemeði Yedim");
        Text info4 = new Text("Kýrmýzý: Hesap Bekliyorum");
        Text info5 = new Text("Yeþil: Boþ Masa");
        /*for (int i = 0; i < Main.musterisay + Main.ozelmusterisay; i++) {
                musteri.setText(Lists.kisisayList.size() + "");
                
            }*/
        int satir = -1;
        ArrayList<Button> tuslar = new ArrayList<>();
        System.out.println(Lists.Desks.size());

        int maxsutun = (int) Math.sqrt(Lists.Desks.size());
        newpane.add(musteri, 0, 1 + (int) Math.ceil((double) Lists.Desks.size() / (double) maxsutun));
        newpane.add(info1, 0, 2 + (int) Math.ceil((double) Lists.Desks.size() / (double) maxsutun));
        newpane.add(info2, 0, 3 + (int) Math.ceil((double) Lists.Desks.size() / (double) maxsutun));
        newpane.add(info3, 0, 4 + (int) Math.ceil((double) Lists.Desks.size() / (double) maxsutun));
        newpane.add(info4, 0, 5 + (int) Math.ceil((double) Lists.Desks.size() / (double) maxsutun));
        newpane.add(info5, 0, 6 + (int) Math.ceil((double) Lists.Desks.size() / (double) maxsutun));
        for (int i = 0; i < Lists.Desks.size(); i++) {
            if (i % maxsutun == 0) {
                satir++;
            }
            Button masa = new Button("\tMasa" + i + "\t\t");
            masa.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
            tuslar.add(masa);
            newpane.add(tuslar.get(i), i % maxsutun, satir);
        }

        startContinuousUpdate(musteri);
        startContinuousUpdateDesks(tuslar);

        stage.setOnCloseRequest(event
                -> {
            stage.setScene(scene);

            for (String step : Lists.StepList) {
                System.out.println(step);
            }
            Output.Output(Lists.StepList);
            System.exit(0);
        }
        );

    }

    public int startContinuousUpdate(Text musteri) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.001), event -> {
            musteri.setText(String.valueOf(Lists.kisisayList.size()) + " Müþteri Kaldý");
            if (Lists.kisisayList.size() < 1) {
                System.out.println("musteri güncelleme bitti");
                stopTimeLine(timeline);
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        return 0;
    }

    public int startContinuousUpdateDesks(ArrayList<Button> tuslar) {
        // Her bir saniyede bir güncelleme yapacak bir Timeline oluþtur

        timeline1 = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            // Güncelleme iþlemi burada yapýlýr
            String tut = 999 + "";
            ArrayList<String> skip = new ArrayList<>();
            for (int i = 0; i < Lists.Desks.size(); i++) {
                if (skip.contains(Lists.Desks.get(i))) {
                    continue;
                }
                if (!Lists.Desks.get(i).equals(999 + "")) {
                    tut = Lists.Desks.get(i);
                    tuslar.get(i).setText(tut + "numaralý müþteri");
                    tuslar.get(i).setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

                    for (int j = 0; j < Lists.AllWaiterList.size(); j++) {
                        if (tut == null ? Lists.AllWaiterList.get(j) == null : tut.equals(Lists.AllWaiterList.get(j)) && !Lists.AllWaiterList.get(j).equals(999 + "")) {
                            tuslar.get(i).setStyle("-fx-background-color: blue; -fx-text-fill: white;");
                            break;
                        }
                    }

                    for (int j = 0; j < Lists.AllChefList.size(); j++) {
                        if (tut == null ? Lists.AllChefList.get(j) == null : tut.equals(Lists.AllChefList.get(j)) && !Lists.AllChefList.get(j).equals(999 + "")) {
                            tuslar.get(i).setStyle("-fx-background-color: purple; -fx-text-fill: white;");
                            break;
                        }
                    }

                    for (int j = 0; j < Lists.AllEatingList.size(); j++) {
                        if (tut == null ? Lists.AllEatingList.get(j) == null : tut.equals(Lists.AllEatingList.get(j)) && !Lists.AllEatingList.get(j).equals(999 + "")) {
                            tuslar.get(i).setStyle("-fx-background-color: orange; -fx-text-fill: white;");
                            break;
                        }
                    }
                    for (int j = 0; j < Lists.AllCheckOutList.size(); j++) {
                        if (tut == null ? Lists.AllCheckOutList.get(j) == null : tut.equals(Lists.AllCheckOutList.get(j)) && !Lists.AllCheckOutList.get(j).equals(999 + "")) {
                            tuslar.get(i).setStyle("-fx-background-color: red; -fx-text-fill: white;");
                            break;
                        }
                    }
                } else {
                    tuslar.get(i).setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    tuslar.get(i).setText("\tMasa" + i + "\t\t");
                }
            }
            if (Lists.kisisayList.size() < 0) {
                System.out.println("button güncelleme bitti");
                stopTimeLine(timeline1);
            }

        }));

        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();

        return 0;

    }

    private void stopTimeLine(Timeline timeline) {

        timeline.stop();
    }
}
