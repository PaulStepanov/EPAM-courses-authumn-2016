package model.exeptions;

import java.sql.SQLException;

/**
 * SQL exception wrapper using in DAO to specialize exeption by DAO methods
 * and not to break polymorphism rule
 */
public class PersistExeption extends SQLException {
    public PersistExeption(String reason) {
        super(reason);
    }

    public PersistExeption() {
    }
}
