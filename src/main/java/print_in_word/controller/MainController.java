package print_in_word.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainController {

    String work_file = "";
    private Task workTask;
    Stage Window = new Stage();

    @FXML
    private Button pint_button;
    public void click_print() {
        pint_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fxmlFile = "/fxml/hello.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent root = null;
                try {
                    root = loader.load(getClass().getResourceAsStream(fxmlFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Window.setTitle("Печать в шаблоны WORD");
                Window.setScene(new Scene(root));
                Window.show();
            }
        });
    }

    @FXML
    Button file_choose;
    @FXML
    private TextField textField;
    public void click_file_choose() {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("D:\\Print_in_WORD"));
        file_choose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File file = fileChooser.showOpenDialog(Window);
                textField.setText(file.getAbsolutePath());
                work_file = file.getAbsolutePath();
            }
        });
    }
}