/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainProject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerThread implements Runnable {
    
    private int id = 999;
    private int age = 0;
    private int idwork = 1;
    
    public CustomerThread(int id, int age) {
        this.id = id;
        this.age = age;
        Lists.CustomertList.add(this.id + "");
    }
    
    @Override
    public void run() {
        
        if (age > 64) {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        } else {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        }
        while (Main.work == 1 && this.idwork == 1) {
            work();
        }
        
        Thread.currentThread().interrupt();
    }
    
    public void work() {
        
        long startTime = System.currentTimeMillis();
        long currentTime = System.currentTimeMillis();
        int cik = 0;

        // Belirli bir süre geçti mi kontrol et
        while (currentTime - startTime <= 1000 * Main.musterisn && cik == 0) {
            synchronized (Lists.WaiterList) {
                synchronized (Lists.Desks) {
                    for (int i = 0; i < Lists.Desks.size(); i++) {
                        synchronized (Lists.CustomertList) {
                            if (Lists.Desks.get(i).equals(999 + "") && Lists.CustomertList.getFirst().equals(id + "")) {
                                Sit Sit = new Sit(this.id);
                                Sit.Desk();
                                
                                if (age > 64) {
                                    System.out.println(this.id + " OZEL musteri " + i + " numarali masaya oturmustur.");
                                } else {
                                    System.out.println(this.id + " numarali musteri " + i + " numarali masaya oturmustur.");
                                }
                                
                                Lists.WaiterList.add(this.id + "");
                                Lists.AllWaiterList.add(this.id + "");
                                System.out.println("WaiterList current size:" + Lists.WaiterList.size());
                                Lists.CustomertList.remove(this.id + "");
                                this.idwork = 0;
                                Lists.Desks.set(i, this.id + "");
                                cik = 1;
                                break; // Döngüden çýk, çünkü iþlem tamamlandý.
                            }
                        }
                    }
                }
            }

            // Eðer bu noktaya kadar geldiyse demek ki henüz boþ masa bulunamadý.
            // Bu durumu kontrol etmek için baþka bir ifade ekleyebilirsiniz.
            // Yeni bir zaman bilgisi al
            currentTime = System.currentTimeMillis();
        }
        while (Lists.AllWaiterList.contains(id + "")) {
            if (Lists.EatingList.contains(id + "")) {
                //System.out.print("test");
                try {
                    Thread.sleep(Main.yemeksn * 1000);
                    System.out.println(this.id + " numarali musteri yemegini yedi.");
                    Lists.EatingList.remove(id + "");
                    Lists.AllEatingList.remove(id + "");
                    Lists.CheckOutList.add(id + "");
                    Lists.AllCheckOutList.add(id + "");
                    Lists.StepList.add(id + " numarali musteri yemegini yemistir.");
                    break;
                } catch (InterruptedException ex) {
                    Logger.getLogger(CustomerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        synchronized (Lists.kisisayList) {
            if (Lists.CustomertList.contains(id)) {
                
                System.out.println("Belirli bir süre boyunca masa bulunamadi." + id + " numarali musteri kacti.");
                Lists.CustomertList.remove(this.id + "");
                System.out.println("Kisi say:" + Lists.kisisayList.size());
                Lists.StepList.add(id + " numarali Musteri kacti.");
                Lists.kisisayList.removeFirst();
                this.idwork = 0;
            }
        }
        
    }
}
