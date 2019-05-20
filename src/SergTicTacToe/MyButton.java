/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SergTicTacToe;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 *
 * @author Saloed
 */
public class MyButton extends Button {

    private int index;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private final int SIZE = 82;
    private int state = 0;

    public MyButton(int index, ArrayList<String> path, int x, int y) {
        this.index = index;
        try {
            this.iv1 = new ImageView(path.get(0));
            this.iv2 = new ImageView(path.get(1));
            this.iv3 = new ImageView(path.get(2));
            this.iv4 = new ImageView(path.get(3));
            this.iv5 = new ImageView(path.get(4));
        } catch (Exception e) {
//            Platform.runLater(() -> {
                JOptionPane.showMessageDialog(null, "File with button picture not found", "File with button picture not found", JOptionPane.ERROR_MESSAGE);
//            });
        }

        iv1.setFitHeight(SIZE);
        iv1.setFitWidth(SIZE);

        iv2.setFitHeight(SIZE);
        iv2.setFitWidth(SIZE);

        iv3.setFitHeight(SIZE);
        iv3.setFitWidth(SIZE);
        
        iv4.setFitHeight(SIZE);
        iv4.setFitWidth(SIZE);
        
        iv5.setFitHeight(SIZE);
        iv5.setFitWidth(SIZE);

        this.setGraphic(iv1);
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    public void setImage(int number) {
        if (number == 2) {
            this.setGraphic(iv2);
        }
        if (number == 3) {
            this.setGraphic(iv3);
        }
        if (number == 4) {
            this.setGraphic(iv4);
        }
        if (number == 5) {
            this.setGraphic(iv5);
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIndex() {
        return index;
    }

}
