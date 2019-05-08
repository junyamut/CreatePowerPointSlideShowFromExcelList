package xyz.joseyamut.app;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWorkbook extends WorkbookInputPath {
	GetFieldsAsMap fields;
	protected LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
	private LinkedList<LinkedHashMap<String, String>> masterList;
	protected int HEADER_ROW_INDEX = 0;
	private int DATA_ROW_START = 1;
	private FileInputStream fileInputStream;
	private XSSFWorkbook workbook;
	private Sheet sheet;	
	private int count;
	protected int length;
	public String delimiter;

	public ReadWorkbook() {
		try {
			fields = new GetFieldsAsMap();
			fileInputStream = new FileInputStream(new File(getPath().toString()));
			workbook = new XSSFWorkbook(fileInputStream);			
			sheet = workbook.getSheetAt(0);
			fileInputStream.close();
			delimiter = Properties.getProperties().getApp().getDatSrcAttr().getDelimiter();
			length = getTotalColumns(HEADER_ROW_INDEX);
			for (int index = 0; index < length; index++) {
				String header = getSheet().getRow(HEADER_ROW_INDEX).getCell(index).getStringCellValue().trim();			
				headers.put(removeDelimiter(header), removeDelimiter(header));
			}
		} catch (IOException e) { }
		getAllRows();
	}

	public XSSFWorkbook getWorkbook() {
		return workbook;
	}
	
	public Sheet getSheet() {
		return sheet;
	}
	
	public int getTotalRows() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getTotalColumns(int index) {
		return sheet.getRow(index).getPhysicalNumberOfCells();
	}
	
	protected LinkedHashMap<String, String> getRows(int row) {
		LinkedHashMap<String, String> list = new LinkedHashMap<String, String>();
		int columns = getTotalColumns(row);
		for (int index = 0; index < columns; index++) {
			list.put(getHeaderKey(fields.getMap().get(index)), sheet.getRow(row).getCell(index).getStringCellValue().trim());			
		}
		return list;
	}
		
	private void getAllRows() {		
		masterList = new LinkedList<LinkedHashMap<String, String>>();
		int rows = getTotalRows();
		for (int index = DATA_ROW_START; index < rows; index++) {
			masterList.add(getRows(index));
			count++;
		}
	}

	public LinkedList<LinkedHashMap<String, String>> getMasterList() {
		return masterList;
	}
	
	public int getCount() {
		return count;
	}

	public String removeDelimiter(String value) {
		return value.replaceAll(delimiter, "");
	}
	
	private String getHeaderKey(String value) {
		String key = new String();
		for (Map.Entry<String, String> entry: headers.entrySet()) {
			if (entry.getValue().equals(value)) {
				key = entry.getKey();
			}
		}
		return key;
	}
}