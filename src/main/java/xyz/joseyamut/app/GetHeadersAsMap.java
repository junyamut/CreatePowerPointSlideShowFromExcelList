package xyz.joseyamut.app;

import java.util.LinkedHashMap;

public class GetHeadersAsMap extends ReadWorkbook {	
	public GetHeadersAsMap() {
		super();
	}
	
	public void setMap(LinkedHashMap<String, String> headers) {
		for (int index = 0; index < length; index++) {
			String header = getSheet().getRow(HEADER_ROW_INDEX).getCell(index).getStringCellValue().trim().toLowerCase();			
			headers.put(removeDelimiter(header), removeDelimiter(header.toUpperCase()));
		}
		this.headers = headers;
	}

	public LinkedHashMap<String, String> getMap() {
		return headers;
	}

	public int getLength() {
		return length;
	}	
}