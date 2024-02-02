/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainProject;

/**
 *
 * @author yusuf
 */

public class Ordering{

    private int id = 999;
    private int sefid = 999;

    public Ordering(int id,int sefid) {
        this.id = id;
        this.sefid = sefid;
    }

    public int Order() {

        /*siparis alma ile ilgili iþlem yapýlmak istenirse bu alanda yapýlmalý*/
        
        Lists.StepList.add(id + " numarali musterinin siparisi alinmistir."+"("+sefid+"numarali garson)");
        return 1;
    }
}