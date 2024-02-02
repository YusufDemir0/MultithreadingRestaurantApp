package mainProject;

import com.sun.javafx.logging.PlatformLogger.Level;
import static java.lang.Integer.parseInt;
import java.lang.System.Logger;
import java.time.Duration;

public class CheckOutThread implements Runnable {

    private int id = 999;
    private int available = 1;
    private int sayi = Lists.kisisayList.size();
    private int idwork = 1;
    private int CustomerId = 999;

    public CheckOutThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        while (Main.work == 1 && this.idwork == 1) {
            this.sayi = Lists.kisisayList.size();
            work();

        }
        Thread.currentThread().interrupt();
        //System.exit(0);

    }

    public void work() {

        try {
            while (!Thread.currentThread().isInterrupted() && sayi > 0) {

                if (!Lists.CheckOutList.isEmpty() && this.available == 1) {
                    synchronized (Lists.CheckOutList) {
                        if (!Lists.CheckOutList.isEmpty()) {
                            this.CustomerId = parseInt(Lists.CheckOutList.getFirst());
                        } else {
                            break;
                        }
                        CheckOuting Check = new CheckOuting(CustomerId, id);
                        Check.Check();

                        Lists.CheckOutList.remove(CustomerId + "");

                    }

                    
                    try {
                        
                        this.available = 0;
                        System.out.println(id + " numarali KASA " + CustomerId + " numarali musterinin hesabini almistir.");
                        Thread.sleep(1000 * Main.kasasn);
                        System.out.println("Kisi sayson:" + Lists.kisisayList.size());
                        synchronized (Lists.Desks) {
                            //Lists.Desks.remove(CustomerId + "");
                            Lists.FinishList.add(CustomerId + "");

                            //System.out.println(CustomerId + "CustomerId");
                            int sil = Lists.Desks.indexOf(CustomerId + "");
                            System.out.println(sil);
                            Lists.Desks.set(sil, (999 + ""));
                            CustomerId = 999;

                        }
                        this.available = 1;
                        if (Lists.kisisayList.isEmpty()) {
                            Main.work = 0;
                            this.idwork = 0;

                            System.out.println("Thread kapatýldýKasa");

                            Thread.currentThread().interrupt();

                        }
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(CheckOutThread.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }

            }

        } catch (NumberFormatException e) {
            //Logger.getLogger(CheckOutThread.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
