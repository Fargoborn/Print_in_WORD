package print_in_word.print;

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

    public void prints (String filename, String file_excel) throws IOException {

        Persons persons = new Persons();
        ArrayList<String> names = persons.getPersons(file_excel);
        InputStream in = new FileInputStream(filename);
        XWPFDocument document = new XWPFDocument(in);
        String searchValue = "#FIO";
        List<XWPFParagraph> runs;

        for (String name : names) {
        runs = document.getParagraphs();
        for (XWPFParagraph paragraph : runs) {
            String text = paragraph.getText();
            if (text.contains(searchValue)) {
                searchValue.replaceAll(searchValue, name);
            }
        }
        }
        document.write(new FileOutputStream("D:\\Print_in_WORD\\output.docx"));
    }
}
