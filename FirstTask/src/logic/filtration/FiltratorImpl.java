package logic.filtration;

import model.domain.Obligation;

import java.util.ArrayList;
import java.util.List;

public class FiltratorImpl implements Filtrator {
    private List<Obligation> oblList;

    public FiltratorImpl(List<Obligation> oblList) {
        this.oblList = oblList;
    }

    public void setOblList(List<Obligation> oblList) {
        this.oblList = oblList;
    }

    @Override
    public List<Obligation> filter(Filter filter) {
        ArrayList<Obligation> result = new ArrayList<>();
        for (Obligation obl : oblList) {
            if (filter.isSatisfy(obl)) {
                result.add(obl);
            }
        }
        return result;
    }

    @Override
    public void filter(Filter filter, List<Obligation> destVauchers) {
        for (Obligation obl : oblList) {
            if (filter.isSatisfy(obl)) {
                destVauchers.add(obl);
            }
        }
    }

}
