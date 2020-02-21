package print_in_word.print;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

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
        //InputStream in = new FileInputStream("D:\\Print_in_WORD\\Общество с ограниченной.docx");
        XWPFDocument document = new XWPFDocument(OPCPackage.open(filename));
        String searchValue = "#FIO";

        int i = 0;
        for (String name : names) {
            for (XWPFParagraph p : document.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("#FIO")) {
                            text = text.replace("#FIO", name);
                            r.setText(text, 0);
                        }
                    }
                }
            }
        i++;
            document.write(new FileOutputStream("D:\\Print_in_WORD\\" + i + "output.docx"));
            document.close();
        }
    }
}