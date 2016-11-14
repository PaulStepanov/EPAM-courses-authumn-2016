package logicElements;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import textReader.InputReader;

public class Paragraph {

	private ArrayList<Sentense> sentences=new ArrayList<>() ;
	private String paragraph; 

	public Paragraph(String paragraph) {
		this.paragraph=paragraph;
		splitOnSentences();
	}
	
	public void splitOnSentences(){
		Pattern pattern = Pattern.compile("([^(\\.|!|\\?)]+)(\\.|!|\\?)");
		Matcher matcher = pattern.matcher(paragraph);
		while(matcher.find()){
			sentences.add(new Sentense(matcher.group()));
		}
	}

	public ArrayList<Sentense> getSentences() {
		return sentences;
	}

	public String getParagraph() {
		return paragraph;
	}
	
	
	
	

}
