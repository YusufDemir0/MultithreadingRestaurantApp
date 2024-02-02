/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainProject;

/**
 *
 * @author yusuf
 */


public class Sit{

    private int id = 999;

    public Sit(int id) {
        this.id = id;
    }

    public int Desk() {

        /*yemek hazirlama ile ilgili iþlem yapýlmak istenirse bu alanda yapýlmalý*/
        
        Lists.StepList.add(id + " numarali musteri masaya oturmustur.");
        return 1;
    }
}
