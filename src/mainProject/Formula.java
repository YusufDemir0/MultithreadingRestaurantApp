/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainProject;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author yusuf
 */
public class Formula {

    public static ArrayList<Integer> DalgaList = new ArrayList<>();
    public static ArrayList<Integer> DalgaSure = new ArrayList<>();

    public void Formula() {
    }

    public static ArrayList Formul(int kisitotal, boolean sabit, int suretotal) {

        if (sabit) {
            return sabitformul(kisitotal, suretotal);
        } else {
            return dinamikformul(kisitotal, suretotal);
        }

    }

    public static ArrayList sabitformul(int kisitotal, int suretotal) {

        int tur = Main.kasasn + Main.garsonsn + Main.sefsn + Main.yemeksn;

        ArrayList<Integer> MaliyetList = new ArrayList<>();
        int kalankisi;
        int kacankisi;
        int kazanc;
        int maxsure = suretotal;
        int dalgasn = Main.dalgasn;
        double idealmasa;
        double idealgarson;
        double idealsef;
        double idealkasa;
        int dalgaboyu = Main.dalgasay;
        int parca = (int) Math.ceil((double) maxsure / (double) dalgasn);
        int maxkisi = parca * dalgaboyu;
        int masasay = dalgaboyu * (int) (Math.ceil((double) tur / (double) dalgasn));
        if (maxkisi < kisitotal) {
            kacankisi = kisitotal - maxkisi;
            kalankisi = maxkisi;
        } else {
            kacankisi = 0;
            kalankisi = kisitotal;
        }
        int masatur = (int) Math.ceil((double) Main.musterisn / (double) tur);
        double idealmasatest = Math.ceil((double) kalankisi / (double) masatur);
        if (idealmasatest > masasay) {
            idealmasa = masasay;
        } else {
            idealmasa = idealmasatest;
        }
        idealgarson = Math.ceil((double) idealmasa / (double) ((double) tur / (double) Main.garsonsn));
        idealsef = Math.ceil((double) idealmasa / (double) ((double) tur / (double) ((double) Main.sefsn / (double) Main.sefpisir)));
        idealkasa = Math.ceil((double) idealmasa / (double) ((double) tur / (double) Main.kasasn));
        kazanc = (int) (kalankisi - idealmasa - idealgarson - idealsef);
        double idealmasa1;
        for (int i = kalankisi; i > 0; i--) {
            double idealmasatest1 = Math.ceil((double) i / (double) masatur);
            if (idealmasatest1 > masasay) {
                idealmasa1 = masasay;
            } else {
                idealmasa1 = idealmasatest1;
            }

            double idealgarson1 = Math.ceil((double) idealmasa1 / (double) ((double) tur / (double) Main.garsonsn));
            double idealsef1 = Math.ceil((double) idealmasa1 / (double) ((double) tur / (double) ((double) Main.sefsn / (double) Main.sefpisir)));
            double idealkasa1 = Math.ceil((double) idealmasa1 / (double) ((double) tur / (double) Main.kasasn));
            double kazanc1 = (int) (i - idealmasa1 - idealgarson1 - idealsef1);

            if (kazanc1 > kazanc) {
                idealgarson = idealgarson1;
                idealmasa = idealmasa1;
                idealkasa = idealkasa1;
                idealsef = idealsef1;
                kazanc = (int) kazanc1;
                kalankisi = i;

            }

        }
        MaliyetList.add(kisitotal);
        MaliyetList.add((int) idealmasa);
        MaliyetList.add((int) idealgarson);
        MaliyetList.add((int) idealsef);
        MaliyetList.add((int) idealkasa);
        MaliyetList.add(kazanc);
        MaliyetList.add(kalankisi);
        MaliyetList.add(kacankisi);
        return MaliyetList;

    }

