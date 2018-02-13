package ua.lv.hoy.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lv.hoy.dao.AbstractDao;
import ua.lv.hoy.dao.CustomerDao;
import ua.lv.hoy.dao.FlatDao;
import ua.lv.hoy.dao.HouseDao;
import ua.lv.hoy.entity.Customer;
import ua.lv.hoy.entity.Flat;
import ua.lv.hoy.entity.House;
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
    @Autowired
    private AbstractDao abstractDao;
    @Autowired
    HouseDao houseDao;

    @Override
    public void addFlatToHouse(int houseId, Flat flat) {
        House house = houseDao.findById(houseId);
        flat.setHouse(house);
        if(flat.getRomsNumber()>0 && flat.getRomsNumber() <= 3){
            abstractDao.add(flat);
        }
    }

    public void edit(int flatId, Flat editedFlat) {
        Flat flat = flatDao.findById(flatId);
        if (editedFlat.getflatNumber()>0){
            flat.setflatNumber(editedFlat.getflatNumber());
        }
        if (editedFlat.getFloor() >0){
            flat.setFloor(editedFlat.getFloor());
        }
        if (editedFlat.getRomsNumber() >0){
            flat.setRomsNumber(editedFlat.getRomsNumber());
        }
        if (editedFlat.getProjectSize() >0){
            flat.setProjectSize(editedFlat.getProjectSize());
        }
        if (editedFlat.getRealSize() >0){
            flat.setRealSize(editedFlat.getRealSize());
        }
        if (editedFlat.getStatus() != null  && !editedFlat.getStatus().equalsIgnoreCase("")){
            flat.setStatus(editedFlat.getStatus());
        }
        if (editedFlat.getDescription() != null  && !editedFlat.getDescription().equalsIgnoreCase("")){
            flat.setDescription(editedFlat.getDescription());
        }

        abstractDao.edit(flat);

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

    public Flat findByNumber(int number) {
        return flatDao.findByNumber(number);
    }

    public List<Flat> findByCustomerId(int customerId) {
        return flatDao.findByCustomerId(customerId);
    }

    public void buy(int flatId, int customerId){

        if(flatId != -9999){
            Customer customer = customerDao.findById(customerId);
            Flat flat = flatDao.findById(flatId);

            if(flat.getStatus().equalsIgnoreCase("free")){
                flat.setStatus("sold");
                flat.setCustomer(customer);
                abstractDao.edit(flat);
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
        List<Flat> flats = new ArrayList<>();
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
