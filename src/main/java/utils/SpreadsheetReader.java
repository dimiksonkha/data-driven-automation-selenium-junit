package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SpreadsheetReader {

    private File spreadsheet;
    private Sheet currentSheet;
    private Map<String, Integer> columns;

    public SpreadsheetReader(File file){
        spreadsheet = file;
        columns = new HashMap();
    }

    public void switchToSheet(String name){
        try(var workbooks = WorkbookFactory.create(spreadsheet)){
            currentSheet = workbooks.getSheet(name);
            currentSheet.getRow(0).forEach(cell ->{
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getCellData(String columnName, int row){
        var dataRow = currentSheet.getRow(row);
        return getCellDataAsString(dataRow.getCell(columns.get(columnName)));

    }


    private String getCellDataAsString(Cell cell){
        switch(cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int)cell.getNumericCellValue());
            default:
                return "";
        }

    }
}