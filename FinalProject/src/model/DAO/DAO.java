package model.DAO;

import model.domain.Entity;
import model.exeptions.PersistExeption;

public interface DAO<Type extends Entity> {
    Type read(Integer key) throws PersistExeption;

    void delete(Integer key) throws PersistExeption;

    Integer create(Type type) throws PersistExeption;

    void update(Type type) throws PersistExeption;

}
