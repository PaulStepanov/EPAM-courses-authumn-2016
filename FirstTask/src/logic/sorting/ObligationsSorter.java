package logic.sorting;

import java.util.List;

import domain.Obligation;

import java.util.ArrayList;
import java.util.Comparator;

public interface ObligationsSorter {
	
	public List<Obligation> sort(List<Obligation> list,
			 Comparator<Obligation> comparator);
	
}
