package xyz.joseyamut.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class CreatePowerPointSlideShowFromExcelList {	
	public CreatePowerPointSlideShowFromExcelList() throws IOException {
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
		}
	}
}
