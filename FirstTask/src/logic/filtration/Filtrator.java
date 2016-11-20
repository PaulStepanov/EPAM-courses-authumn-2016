package logic.filtration;

import domain.Obligation;

import java.util.List;

public interface Filtrator {
    public List<Obligation> filter(Filter filter);

    public void filter(Filter filter, List<Obligation> destVauchers);

}
/*
 * Найти обязательства в деривативе, соответствующее заданному диапазону
 * параметров
 */
