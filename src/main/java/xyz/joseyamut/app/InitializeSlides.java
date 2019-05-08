package xyz.joseyamut.app;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

public class InitializeSlides {
	private XMLSlideShow slideShow;
	private ReadTemplate template;

	public InitializeSlides(XMLSlideShow slideShow, ReadTemplate template) {
		this.slideShow = slideShow;
		this.template = template;
	}
	
	public void start(int createSlides) {
		XSLFSlide sourceSlide = template.getMasterSlide();
		for (int count = 1; count < createSlides; count++) {
			XSLFSlide createSlide = slideShow.createSlide();
			createSlide.importContent(sourceSlide);
		}
	}
	
	public XMLSlideShow getUpdatedSlideShow() {
		return slideShow;
	}
}