package ua.lv.hoy.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lv.hoy.dao.CustomerDao;
import ua.lv.hoy.dao.FlatDao;
import ua.lv.hoy.entity.Customer;
import ua.lv.hoy.entity.Flat;
import ua.lv.hoy.entity.House;
import ua.lv.hoy.entity.Image;
import ua.lv.hoy.services.FlatService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 05-Mar-17.
 */
@Service
@Transactional
public class FlatServiceImpl implements FlatService {

    @Autowired
    private FlatDao flatDao;
    @Autowired
    private CustomerDao customerDao;

    public void add(int flatnumber, int floor, int romsNumber, double projectSize, double realSize,  String description) {
        if(romsNumber >0 && romsNumber <=3){
            flatDao.add( new Flat(flatnumber, floor, romsNumber, projectSize,
                    realSize, "free", description));
        }
    }

    public void edit(int id, int flatnumber, int floor, int romsNumber, double projectSize, double realSize, String status, String description) {
        Flat flat = flatDao.findById(id);
        if (flatnumber >0){
            flat.setFlatnumber(flatnumber);
        }
        if (floor >0){
            flat.setFloor(floor);
        }
        if (romsNumber >0){
            flat.setRomsNumber(romsNumber);
        }
        if (projectSize >0){
            flat.setProjectSize(projectSize);
        }
        if (realSize >0){
            flat.setRealSize(realSize);
        }
        if (status != null  && !status.equalsIgnoreCase("")){
            flat.setStatus(status);
        }
        if (description != null  && !description.equalsIgnoreCase("")){
            flat.setDescription(description);
        }

        flatDao.edit(flat);


    }

    public void delete(int id) {
        Flat flat = flatDao.findById(id);
        if(flat.getStatus().equalsIgnoreCase("free")){
            flatDao.delete(id);
        }

    }

    public Flat findById(int id) {
        return flatDao.findById(id);
    }

    public List<Flat> findAllFlats() {
        return flatDao.findAllFlats();
    }

    /*public List<Flat> findFreeFlats() {
        return flatDao.findFreeFlats();
    }*/

    public Flat findByNumber(int number) {
        return flatDao.findByNumber(number);
    }

    public List<Flat> findByCustomerId(int customer_id) {
        return flatDao.findByCustomerId(customer_id);
    }


    public void buy(int flatId, int customer_id){

        if(flatId != -9999){
            Customer customer = customerDao.findById(customer_id);
            Flat flat = flatDao.findById(flatId);

            if(flat.getStatus().equalsIgnoreCase("free")){
                flat.setStatus("sold");
                flat.setCustomer(customer);
                flatDao.edit(flat);
            }
        }
    }


    public void takeAway(int flatId, int customerId){
        if (flatId != -1){
            Flat flat =flatDao.findById(flatId);
            Customer customer = customerDao.findById(customerId);
            if(flat.getCustomer().equals(customer)){
                flat.setStatus("free");
                flat.setCustomer(null);
            }
        }
    }


    public List<Flat> findFreeFlatByRoomsNumber(int rooms, int houseId){
        List<Flat> freeFlats = flatDao.findFreeFlatsinHouse(houseId);
        List<Flat> flats = new ArrayList<Flat>();
        for (Flat f: freeFlats) {
            if(f.getRomsNumber() == rooms){
                flats.add(f);
            }
        }
        return flats;
    }


    @Override
    public List<Flat> findAllFlatsInHouse(int houseId) {
        return flatDao.findAllFlatsInHouse(houseId);
    }

    public List<Flat> findFreeFlatsInHouse(int houseId){
        return flatDao.findFreeFlatsinHouse(houseId);
    }
}