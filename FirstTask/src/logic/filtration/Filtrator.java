package logic.filtration;

import java.util.List;

import domain.Obligation;

public interface Filtrator {
    public List<Obligation> filter(Filter filter);

    public void filter(Filter filter, List<Obligation> destVauchers);

}
/*
 * Найти обязательства в деривативе, соответствующее заданному диапазону
 * параметров
 */
