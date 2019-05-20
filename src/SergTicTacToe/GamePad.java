/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SergTicTacToe;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javax.swing.JOptionPane;
import static SergTicTacToe.MainFormController.players;
import javafx.geometry.Pos;

/**
 *
 * @author Saloed
 */
public class GamePad {

    private Label gameStatus = new Label("GAME STATUS");
    private ArrayList<Integer> vers = new ArrayList();
    private ArrayList<MyButton> gamePad;
    private int padSize;
    private int moveCounter = 0;
    private final int WIDTH = 100;
    private final int HEIGHT = 92;
    private final int SHIFT = 50;

//    private ArrayList<Player> players;
    private boolean checkOut;
    private int myGameButtonState;

    public GamePad(int padSize, ArrayList<String> path) {
//        this.players = players;
//        gameStatus.setLayoutX(0);
//        gameStatus.setLayoutY(0);
//        gameStatus.setPrefSize(500, 50);
        gameStatus.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        gameStatus.setStyle("-fx-border-color: blue;");
        gameStatus.setTextAlignment(TextAlignment.CENTER);

        this.padSize = padSize;
        gamePad = new ArrayList();
        int pindex = 0;
        for (int y = 0; y < padSize; y++) {
            for (int x = 0; x < padSize; x++) {
                MyButton myGameButton = new MyButton(pindex++, path, x * WIDTH, y * HEIGHT + SHIFT);
                myGameButton.setOnAction(e -> {
                    if (myGameButton.getState() == 0) {

                        if (checkOut()) {
                            JOptionPane dialog;
                            dialog = new JOptionPane();
                            JOptionPane.showMessageDialog(null, "THIS GAME IS OVER!!! YOU CAN CLOSE THIS GAME AND START A NEW GAME AGAIN", "GAME OVER!!!", JOptionPane.OK_OPTION);
                            return;
                        }
                        if (moveCounter++ % 2 == 0) {
                            myGameButton.setState(1);
                            myGameButton.setImage(2);
                        } else {
                            myGameButton.setState(10);
                            myGameButton.setImage(3);

                        }
                        if (moveCounter == padSize * padSize) {
                            gameStatus.setText("DRAW!!! THE GAME IS OVER");
                        }
                        if (checkOut()) {
                            String temp = ((moveCounter - 1) % 2 == 0) ? players.get(0).getName() : players.get(1).getName();

                            gameStatus.setText("GAME OVER!!! \n The Winner is " + temp);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "This button is already used. Please press another button!", "Press another button!", JOptionPane.ERROR_MESSAGE);
                    }
                    System.out.println(myGameButton.getIndex());
                    System.out.println(myGameButton.getState());

                });
                gamePad.add(myGameButton);
            }
        }
    }

    private boolean checkOut() {
        if (padSize == 3) {
            return checkOut3x();
        } else if (padSize >= 5) {
            return checkOut5x();
        } else {
            return false;
        }
    }

