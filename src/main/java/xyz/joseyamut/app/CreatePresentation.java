package xyz.joseyamut.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

public class CreatePresentation extends PresentationOutputPath {
	private XMLSlideShow slideShow;

	public CreatePresentation() { 
		slideShow = new XMLSlideShow();
	}
	
	public CreatePresentation(XMLSlideShow slideShow) { 
		this.slideShow = slideShow;
	}
	
	public XMLSlideShow getSlideShow() {
		return slideShow;
	}
	
	public void setSlideShow(XMLSlideShow slideShow) {
		this.slideShow = slideShow;
	}
	
	public XSLFSlide createSlide() {
		return slideShow.createSlide();
	}
	
	public XSLFSlide addNewSlide(XSLFSlide source) {		
		return slideShow.createSlide().importContent(source);
	}
	
	public void write() throws FileNotFoundException, IOException {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(getPath().toString());
			slideShow.write(fileOutputStream);
			slideShow.close();
			fileOutputStream.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}