    public static ArrayList dinamikformul(int kisitotal, int suretotal) {
        Random random1 = new Random();
        Random random2 = new Random();

        double tur = Main.kasasn + Main.garsonsn + Main.sefsn;

        double masatur = Math.ceil((double) (Main.musterisn) / (double) tur);
        ArrayList<Integer> MaliyetList = new ArrayList<>();
        int kalankisi;
        int kacankisi;
        int kalankisi1;
        int kacankisi1;
        int kazanc;
        double idealmasa;
        double idealgarson;
        double idealsef;
        double idealkasa;
        int kazanc1;
        double idealmasa1;
        double idealgarson1;
        double idealsef1;
        double idealkasa1;
        int kisisinir = 15;
        int kisiomur = Main.musterisn;
        int sure = 0;

        int mevcutkisi = 0;
        while (mevcutkisi < kisitotal) {
            int eklekisi = random1.nextInt(kisisinir);
            if (mevcutkisi + eklekisi > kisitotal) {
                eklekisi = suretotal - mevcutkisi;
            }
            DalgaList.add(eklekisi);
            mevcutkisi += eklekisi;
        }
        int i = 0;
        while (DalgaList.size() > i && suretotal>0) {
            i++;
            int eklesure = random2.nextInt((int) Math.ceil((double) suretotal / (double) DalgaList.size()));
            if (sure + eklesure > suretotal) {
                eklesure = suretotal - sure;
            }
            DalgaSure.add(eklesure);
            sure += eklesure;
        }
        if (sure < suretotal && !DalgaSure.isEmpty()) {
            DalgaSure.set(DalgaSure.size() - 1, DalgaSure.getLast() + suretotal - sure);
        }

        int parca = (int) Math.ceil((double) suretotal / (double) Math.ceil((double) suretotal / (double) DalgaList.size()));
        int maxkisi = parca * kisisinir;

        int masasay = kisisinir * (int) (Math.ceil((double) tur / (double) Math.ceil((double) suretotal / (double) DalgaList.size())));
        if (maxkisi < kisitotal) {
            kacankisi = kisitotal - maxkisi;
            kalankisi = maxkisi;
        } else {
            kacankisi = 0;
            kalankisi = kisitotal;
        }
        double idealmasatest = Math.ceil((double) kalankisi / (double) masatur);
        if (idealmasatest > masasay) {
            idealmasa = masasay;
        } else {
            idealmasa = idealmasatest;
        }
        idealgarson = Math.ceil((double) idealmasa / (double) ((double) tur / (double) Main.garsonsn));
        idealsef = Math.ceil((double) idealmasa / (double) ((double) tur / (double) ((double) Main.sefsn / (double) Main.sefpisir)));
        idealkasa = Math.ceil((double) idealmasa / (double) ((double) tur / (double) Main.kasasn));
        kazanc = (int) (kalankisi - idealmasa - idealgarson - idealsef);

        for (int j = kisitotal; j > 0; j--) {

            if (maxkisi < j) {
                kacankisi1 = j - maxkisi;
                kalankisi1 = maxkisi;
            } else {
                kacankisi1 = 0;
                kalankisi1 = j;
            }
            double idealmasatest1 = Math.ceil((double) kalankisi1 / (double) masatur);
            if (idealmasatest1 > masasay) {
                idealmasa1 = masasay;
            } else {
                idealmasa1 = idealmasatest;
            }
            idealgarson1 = Math.ceil((double) idealmasa1 / (double) ((double) tur / (double) Main.garsonsn));
            idealsef1 = Math.ceil((double) idealmasa1 / (double) ((double) tur / (double) ((double) Main.sefsn / (double) Main.sefpisir)));
            idealkasa1 = Math.ceil((double) idealmasa1 / (double) ((double) tur / (double) Main.kasasn));
            kazanc1 = (int) (kalankisi1 - idealmasa1 - idealgarson1 - idealsef1);

            if (kazanc1 > kazanc) {
                idealgarson = idealgarson1;
                idealmasa = idealmasa1;
                idealkasa = idealkasa1;
                idealsef = idealsef1;
                kazanc = (int) kazanc1;
                kalankisi = kalankisi1;
                kacankisi = kacankisi1;

            }

        }

        MaliyetList.add(kisitotal);
        MaliyetList.add((int) idealmasa);
        MaliyetList.add((int) idealgarson);
        MaliyetList.add((int) idealsef);
        MaliyetList.add((int) idealkasa);
        MaliyetList.add(kazanc);
        MaliyetList.add(kalankisi);
        MaliyetList.add(kacankisi);
        return MaliyetList;

    }

    /*
    Formul kiþi sayýsýnýn 1 müþterinin bekleme süresi boyunca 1 masaya en fazla kaç kiþi oturabileceðine bölümüyle elde edilen masa sayýsý ve bu sayýnýn 1turun içindeki iþlem parçalarýna bölümünden elde edilen görev sayýlarý ile max verim bulunur
     */
}
