package Javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import Fressia.Fressia;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Fressia fressia = new Fressia();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            fxmlLoader.<MainWindow>getController().setFressia(fressia);
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Fressia");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}