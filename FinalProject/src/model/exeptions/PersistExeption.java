package model.exeptions;

import java.sql.SQLException;

/**
 * Created by Павел on 28-Nov-16.
 */
public class PersistExeption extends SQLException {
    public PersistExeption(String reason) {
        super(reason);
    }

    public PersistExeption() {
    }
}
