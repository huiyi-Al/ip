package Javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import command.Command;
import ui.commandParser;
import ui.TaskService;
import ui.GuiUi;
import Storage.Storage;
import java.io.File;
import Fressia.Fressia;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Fressia fressia;
    private TaskService taskService;
    private commandParser parser;
    private GuiUi guiUi;
    private Storage storage;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image fressiaImage = new Image(this.getClass().getResourceAsStream("/images/DaFressia.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());

        String filePath = "data" + File.separator + "fressia.txt";
        this.storage = new Storage(filePath);
        this.taskService = new TaskService(storage);
        this.guiUi = new GuiUi(this);
        this.parser = new commandParser(guiUi, taskService);

        guiUi.greet();
    }

    public void setFressia(Fressia f) {
        fressia = f;
    }

    public void showFressiaMessage(String message) {
        dialogContainer.getChildren().add(
                DialogBox.getFressiaDialog(message, fressiaImage));
    }


    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        dialogContainer.getChildren().add(
                DialogBox.getUserDialog(input, userImage)
        );

        Command command = parser.parseCommand(input);
        if(command != null) {
            command.execute();
        } else {
            guiUi.errorInput1();
        }

        userInput.clear();

        if (command.isExit()) {
            guiUi.exit();
            javafx.application.Platform.exit();
        }
    }
}
