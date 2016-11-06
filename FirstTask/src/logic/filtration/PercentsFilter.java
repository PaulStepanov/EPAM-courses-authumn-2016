package logic.filtration;

import domain.Obligation;

public class PercentsFilter implements Filter {
	private int min;
	private int max;
	
	public PercentsFilter(int min, int max) {
		if (min>max) {
			this.min = max;
			this.max = min;
		} else {
			this.min = min;
			this.max = max;
		}	
		
	}
	
	@Override
	public boolean isSatisfy(Obligation obl) {
		if (obl.getPercents()>=min &&  obl.getPercents()<=max){
			return true;
		}
		return false;
	}

}
