package logic;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logicElements.Sentense;
import textReader.InputReader;

public class Deviner {
	private InputReader inputReader;
	private ArrayList<Sentense> sentences;

	public Deviner(InputReader inputReader) {
		this.inputReader = inputReader;
	}
	
	public void devine(){
		StringBuilder sBuilder=new StringBuilder();
		while (inputReader.hasNext()){
			sBuilder.append(inputReader.nextLine());
		}
		
		Pattern pattern = Pattern.compile("\\b((?!=|\\.).)+(.)\\b");
		Matcher matcher = pattern.matcher(sBuilder);
		while(matcher.find()){
			sentences.add(new Sentense(matcher.group()));
		}
		
	}
	
	
	
	

}
