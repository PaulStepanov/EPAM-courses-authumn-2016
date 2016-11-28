package DAO;

import domain.FlightEntity;
import exeptions.PersistExeption;

/**
 * Created by Павел on 28-Nov-16.
 */
public interface FlightDAO  extends DAO<FlightEntity,String>{
    FlightEntity read(String key) throws PersistExeption;
}

