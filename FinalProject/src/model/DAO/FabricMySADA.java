package model.DAO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create required dao
 * parameter can be Interface DAO class, like CityDAO.class ,
 * whe we pass Interface class fabric use validation inside to use necessary implementation.
 * Also it can be exact implementation, like  CityMySQLDAO.class .
 */
public class FabricMySADA {
    private static FabricMySADA instance = new FabricMySADA();
    private HashMap<Class, Class> validationMap = new HashMap<>();

    public FabricMySADA() {
        validationMap.put(CityDAO.class, CityMySQLDAO.class);
        validationMap.put(ClientDAO.class, ClientMySQLDAO.class);
        validationMap.put(CurrentFlightDao.class, CurrentFlightMySQLDAO.class);
        validationMap.put(FlightDAO.class, FlightMySQLDAO.class);
        validationMap.put(TicketDAO.class, TicketMySQLDAO.class);
        validationMap.put(UserDAO.class, UserMySQLDAO.class);
    }

    public DBDAO<?> createDAO(Class classDAO) {
        classDAO = validateClassImplClass(classDAO);
        final Class<?>[] parmTypes = classDAO.getConstructors()[0].getParameterTypes();
        ArrayList<Object> concreteParams = new ArrayList<Object>();
        for (int i = 0; i < parmTypes.length; i++) {
            try {
                Constructor constructor = classDAO.getConstructor(parmTypes);
                DBDAO<?> param;
                if (i == parmTypes.length - 1) {
                    param = null;
                    concreteParams.add(param);
                    return (DBDAO<?>) constructor.newInstance(concreteParams.toArray());
                } else {
                    param = createDAO(parmTypes[i]);
                    concreteParams.add(param);
                }
            } catch (NoSuchMethodException
                    | InvocationTargetException
                    | InstantiationException
                    | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static DBDAO<?> getDAO(Class classDAO) {
        return instance.createDAO(classDAO);
    }

    private Class validateClassImplClass(Class clas) {
        Class result = validationMap.get(clas);
        return result != null ? result : clas;
    }
}
