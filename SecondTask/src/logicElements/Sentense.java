package logicElements;

import java.io.File;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentense {
    private String fullVal;
    private HashMap<Integer, SentenseElement> elements=new HashMap<>() ;
    
	public Sentense(String fullVal) {
		this.fullVal = fullVal;
		splitOnElements();
	}
    
   private void splitOnElements(){
	   Pattern pattern = Pattern.compile("([^\\s]+\\w)|([^\\s]\\W)");
	   Matcher matcher = pattern.matcher(fullVal);
	   while (matcher.find()){
		   System.out.println(matcher.group());
		   elements.put(matcher.start(),
				   		ElementCreator.createElem(matcher.group()));
	   }
   }

	public HashMap<Integer, SentenseElement> getElements() {
		return elements;
	}
}
