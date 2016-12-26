package controller.controlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ControlerRegister {
    ArrayList<ControlerExecuter> controlers=new ArrayList<>();

    public ControlerRegister() {

    }

    public void registerControler(Controler controler){
        controlers.add(new ControlerExecuter(controler));
    }

    public void activateControlers(HttpServletRequest request, HttpServletResponse response) {
        controlers.forEach(controlerExecuter -> {
            controlerExecuter.initExecutor(request,response);
        });
    }
}