    private boolean checkOut3x() {

        vers.add(getMyGBState(0) + getMyGBState(1) + getMyGBState(2));
        vers.add(getMyGBState(3) + getMyGBState(4) + getMyGBState(5));
        vers.add(getMyGBState(6) + getMyGBState(7) + getMyGBState(8));
        vers.add(getMyGBState(0) + getMyGBState(3) + getMyGBState(6));
        vers.add(getMyGBState(1) + getMyGBState(4) + getMyGBState(7));
        vers.add(getMyGBState(2) + getMyGBState(5) + getMyGBState(8));
        vers.add(getMyGBState(0) + getMyGBState(4) + getMyGBState(8));
        vers.add(getMyGBState(2) + getMyGBState(4) + getMyGBState(6));

        for (int i = 0; i < vers.size(); i++) {
            if (vers.get(i) == 3 | vers.get(i) == 30) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOut5x() {
        vers.add(getMyGBState(0) + getMyGBState(1) + getMyGBState(2) + getMyGBState(3));//horizontal lines check
        vers.add(getMyGBState(1) + getMyGBState(2) + getMyGBState(3) + getMyGBState(4));
        vers.add(getMyGBState(5) + getMyGBState(6) + getMyGBState(7) + getMyGBState(8));
        vers.add(getMyGBState(6) + getMyGBState(7) + getMyGBState(8) + getMyGBState(9));
        vers.add(getMyGBState(10) + getMyGBState(11) + getMyGBState(12) + getMyGBState(13));
        vers.add(getMyGBState(11) + getMyGBState(12) + getMyGBState(13) + getMyGBState(14));
        vers.add(getMyGBState(15) + getMyGBState(16) + getMyGBState(17) + getMyGBState(18));
        vers.add(getMyGBState(16) + getMyGBState(17) + getMyGBState(18) + getMyGBState(19));
        vers.add(getMyGBState(20) + getMyGBState(21) + getMyGBState(22) + getMyGBState(23));

        vers.add(getMyGBState(0) + getMyGBState(5) + getMyGBState(10) + getMyGBState(15));//vertical lines check
        vers.add(getMyGBState(5) + getMyGBState(10) + getMyGBState(15) + getMyGBState(20));
        vers.add(getMyGBState(1) + getMyGBState(6) + getMyGBState(11) + getMyGBState(16));
        vers.add(getMyGBState(6) + getMyGBState(11) + getMyGBState(16) + getMyGBState(21));
        vers.add(getMyGBState(2) + getMyGBState(7) + getMyGBState(12) + getMyGBState(17));
        vers.add(getMyGBState(7) + getMyGBState(12) + getMyGBState(17) + getMyGBState(22));
        vers.add(getMyGBState(3) + getMyGBState(8) + getMyGBState(13) + getMyGBState(18));
        vers.add(getMyGBState(8) + getMyGBState(13) + getMyGBState(18) + getMyGBState(23));
        vers.add(getMyGBState(4) + getMyGBState(9) + getMyGBState(14) + getMyGBState(19));
        vers.add(getMyGBState(9) + getMyGBState(14) + getMyGBState(19) + getMyGBState(24));

        vers.add(getMyGBState(0) + getMyGBState(6) + getMyGBState(12) + getMyGBState(18));//diagonal lines check down
        vers.add(getMyGBState(6) + getMyGBState(12) + getMyGBState(18) + getMyGBState(24));
        vers.add(getMyGBState(1) + getMyGBState(7) + getMyGBState(13) + getMyGBState(19));
        vers.add(getMyGBState(5) + getMyGBState(11) + getMyGBState(17) + getMyGBState(23));

        vers.add(getMyGBState(3) + getMyGBState(7) + getMyGBState(11) + getMyGBState(15));//diagonal lines check up
        vers.add(getMyGBState(4) + getMyGBState(8) + getMyGBState(12) + getMyGBState(16));
        vers.add(getMyGBState(8) + getMyGBState(12) + getMyGBState(16) + getMyGBState(20));
        vers.add(getMyGBState(9) + getMyGBState(13) + getMyGBState(17) + getMyGBState(21));

        for (int i = 0; i < vers.size(); i++) {
            if (vers.get(i) == 4 | vers.get(i) == 40) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<MyButton> getGamePad() {  //for publishing in to the Pane (Scene)
        return gamePad;
    }

    public Label getLabel() {
        return gameStatus;
    }

    public int getPadSize() {
        return padSize;
    }

    public int getSHIFT() {
        return SHIFT;
    }

    public MyButton getMyButton(int index) {
        return gamePad.get(index);
    }

    public int getMyGBState(int index) {
        return gamePad.get(index).getState();

    }

    {

//                public int getMyGameButtonState(int buttonState) { //public tip peremennoj vozvraschaemyj, imja kotoroe ja produmal dlja novogo metoda
//                v skobochkah u nas to(argumenty dlja raboty funktsii zaprosa), s pomoschju chego ja poluchaju dannye
//        return myGameButton.
    }
}
