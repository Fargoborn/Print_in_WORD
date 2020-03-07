package print_in_word.print;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Print {

    public Print() {}

    public void prints (String filename, String file_excel) throws IOException {
        Persons persons = new Persons();
        ArrayList<String> personal = persons.getPersons(file_excel);
        String fio = "";
        String status = "";
        //InputStream in = new FileInputStream("D:\\Print_in_WORD\\Общество с ограниченной.docx");
        String searchValue = "#FIO";
        int i = 0;
        for (int j = 0; j < personal.size(); j++) {

            String[] prs = personal.get(j).split("&&");
            String num = prs[0].trim();
            String podr = prs[1].trim();
            String name = prs[2].trim();
            status = prs[3].trim();

            Path path = Paths.get("D:\\Print_in_WORD\\__Print_in_WORD\\" + podr);
            if(!Files.exists(path)) {
                try {
                    Files.createDirectories(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
                                        Get_NativePadeg get_nativePadeg = new Get_NativePadeg();
                                        fio = get_nativePadeg.getGet_NativePadeg(name);
                                        text = text.replace("FIO", fio);
                                        r.setText(text, 0);
                                    }
                                }
                                for (XWPFRun r : runs) {
                                    String text1 = r.getText(0);
                                    if (text1 != null && text1.contains("STATUS")) {
                                        Get_NativePadeg get_nativeP = new Get_NativePadeg();
                                        status = get_nativeP.getGet_NativePadeg_Status(status);
                                        text1 = text1.replace("STATUS", status);
                                        r.setText(text1, 0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            //System.out.println("@@@@@@");
            for (XWPFParagraph p : document.getParagraphs()) {
                //System.out.println(name);
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        //System.out.println(text);
                        //if (text != null && text.contains("NUM")) {
                        //    String[] strings = name.split(" ");
                        //    text = text.replace("NUM", num);
                        //    r.setText(text, 0);
                        //}
                        if (text != null && text.contains("FIO")) {
                            String[] strings = name.split(" ");
                            String f_name = "Уважаемый(ая)" + " " + strings[1] + " " + strings[2];
                            text = text.replace("FIO", f_name);
                            r.setText(text, 0);
                        }
                    }
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        String[] strings = name.split(" ");
                        String s_name = strings[1].substring(0, 1) + "." + strings[2].substring(0, 1) + ". " + strings[0];
                        //System.out.println(s_name);
                        if (text != null && text.contains("$$$$$$")) {
                            text = text.replace("$$$$$$", s_name);
                            r.setText(text, 0);
                        }
                    }
                }

            }
        i++;
            System.out.println(i);
            FileOutputStream outputStream = new FileOutputStream(path + "\\" + " " + fio + "_" + num + ".doc");
            document.write(outputStream);
            outputStream.close();
            document.close();
        }
    }
}
