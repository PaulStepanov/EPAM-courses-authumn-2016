package view;

import domain.Deritative;
import domain.Obligation;

import java.util.List;

public interface View {

    public void renderMessage(String str);

    public void renderDeritative(Deritative deritative);

    public void renderObligations(List<Obligation> obligations);
}
