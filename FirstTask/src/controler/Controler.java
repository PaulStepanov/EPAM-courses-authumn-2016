package controler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import domain.Deritative;
import logic.sorting.DescendingOrderSorter;
import logic.sorting.RiskComparator;
import storage.Storage;
import view.View;

public class Controler {
	private InputStream iStream;
	private Storage storage;
	private View view;
	
	public Controler(InputStream iStream, Storage storage, View view) {
		this.iStream = iStream;
		this.storage = storage;
		this.view = view;
	}
	
	public void run(){
		Deritative deritative=storage.getDertitative("testDeritative");
		view.renderMessage("All deritative:");
		view.renderDeritative(deritative);
		
		view.renderMessage("Sort in descending oreder by risk:");
		DescendingOrderSorter dSorter=new DescendingOrderSorter();
		view.renderObligations(
				dSorter.sort(deritative.getObligations(), new RiskComparator()));
		
		view.renderMessage("To filter by:\n"
				+ "1-Percents\n"
				+ "2-Property\n"
				+ "3-Risk\n"
				+ "4-Terms");
		Scanner scaner=new Scanner(iStream);
		int chosenNumber=scaner.nextInt();
		switch (chosenNumber) {
		case 1:			
			break;

		default:
			break;
		}
	}			
}
