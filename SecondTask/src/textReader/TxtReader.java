package textReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TxtReader implements InputReader {

    private Scanner scanner;
    
    
    public TxtReader(String fileLocation) throws FileNotFoundException {
		this.setFile(fileLocation); 	
	}

	@Override
    public String nextLine() {
        return scanner.nextLine();
    }
    
    public void setFile(String fileLocation) throws FileNotFoundException {
    	FileReader fileReader=new FileReader(fileLocation);
		scanner=new Scanner(fileReader); 
    }

	@Override
	public boolean hasNext() {
		return scanner.hasNext();
	};

}
