package print_in_word.print;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xwpf.usermodel.*;
import print_in_word.controller.MainController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Print {

    public Print() {
    }

    public void prints (String filename, String file_excel) throws IOException, InvalidFormatException {

        Persons persons = new Persons();
        ArrayList<String> names = persons.getPersons(file_excel);
        String fio = "";
        //InputStream in = new FileInputStream("D:\\Print_in_WORD\\Общество с ограниченной.docx");

        String searchValue = "#FIO";
        int i = 0;
        for (String name : names) {
            XWPFDocument document = new XWPFDocument(new FileInputStream(filename) {
                @Override
                public int read() throws IOException {
                    return 0;
                }
            });
            System.out.println(name);
            for (XWPFTable tables : document.getTables()) {
                for (XWPFTableRow rows : tables.getRows()) {
                    for (XWPFTableCell cells : rows.getTableCells()) {
                        for (XWPFParagraph paragraphs : cells.getParagraphs()) {
                            List<XWPFRun> runs = paragraphs.getRuns();
                            if (runs != null) {
                                for (XWPFRun r : runs) {
                                    String text = r.getText(0);
                                    if (text != null && text.contains("FIO")) {
                                        Get_NativePadeg get_nativePadeg = new Get_NativePadeg(name);
                                        fio = get_nativePadeg.getGet_NativePadeg();
                                        text = text.replace("FIO", fio);
                                        r.setText(text, 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("@@@@@@");
            for (XWPFParagraph p : document.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        //System.out.println(text);
                        if (text != null && text.contains("FIO")) {
                            String[] strings = name.split(" ");
                            name = strings[0] + " " + strings[1];
                            text = text.replace("FIO", name);
                            r.setText(text, 0);
                        }
                    }
                }
                FileOutputStream outputStream = new FileOutputStream("D:\\Print_in_WORD\\" + i + "_" + fio + ".doc");
                document.write(outputStream);
                outputStream.close();
            }
        i++;

        }
    }
}
