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

public class Persons {

    public Persons () {
    }

    public ArrayList<String> getPersons(String file_excel) throws IOException {

        ArrayList<String> list_persons = new ArrayList<>();
        InputStream in = null;
        HSSFWorkbook wb = null;

        in = new FileInputStream(file_excel);
        wb = new HSSFWorkbook(in);

        Sheet sheet = wb.getSheet("Персонал");
        Iterator<Row> it = sheet.rowIterator(); {
            if (it.hasNext()) {
                it.next();
                while (it.hasNext()) {
                    Row row = it.next();
                    Cell pers_cell = row.getCell(1);
                    list_persons.add(pers_cell.getStringCellValue());
            }
            }
        }
        return list_persons;
    }
}
