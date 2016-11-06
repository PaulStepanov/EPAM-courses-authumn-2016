package logic.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.Obligation;

public class DescendingOrderSorter implements ObligationsSorter {

	@Override
	public ArrayList<Obligation> sort(List<Obligation> list,
			 Comparator<Obligation> comparator) {
		ArrayList<Obligation> result=new ArrayList<Obligation>();
		result.addAll(list);
		Collections.sort(result,
				Collections.reverseOrder(comparator));
		return result;
	}	
}
