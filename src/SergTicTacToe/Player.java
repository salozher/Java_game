/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SergTicTacToe;

/**
 *
 * @author Saloed
 */
public class Player {
   private int index;
   private String name;
//   private Image userPicture;

    protected Player(int index, String name) {
        this.index = index;
        this.name = name;
//        this.userPicture = userPicture;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

//    public Image getUserPicture() {
//        return userPicture;
//    }
   
   
   
}
