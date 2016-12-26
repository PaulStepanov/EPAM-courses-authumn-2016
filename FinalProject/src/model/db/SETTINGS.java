package model.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * MySQL db settings singleton using in ConnectionManagerMySQLDriver
 */
class SETTINGS {
    private static SETTINGS settings = new SETTINGS();
    private Properties propertie = new Properties();

    private SETTINGS() {
        try {
            propertie.load(new FileInputStream(this.getClass().getClassLoader().getResource("sql.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getProp(String propname) {
        return settings.propertie.getProperty(propname);
    }
}
