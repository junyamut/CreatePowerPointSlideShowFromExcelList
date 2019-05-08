package xyz.joseyamut.app;

import java.io.IOException;

public class CreatePowerPointSlideShowFromExcelList {	
	public CreatePowerPointSlideShowFromExcelList() throws Exception {
		ValidateFields.passed();
		ReadWorkbook readWorkbook = new ReadWorkbook();
		ReadTemplate readTemplate = new ReadTemplate();		
		CreatePresentation presentation = new CreatePresentation(readTemplate.getTemplate());
		InitializeSlides initializeSlides = new InitializeSlides(presentation.getSlideShow(), readTemplate);
		initializeSlides.start(readWorkbook.getCount());
		ReplaceText replaceText = new ReplaceText(initializeSlides.getUpdatedSlideShow());
		replaceText.start();
		presentation.write();
	}
	
	public static void main(String args[]) {
		try {
			new CreatePowerPointSlideShowFromExcelList();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
