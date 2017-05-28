package ua.lv.hoy.dao;

import ua.lv.hoy.entity.Flat;
import ua.lv.hoy.entity.Image;

import java.util.List;

/**
 * Created by Administrator on 26-Feb-17.
 */
public interface FlatDao {
    void add(Flat flat);

    void edit(Flat flat);

    void delete(int id);

    Flat findById (int id);


    List<Flat> findAllFlats();

    List<Flat> findFreeFlatsinHouse(int houseId);

    Flat findByNumber(int number);

    List<Flat> findByCustomerId(int customer_id);


    List<Flat> findAllFlatsInHouse(int houseId);

}