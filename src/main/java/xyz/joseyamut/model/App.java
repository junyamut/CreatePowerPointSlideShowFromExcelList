package xyz.joseyamut.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class App {    
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dataSrcProps")
    @Expose
    private DataSrcProps dataSrcProps;
    @SerializedName("resourcesDir")
    @Expose
    private String resourcesDir;
    @SerializedName("inputDir")
    @Expose
    private String inputDir;
    @SerializedName("outputDir")
    @Expose
    private String outputDir;
    @SerializedName("templateDir")
    @Expose
    private String templateDir;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataSrcProps getDatSrcAttr() {
		return dataSrcProps;
	}

	public void setDatSrcAttr(DataSrcProps dataSrcProps) {
		this.dataSrcProps = dataSrcProps;
	}

	public String getResourcesDir() {
		return resourcesDir;
	}

	public void setResourcesDir(String resourcesDir) {
		this.resourcesDir = resourcesDir;
	}

	public String getInputDir() {
		return inputDir;
	}

	public void setInputDir(String inputDir) {
		this.inputDir = inputDir;
	}

	public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

	public String getTemplateDir() {
		return templateDir;
	}

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}
}