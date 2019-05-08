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
	
	public void replaceTextContent(String findText, String replaceWith) {
		String findTextWithDelimiter = delimiter + findText + delimiter;
		XSLFSlide slide = masterSlide;
		CTSlide ctSlide = slide.getXmlObject();
		XmlObject[] aText = ctSlide.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:t");
		for (int i = 0; i < aText.length; i++) {
			if (aText[i] instanceof XmlString) {
				XmlString xmlString = (XmlString) aText[i];
				String text = xmlString.getStringValue();
				if (text.contains(findTextWithDelimiter)) {						
					xmlString.setStringValue(text.replaceAll(findTextWithDelimiter, replaceWith));
				}
			}
		}
		masterSlide = slide;
	}
}