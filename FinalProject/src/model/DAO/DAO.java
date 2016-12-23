package model.DAO;

import model.domain.Entity;
import model.exeptions.PersistExeption;

/**
 * Created by frees on 19.12.2016.
 */
public interface DAO<Type extends Entity>{
    public Type read(Integer key) throws PersistExeption;

    public void delete(Integer key) throws PersistExeption;

    public Integer create(Type type) throws PersistExeption;

    public void update(Type type) throws PersistExeption;

}
