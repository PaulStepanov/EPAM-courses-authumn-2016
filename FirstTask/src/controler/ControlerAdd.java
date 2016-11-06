package controler;

import java.io.InputStream;
import java.util.Comparator;
import java.util.List;

import domain.Deritative;
import domain.Obligation;
import logic.filtration.Filter;

public interface ControlerAdd {

	public void setInputStream(InputStream inp);
	
	public Deritative createDeritative();
	
	public int countCost();
	
	public List<?> sortDeritative(Comparator<Obligation> compar);
	
	public List<?> filterDeritative(Filter filter);
}
