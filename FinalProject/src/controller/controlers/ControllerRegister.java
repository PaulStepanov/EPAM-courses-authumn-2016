package controller.controlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Register controllers that than executes by calling activateControllers method
 */
public class ControllerRegister {
    private ArrayList<ControllerExecuter> controllers = new ArrayList<>();

    public void registerController(Controller controller) {
        controllers.add(new ControllerExecuter(controller));
    }

    public void activateControllers(HttpServletRequest request, HttpServletResponse response) {
        controllers.forEach(controllerExecute -> controllerExecute.initExecutor(request, response));
    }
}
