package print_in_word.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import print_in_word.print.Print;

import java.io.File;
import java.io.IOException;

public class MainController {

    String work_file = "";
    Stage Window = new Stage();

    @FXML
    private Button pint_button;
    public void click_print() {
        pint_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                System.out.println(work_file);
                Print print = new Print();
                try {
                    print.prints(work_file, "D:\\Print_in_WORD\\1.xls");
                } catch (IOException | InvalidFormatException e) {
                    e.printStackTrace();
                }
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