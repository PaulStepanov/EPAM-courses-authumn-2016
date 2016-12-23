package model.DAO;

import model.domain.Entity;

import java.sql.Connection;

public interface DBDAO<Type extends Entity> extends DAO<Type>{
    public void setConnection(Connection connection);
    public Connection getConnection();

}
