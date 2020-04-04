package print_in_word.print;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Persons_spr {

  public Persons_spr () {
  }

  public ArrayList<String> getPersons_spr(String file_excel) throws IOException {
    ArrayList<String> list_persons = new ArrayList<>();
    InputStream in = null;
    HSSFWorkbook wb = null;

    in = new FileInputStream(file_excel);
    wb = new HSSFWorkbook(in);

    Sheet sheet = wb.getSheet("Персонал");
    Iterator<Row> it = sheet.rowIterator(); {
      if (it.hasNext()) {
        while (it.hasNext()) {
          Row row = it.next();
          Cell fio_cell = row.getCell(0);
          Cell status_cell = row.getCell(1);
          Cell date_cell = row.getCell(3);
          Cell uvd_cell =  row.getCell(4);
          Cell num_cell = row.getCell(5);
          String num = "" + (int) num_cell.getNumericCellValue();
          if (num.length() < 6) {
            num = "0" + num;
          }
          Cell ser_cell = row.getCell(6);
          Cell order_cell = row.getCell(7);
          list_persons.add(fio_cell.getStringCellValue().trim() + "&&" + status_cell.getStringCellValue().trim() + "&&" + date_cell.getStringCellValue().trim()
                  + "&&" + uvd_cell.getStringCellValue().trim() + "&&" + num + "&&" + ser_cell.getStringCellValue().trim() + "&&" + order_cell.getStringCellValue().trim());
          //System.out.println(fio_cell.getStringCellValue());
        }
      }
    }

    return list_persons;
  }
}
