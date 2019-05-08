package xyz.joseyamut.app;

import java.io.IOException;
import java.util.LinkedHashMap;

public class GetFieldsAsMap {
	private LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	private String[] fields;
	private int length;

	public GetFieldsAsMap() {
		try {
			fields = Properties.getProperties().getApp().getDatSrcAttr().getFields();
			length = fields.length;
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		setMap();
	}
	
	private void setMap() {
		int index = 0;
		for (String field: fields) {
			map.put(index, field.trim());
			index++;
		}
	}
	
	public LinkedHashMap<Integer, String> getMap() {
		return map;
	}

	public int getLength() {
		return length;
	}
}