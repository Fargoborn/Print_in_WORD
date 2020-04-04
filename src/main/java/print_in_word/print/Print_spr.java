package print_in_word.print;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Print_spr {

  public Print_spr() {}

  public void prints_spr (String filename, String file_excel) throws IOException {
    Persons_spr persons = new Persons_spr();
    ArrayList<String> personal = persons.getPersons_spr(file_excel);
    String fio = "";
    String status = "";
    String date = "";
    String uvd = "";
    String num = "";
    String ser = "";
    String order = "";
    String adres = "г.Рыбинск ул.1я Выборгская д.50";
    //InputStream in = new FileInputStream("D:\\Print_in_WORD\\Общество с ограниченной.docx");
    //String []searchValue = {"FIOpp", "SER", "NUM", "DATE", "UVD", "STATUS", "ORDER", "ADRES", "FIOrp"} ;

    for (int j = 0; j < personal.size(); j++) {

      String[] prs = personal.get(j).split("&&");
      fio = prs[0].trim();
      status = prs[1].trim();
      date = prs[2].trim();
      uvd = prs[3].trim();
      num = prs[4].trim();
      ser = prs[5].trim();
      order = prs[6].trim();


      Path path = Paths.get("D:\\Print_in_WORD\\spr__Print_in_WORD" );
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

      System.out.println(fio);
      //for (int i = 0; i < searchValue.length; i++) {
        //System.out.println(searchValue[i]);
        for (XWPFParagraph paragraphs : document.getParagraphs()) {
        List<XWPFRun> runs = paragraphs.getRuns();
        for (XWPFRun r : runs) {
          String text = r.getText(0);
          if (text != null) {
            Get_NativePadeg get_nativeP = new Get_NativePadeg();
            String fiopp = get_nativeP.getGet_NativePadeg(fio);
            String fiorp = get_nativeP.getGet_NativePadeg_pp(fio);
            String sex = get_nativeP.getGet_Sex(fio);
            text = text.replace("FIOpp", fiopp);
            text = text.replace("SEX", sex);
            text = text.replace("SER", ser);
            text = text.replace("NUM", num);
            text = text.replace("DATE", date);
            text = text.replace("UVD", uvd);
            text = text.replace("STATUS", status);
            text = text.replace("ORDER", order);
            text = text.replace("ADRES", adres);
            text = text.replace("FIOrp", fiorp);

            r.setText(text, 0);
          }
        }
      }
      //}


      FileOutputStream outputStream = new FileOutputStream(path + "\\" + fio + ".doc");
      document.write(outputStream);
      outputStream.close();
      document.close();
    }
  }
}


