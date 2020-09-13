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
import print_in_word.print.Print_spr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class MainController {

    String work_file = "";
    String work_file_list = "";
    Stage Window = new Stage();
    //Print_spr print = new Print_spr(); //справки вирус
    Print print = new Print(); //уведомления трудовые книжки

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
                try {
                    pr_Field_list.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                    //TimeUnit.SECONDS.sleep(6);
                    PrintWriter log;
                    FileWriter logFile;
                    /*  Сначала откроем файл, в который будем писать ошибки */
                    try {
                        String path = new File("").getAbsolutePath();
                        logFile = new FileWriter(path + "exceptions.log", true);
                        log = new PrintWriter((java.io.Writer)logFile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        return;
                    }
                    try {
        /*  Тут находится основной код вашего приложения. Ошибки будут
            проявляться в виде исключений, например так (искуственный
            пример)
        */
                        print.prints(work_file, work_file_list);
                    } catch (Exception ex) {
        /*  Перехватываем все необработанные исключения и пишем в логфайл
            временную отметку, сообщение об ошибке и стектрейс (в котором
            будут указаны методы, которые привели к ошибке и номера строк
            в исходниках)
        */
                        log.printf("\n%s: %s\n", LocalDateTime.now(), ex.getMessage());
                        ex.printStackTrace(log);
                        log.flush();
                    }
                    print.prints(work_file, work_file_list);
                    pr_Field_list.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                } catch (IOException e) {
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
        fileChooser.setInitialDirectory(new File("E:\\Git_Rep\\Print_in_WORD"));
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
        fileChooser_list.setInitialDirectory(new File("E:\\Git_Rep\\Print_in_WORD"));
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