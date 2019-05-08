package xyz.joseyamut.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;

public class ReadTemplate extends TemplateInputPath {
	private String delimiter; 
	private FileInputStream fileInputStream;
	private XMLSlideShow template;
	private XSLFSlide masterSlide;

	public ReadTemplate() {		
		try {
			fileInputStream = new FileInputStream(new File(getPath().toString()));
			template = new XMLSlideShow(fileInputStream);
			masterSlide = template.getSlides().get(0);
			delimiter = Properties.getProperties().getApp().getDatSrcAttr().getDelimiter();
		} catch (IOException e) { 
		} finally { 
			try {
				fileInputStream.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} 
		}
	}
	
	public XMLSlideShow getTemplate() {
		return template;
	}
	
	public XSLFSlide getMasterSlide() {
		return masterSlide;
	}
}