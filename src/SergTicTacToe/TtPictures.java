/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SergTicTacToe;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Saloed
 */
public class TtPictures {

    private final ArrayList<String> path;

    protected TtPictures() throws IOException {
        path = new ArrayList();
        path.add("SergTicTacToe/pic.jpg");
        path.add("SergTicTacToe/x.jpg");
        path.add("SergTicTacToe/o.jpg");
        path.add("SergTicTacToe/xx.jpg");
        path.add("SergTicTacToe/oo.jpg");
    }

    public ArrayList<String> getPath() {
        return path;
    }

}
