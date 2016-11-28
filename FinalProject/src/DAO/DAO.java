package DAO;

import domain.Entity;
import exeptions.PersistExeption;

/**
 * Created by Павел on 28-Nov-16.
 */
public interface DAO<Type extends Entity>{
    public Type read(Integer key) throws PersistExeption;

    public void delete(Integer key) throws PersistExeption;

    public Integer create(Type type) throws PersistExeption;

    public void update(Type type) throws PersistExeption;

}
