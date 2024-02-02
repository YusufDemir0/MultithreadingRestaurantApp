/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainProject;

/**
 *
 * @author yusuf
 */
public class Cooking{

    private int id = 999;
    private int sefid = 999;

    public Cooking(int id,int sefid) {
        this.id = id;
        this.sefid = sefid;
    }

    public int Cook() {

        /*yemek hazirlama ile ilgili iþlem yapýlmak istenirse bu alanda yapýlmalý*/
        
        Lists.StepList.add(id + " numarali musterinin yemegi pisirilmistir."+"("+sefid+"numarali sef)");
        return 1;
    }
}
