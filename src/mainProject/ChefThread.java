package mainProject;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class ChefThread implements Runnable {

    private int id = 999;
    private int sayi = Lists.kisisayList.size();
    private int available = 1;
    private int idwork = 1;
    private int CustomerId = 999;
    private int CustomerId1 = 999;
    private ArrayList<Integer> check = new ArrayList<>();

    public ChefThread(int id) {
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
            while (!Thread.currentThread().isInterrupted() && sayi > 0) {
                if (Main.sefpisir == 2) {

                    if (!Lists.ChefList.isEmpty() && this.available == 1) {
                        synchronized (Lists.ChefList) {
                            if (!Lists.ChefList.isEmpty()) {
                                this.CustomerId = parseInt(Lists.ChefList.getFirst());
                                Lists.ChefList.remove(CustomerId + "");
                                if (check.contains(CustomerId)) {
                                    CustomerId = 999;
                                    break;
                                } else {
                                    check.add(CustomerId);
                                }
                            } else {
                                break;
                            }
                            Cooking Cook = new Cooking(CustomerId, id);
                            Cook.Cook();

                        }

                        synchronized (Lists.ChefList) {
                            if (!Lists.ChefList.isEmpty()) {
                                this.CustomerId1 = parseInt(Lists.ChefList.getFirst());
                                Lists.ChefList.remove(CustomerId1 + "");
                                if (check.contains(CustomerId1)) {
                                    CustomerId1 = 999;
                                } else {
                                    check.add(CustomerId1);
                                }
                            }
                            if (CustomerId1 != 999) {
                                Cooking Cook = new Cooking(CustomerId1, id);
                                Cook.Cook();

                            }
                        }
                        try {
                            this.available = 0;
                            Thread.sleep(Main.sefsn * 1000);
                            synchronized (Lists.EatingList) {
                                Lists.EatingList.add(CustomerId + "");
                                Lists.AllEatingList.add(CustomerId + "");
                                System.out.println(id + "0 numarali ASCI " + CustomerId + " numarali musterinin yemegini hazirlamistir.");
                                CustomerId = 999;
                            }

                            synchronized (Lists.EatingList) {
                                if (CustomerId1 != 999) {
                                    Lists.EatingList.add(CustomerId1 + "");
                                    Lists.AllEatingList.add(CustomerId1 + "");
                                    System.out.println(id + "1 numarali ASCI " + CustomerId1 + " numarali musterinin yemegini hazirlamistir.");
                                    CustomerId1 = 999;
                                }
                            }
                            this.available = 1;
                        } catch (InterruptedException ex) {
                            //Logger.getLogger(ChefThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else {

                    if (!Lists.ChefList.isEmpty() && this.available == 1) {
                        synchronized (Lists.ChefList) {
                            if (!Lists.ChefList.isEmpty()) {
                                this.CustomerId = parseInt(Lists.ChefList.getFirst());
                            } else {
                                break;
                            }
                            Cooking Cook = new Cooking(CustomerId, id);
                            Cook.Cook();

                            Lists.ChefList.remove(CustomerId + "");

                        }

                        try {
                            this.available = 0;
                            System.out.println(id + " numarali ASCI " + CustomerId + " numarali musterinin yemegini hazirlamistir.");
                            Thread.sleep(Main.sefsn * 1000);
                            synchronized (Lists.EatingList) {
                                Lists.EatingList.add(CustomerId + "");
                                Lists.AllEatingList.add(CustomerId + "");
                            }
                            this.available = 1;
                        } catch (InterruptedException ex) {
                            //Logger.getLogger(ChefThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }
            if (sayi == 0) {
                Thread.currentThread().interrupt();
                System.out.println("Thread kapatýldýChef");
                this.idwork = 0;
            }
        } catch (NumberFormatException e) {
            //Logger.getLogger(ChefThread.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
