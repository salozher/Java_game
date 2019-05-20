/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SergTicTacToe;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Saloed
 */
public class GameProcess {

    private int gameSize;

    public GameProcess(int gameSize) throws Exception {
        this.gameSize = gameSize;

        TtPictures path = new TtPictures();
        GamePad ttPad = new GamePad(gameSize, path.getPath());
        ArrayList<MyButton> trial1 = ttPad.getGamePad();
        Pane root = new Pane();
        root.getChildren().addAll(ttPad.getGamePad());
        root.getChildren().addAll(ttPad.getLabel());
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root, ttPad.getPadSize() * 100, ttPad.getPadSize() * 92 + ttPad.getSHIFT());
        stage.setTitle("SergTicTacToe PLAY PAD");
        stage.setScene(scene);
        stage.show();

    }

    public int getGameSize() {
        return gameSize;
    }

}
