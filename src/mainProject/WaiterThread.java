package mainProject;

import static java.lang.Integer.parseInt;

public class WaiterThread implements Runnable {

    private int id = 999;
    private int sayi = Lists.kisisayList.size();
    private int available = 1;
    private int idwork = 1;
    private int CustomerId = 999;

    public WaiterThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (Main.work == 1 && this.idwork == 1) {
            this.sayi = Lists.kisisayList.size();
            work();
        }

        Thread.currentThread().interrupt();
    }

    public void work() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.print(ex + "hata");
        }
        try {
            while (!Thread.currentThread().isInterrupted() && sayi > 0) {
                if (!Lists.WaiterList.isEmpty() && this.available == 1) {
                    synchronized (Lists.WaiterList) {
                        if (!Lists.WaiterList.isEmpty()) {
                            this.CustomerId = parseInt(Lists.WaiterList.getFirst());
                            if (this.CustomerId == 999) {
                                System.out.print("kýrdýmaga");
                                break;
                            }
                        } else {
                            break;
                        }
                        Ordering Order = new Ordering(CustomerId, id);
                        Order.Order();

                        Lists.WaiterList.remove(CustomerId + "");
                    }

                    try {
                        this.available = 0;
                        Thread.sleep(Main.garsonsn * 1000);
                        synchronized (Lists.ChefList) {
                            if (CustomerId != 999) {
                                Lists.ChefList.add(CustomerId + "");
                                Lists.AllChefList.add(CustomerId + "");
                                System.out.println(id + " numarali GARSON " + CustomerId + " numarali musterinin siparisini almistir.");
                                CustomerId = 999; // CustomerId'yi sýfýrla
                            }
                        }
                        this.available = 1;
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(ChefThread.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
            }/*
            Thread.currentThread().interrupt();
            System.out.println("Thread kapatýldýWaiter");
            this.idwork = 0;*/
        } catch (NumberFormatException e) {
        }
    }
}
