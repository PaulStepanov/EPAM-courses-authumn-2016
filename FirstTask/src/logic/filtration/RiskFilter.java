package logic.filtration;

import domain.Obligation;

public class RiskFilter implements Filter {
	private double min;
	private double max;
	
	public RiskFilter(double min, double max) {
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
		if (obl.getRiskDegree()>=min &&  obl.getRiskDegree()<=max){
			return true;
		}
		return false;
	}

}
