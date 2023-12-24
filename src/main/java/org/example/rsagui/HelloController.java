package org.example.rsagui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button encrypt;

    @FXML
    private Button decrypt;

    @FXML
    private Button back;
    
    @FXML
    private Button close;

    public void encryptButton() throws IOException{
        Stage stage = (Stage) encrypt.getScene().getWindow();
        stage.close();
        Stage PrimaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("EncryptWd.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    public void decryptButton() throws IOException{
        Stage stage = (Stage) decrypt.getScene().getWindow();
        stage.close();
        Stage PrimaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("DecryptWd.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    public void backButton() throws IOException{
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        Stage PrimaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("MainWs.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    public void view_close() throws IOException{
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
