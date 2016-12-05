package logic.filtration;

import model.domain.Obligation;

public interface Filter {
    public boolean isSatisfy(Obligation obl);
}
