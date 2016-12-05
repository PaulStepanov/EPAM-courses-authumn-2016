package view;

import model.domain.Deritative;
import model.domain.Obligation;

import java.util.List;

public class ConsoleView implements View {

    @Override
    public void renderObligations(List<Obligation> obligations) {
        for (Obligation oblig : obligations) {
            System.out.print("Type:" + oblig.getType() + "--");
            System.out.print("Perc:" + oblig.getPercents() + "--");
            System.out.print("Risk:" + oblig.getRiskDegree() + "--");
            System.out.print("Terms:" + oblig.getTerms() + "--");
            System.out.println("Prop:" + oblig.getProperty());
        }
    }

    @Override
    public void renderDeritative(Deritative deritative) {
        renderObligations(deritative.getObligations());
    }

    @Override
    public void renderMessage(String str) {
        System.out.println(str);

    }

}
