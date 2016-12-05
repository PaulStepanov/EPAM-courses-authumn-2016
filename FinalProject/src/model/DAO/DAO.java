package model.DAO;

import model.domain.Entity;
import model.exeptions.PersistExeption;

public interface DAO<Type extends Entity> {
    public Type read(Integer key) throws PersistExeption;

    public void delete(Integer key) throws PersistExeption;

    public Integer create(Type type) throws PersistExeption;

    public void update(Type type) throws PersistExeption;

}
