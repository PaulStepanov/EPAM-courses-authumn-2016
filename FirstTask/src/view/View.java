package view;

import java.util.List;

import domain.Deritative;
import domain.Obligation;

public interface View {

    public void renderMessage(String str);

    public void renderDeritative(Deritative deritative);

    public void renderObligations(List<Obligation> obligations);
}
