package logic.filtration;

import domain.Obligation;

public interface Filter {
	public boolean  isSatisfy(Obligation obl);
}
