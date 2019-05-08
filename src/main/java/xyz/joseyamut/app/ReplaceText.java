package xyz.joseyamut.app;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;

public class ReplaceText {
	private GetHeadersAsMap headers;
	private XMLSlideShow slideShow;
	private XmlString xmlString;

	public ReplaceText(XMLSlideShow slideShow) {
		headers = new GetHeadersAsMap();
		this.slideShow = slideShow;
	}
	
	public XMLSlideShow getUpdatedSlideShow() {
		return slideShow;
	}
	
	public void start() {
		int slideCount = 0;
		for (XSLFSlide slide: slideShow.getSlides()) {
            CTSlide ctSlide = slide.getXmlObject();
            XmlObject[] text = ctSlide.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:t");
            for (int index = 0; index < text.length; index++) {
	            if (text[index] instanceof XmlString) {
	                xmlString = (XmlString) text[index];
	                textContains(xmlString.getStringValue(), slideCount);
	            }
            }
            slideCount++;
		}
	}

	private void textContains(String text, int slide) {
		String matches[] = convertToArray();
		for (String search: matches) {
			if (text.contains((headers.delimiter + search + headers.delimiter))) {
				textReplace(text, slide);
				break;
			}
		}
	}
	
	private void textReplace(String text, int slide) {
		Map<String,String> tokens = headers.getMasterList().get(slide);
		String patternString = headers.delimiter + "(" + StringUtils.join(tokens.keySet(), "|") + ")" + headers.delimiter;
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		StringBuffer stringBuffer = new StringBuffer();
		while (matcher.find()) {
		    matcher.appendReplacement(stringBuffer, tokens.get(matcher.group(1)));
		}
		matcher.appendTail(stringBuffer);
		xmlString.setStringValue(stringBuffer.toString());
	}
	
	private String[] convertToArray() {
		int index = 0;
		String array[] = new String[headers.getMap().size()];
		for (Map.Entry<String, String> entry: headers.getMap().entrySet()) {
			array[index] = entry.getValue();
			index++;
		}
		return array;
	}	
}