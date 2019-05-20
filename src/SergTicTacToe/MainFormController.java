/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SergTicTacToe;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Saloed
 */
public class MainFormController implements Initializable {

    @FXML
    private Pane mainFormPane;
    @FXML
    private Label gameHeader;
    @FXML
    private Button startGame3x3;
    @FXML
    private Button startGame5x5;
    @FXML
    private Button exit;
    @FXML
    private TextField player1Name;
    @FXML
    private TextField player2Name;
    @FXML
    private RadioButton player1rb;
    @FXML
    private RadioButton player2rb;

    protected static ArrayList<Player> players; //need to be only public
    private String playerSelector;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final ToggleGroup buttonGroup = new ToggleGroup();
        player1rb.setToggleGroup(buttonGroup);
        player1rb.setSelected(true);
        player2rb.setToggleGroup(buttonGroup);

    }

    @FXML
    private void startGame3x3(ActionEvent event) throws Exception {
        players = new ArrayList();
        if (player1rb.isSelected()) {
            players.add(new Player(1, player1Name.getText()));
            players.add(new Player(2, player2Name.getText()));
        } else {
            players.add(new Player(2, player2Name.getText()));
            players.add(new Player(1, player1Name.getText()));
        }
        System.out.println(players.get(0).getName() + players.get(1).getName());
        GameProcess process = new GameProcess(3);
    }

    @FXML
    private void startGame5x5(ActionEvent event) throws Exception {
        players = new ArrayList();
        if (player1rb.isSelected()) {
            players.add(new Player(1, player1Name.getText()));
            players.add(new Player(2, player2Name.getText()));
        } else {
            players.add(new Player(2, player2Name.getText()));
            players.add(new Player(1, player1Name.getText()));
        }
        System.out.println(players.get(0).getName() + players.get(1).getName());
        GameProcess process = new GameProcess(5);
    }

    @FXML
    private void exitTotal(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void player1Selected(InputMethodEvent event) {
    }

    @FXML
    private void player2Selected(InputMethodEvent event) {
    }
}
