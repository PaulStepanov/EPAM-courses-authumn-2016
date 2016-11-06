package logic.filtration;

import domain.Obligation;

public class PropertyFilter implements Filter {
	private int min;
	private int max;
	
	public PropertyFilter(int min, int max) {
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
		if (obl.getProperty()>=min &&  obl.getProperty()<=max){
			return true;
		}
		return false;
	}

}
