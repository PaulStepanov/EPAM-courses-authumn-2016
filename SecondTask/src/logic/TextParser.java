package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logicElements.Paragraph;
import logicElements.Sentense;
import textReader.InputReader;

public class TextParser {
	private ArrayList<Paragraph> paragraphs=new ArrayList<>();
	private StringBuilder fullText=new StringBuilder();

	public TextParser(InputReader inputReader) {		
		while (inputReader.hasNext()){
			fullText.append(inputReader.nextLine());
		}
		splitOnParagraphes();
	}
	
	public void splitOnParagraphes(){
		Pattern pattern = Pattern.compile("(\\n|^).*?(?=\\n|$)");
		Matcher matcher = pattern.matcher(fullText);
		while (matcher.find()){
			paragraphs.add(new Paragraph(matcher.group()));
	   }
	}
	
	public void deleteSubstrings(String substring){
		paragraphs.forEach(
				(Paragraph elem)->{
					elem.getSentences().forEach(
							(Sentense sentense)->{
								sentense.deleteMaxSubstring(substring);
								});
					});	
	}
	
	public void writeToFile(String destination) throws IOException{
		FileWriter fWriter=new FileWriter(destination);
		
	}
	

}
