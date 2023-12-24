package org.example.rsagui;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class SceneControl {
    public SceneControl(AnchorPane currentAnchorpane, String fxml) throws Exception{
        AnchorPane nextAnchorpane = FXMLLoader.load(Objects.requireNonNull(MainMenu.class.getResource(fxml)));
        currentAnchorpane.getChildren().removeAll();
        currentAnchorpane.getChildren().setAll(nextAnchorpane);
    }
}
