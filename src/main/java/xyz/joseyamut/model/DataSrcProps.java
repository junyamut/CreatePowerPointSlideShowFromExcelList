package xyz.joseyamut.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSrcProps {
	@SerializedName("workbook")
    @Expose
    private String workbook;
	@SerializedName("template")
    @Expose
    private String template;
	@SerializedName("delimiter")
    @Expose
    private String delimiter;
    @SerializedName("fields")
    @Expose
    private String[] fields;
    
	public DataSrcProps() {
		// TODO Auto-generated constructor stub
	}

	public String getWorkbook() {
		return workbook;
	}

	public void setWorkbook(String workbook) {
		this.workbook = workbook;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}
}
