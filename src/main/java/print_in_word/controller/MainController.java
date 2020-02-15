package print_in_word.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    String work_file = "";
    private Task workTask;
    Stage Window_orders_comm = new Stage();

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
                Window_orders_comm.setTitle("Печать в шаблоны WORD");
                Window_orders_comm.setScene(new Scene(root));
                Window_orders_comm.show();
            }
        });
    }
}