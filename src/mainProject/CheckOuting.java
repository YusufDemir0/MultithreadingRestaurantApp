/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainProject;

/**
 *
 * @author yusuf
 */
public class CheckOuting {

    private int id = 999;
    private int sefid = 999;

    public CheckOuting(int id,int sefid) {
        this.id = id;
        this.sefid = sefid;
    }

    public int Check() {

        /*hesap alma ile ilgili iþlem yapýlmak istenirse bu alanda yapýlmalý*/
        
        Lists.kisisayList.removeFirst();
        
        Lists.StepList.add(id + " numarali musterinin hesabi alinmistir."+"("+sefid+"numarali kasa)");
        System.out.println("Kisi sayKasa:" + Lists.kisisayList.size());

        return 1;
    }
}
