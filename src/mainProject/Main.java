package mainProject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    //de?i?kenler
    public static int work = 1;
    public static int sefpisir=2;
    //s?reler
    public static int musterisn = 20;
    public static int kasasn = 1;
    public static int garsonsn = 2;
    public static int sefsn = 3;
    public static int dalgasn = 5;
    public static int yemeksn = 3;
    //say?lar
    public static int masasay = 6;
    public static int dalgasay = 10;
    public static int musterisay = 6;
    public static int ozelmusterisay = 2;
    public static int kasasay = 1;
    public static int garsonsay = 3;
    public static int sefsay = 2;

    public static void main(String[] args) {

        UI.UI.main(args);

    }

    public static void seneryo1() {
        //seneryo1
        for (int i = 0; i < masasay; i++) {
            Lists.Desks.add(i, 999 + "");
            
            System.out.println(Lists.Desks.size());
        }

        for (int i = 0; i < Main.musterisay + Main.ozelmusterisay; i++) {
            Lists.kisisayList.add(i + "");
        }
        for (int i = 0; i < kasasay; i++) {
            CheckOutThread Checker = new CheckOutThread(i);
            Thread CheckerThread = new Thread(Checker);
            Lists.CheckOutThreadList.add(CheckerThread);
            CheckerThread.start();
        }

        for (int i = 0; i < sefsay; i++) {
            ChefThread Chef = new ChefThread(i);
            Thread chefThread = new Thread(Chef);
            Lists.ChefThreadList.add(chefThread);
            chefThread.start();
        }

        for (int i = 0; i < garsonsay; i++) {
            WaiterThread Waiter = new WaiterThread(i);
            Thread waiterThread = new Thread(Waiter);
            Lists.WaiterThreadList.add(waiterThread);
            waiterThread.start();
        }

        for (int i = 0; i < ozelmusterisay; i++) {
            CustomerThread customer = new CustomerThread(i, 70);
            Thread customerThread = new Thread(customer);
            Lists.CustomerThreadList.add(customerThread);
            customerThread.start();
        }

        int aratur = (int) Math.ceil((double) ((double) Main.musterisay / (double) Main.dalgasay));
        System.out.println("Aratur" + aratur + " " + Main.musterisay + " " + Main.dalgasay);
        int cik = 0;
        for (int j = 0; j < aratur; j++) {
            for (int i = 0; i < Main.dalgasay; i++) {
                if (Main.dalgasay * j + i == Main.musterisay) {
                    cik++;
                    System.out.print("C?kt?mFor");
                    break;
                }
                int id = Main.dalgasay * j + i + Main.ozelmusterisay;
                //System.out.print("act?m"+id);
                CustomerThread customer = new CustomerThread(id, 20);
                Thread customerThread = new Thread(customer);
                Lists.CustomerThreadList.add(customerThread);
                customerThread.start();
                System.out.println("Basladým"+id);
            }
            if (cik > 0) {
                System.out.print("C?kt?m");
                break;
            }
            try {
                Thread.sleep(Main.dalgasn * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void custom(int masasay, int sefsay, int kasasay, int musterisay, int garsonsay, int ozelmusterisay) {
        Main.masasay = masasay;
        Main.sefsay = sefsay;
        Main.kasasay = kasasay;
        Main.musterisay = musterisay;
        Main.garsonsay = garsonsay;
        Main.ozelmusterisay = ozelmusterisay;

        for (int i = 0; i < masasay; i++) {
            Lists.Desks.add(i, 999 + "");
            
            System.out.println(Lists.Desks.size());
        }

        for (int i = 0; i < Main.musterisay + Main.ozelmusterisay; i++) {
            Lists.kisisayList.add(i + "");
        }
        for (int i = 0; i < kasasay; i++) {
            CheckOutThread Checker = new CheckOutThread(i);
            Thread CheckerThread = new Thread(Checker);
            Lists.CheckOutThreadList.add(CheckerThread);
            CheckerThread.start();
        }

        for (int i = 0; i < sefsay; i++) {
            ChefThread Chef = new ChefThread(i);
            Thread chefThread = new Thread(Chef);
            Lists.ChefThreadList.add(chefThread);
            chefThread.start();
        }

        for (int i = 0; i < garsonsay; i++) {
            WaiterThread Waiter = new WaiterThread(i);
            Thread waiterThread = new Thread(Waiter);
            Lists.WaiterThreadList.add(waiterThread);
            waiterThread.start();
        }

        for (int i = 0; i < ozelmusterisay; i++) {
            CustomerThread customer = new CustomerThread(i, 70);
            Thread customerThread = new Thread(customer);
            Lists.CustomerThreadList.add(customerThread);
            customerThread.start();
        }

        int aratur = (int) Math.ceil((double) ((double) Main.musterisay / (double) Main.dalgasay));
        System.out.println("Aratur" + aratur + " " + Main.musterisay + " " + Main.dalgasay);
        int cik = 0;
        for (int j = 0; j < aratur; j++) {
            for (int i = 0; i < Main.dalgasay; i++) {
                if (Main.dalgasay * j + i == Main.musterisay) {
                    cik++;
                    System.out.print("C?kt?mFor");
                    break;
                }
                int id = Main.dalgasay * j + i + Main.ozelmusterisay;
                //System.out.print("act?m"+id);
                CustomerThread customer = new CustomerThread(id, 20);
                Thread customerThread = new Thread(customer);
                Lists.CustomerThreadList.add(customerThread);
                customerThread.start();
                System.out.println("Basladým"+id);
            }
            if (cik > 0) {
                System.out.print("C?kt?m");
                break;
            }
            try {
                Thread.sleep(Main.dalgasn * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
