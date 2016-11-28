package dao;

import domain.Entity;
import exeptions.PersistExeption;

/**
 * Created by Павел on 28-Nov-16.
 */
public interface DAO<Type extends Entity,KeyType>{
    public Type read(KeyType key) throws PersistExeption;

    public void delete(KeyType key) throws PersistExeption;

    public KeyType create(Type type) throws PersistExeption;

    public void update(Type type) throws PersistExeption;

}
