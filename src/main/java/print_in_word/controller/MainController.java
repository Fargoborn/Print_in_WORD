package print_in_word.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import print_in_word.print.Print;

import java.io.File;
import java.io.IOException;

public class MainController {

    String work_file = "";
    String work_file_list = "";
    Stage Window = new Stage();

    @FXML
    private TextField pr_Field_list;

    @FXML
    public TextField text;

    @FXML
    private Button pint_button;
    public void click_print() {
        pint_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println(work_file);
                Print print = new Print();
                try {
                    print.prints(work_file, work_file_list);
                    pr_Field_list.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
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

    @FXML
    Button file_choose_list;
    @FXML
    TextField textField_list;

    public void click_file_choose_list() {
        final FileChooser fileChooser_list = new FileChooser();
        fileChooser_list.setInitialDirectory(new File("D:\\Print_in_WORD"));
        file_choose_list.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File file = fileChooser_list.showOpenDialog(Window);
                textField_list.setText(file.getAbsolutePath());
                work_file_list = file.getAbsolutePath();
            }
        });
    }
}