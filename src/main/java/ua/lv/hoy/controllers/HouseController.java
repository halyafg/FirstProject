package ua.lv.hoy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lv.hoy.entity.House;
import ua.lv.hoy.services.FlatService;
import ua.lv.hoy.services.HouseService;
import ua.lv.hoy.services.PantryService;
import ua.lv.hoy.services.ParkingService;

/**
 * Created by Administrator on 07-Apr-17.
 */
@Controller
public class HouseController {

    static final String HOUSE_ID = "houseId";
    static final String HOUSE = "house";

    @Autowired
    private HouseService houseService;
    @Autowired
    private  FlatService flatService;
    @Autowired
    private  PantryService pantryService;
    @Autowired
    private ParkingService parkingService;

   @RequestMapping(value = "/house/page/{houseId}", method = RequestMethod.GET)
    private String housePage(@PathVariable Integer houseId, Model model){
        model.addAttribute(HOUSE, houseService.findById(houseId));
        model.addAttribute("flats1", flatService.findFreeFlatByRoomsNumber(1,houseId));
        model.addAttribute("flats2", flatService.findFreeFlatByRoomsNumber(2,houseId));
        model.addAttribute("flats3", flatService.findFreeFlatByRoomsNumber(3, houseId));
        model.addAttribute("freePantries", pantryService.fiindFreePantriesInHouse(houseId));
        model.addAttribute("freeParkings", parkingService.findFreeParkings(houseId));
        return "housePage";
    }

   @RequestMapping(value = "/houses/addpage", method = RequestMethod.GET)
    private String addHousePage(Model model){
        model.addAttribute("house", new House());
        return "addHouse";
    }

    @RequestMapping(value = "/house/add", method = RequestMethod.POST)
    private String addHouse(@ModelAttribute House house){
        houseService.add(house);
        return BaseController.REDIRECT_HOME_PAGE;
    }

    @RequestMapping(value = "/house/editpage/{houseId}", method = RequestMethod.GET)
    private  String openEditHousePage(@PathVariable Integer houseId, Model model){
        House house = houseService.findById(houseId);
        model.addAttribute(HOUSE, house);
        return "editHouse";
    }
    @RequestMapping(value = "/house/edit", method = RequestMethod.POST)
    private String editHouse(@ModelAttribute House editedHouse){
        houseService.edit(editedHouse.getId(), editedHouse);
        return BaseController.REDIRECT_HOME_PAGE;
    }

    @RequestMapping(value = "/house/delete/{houseId}", method = RequestMethod.GET)
    private String deleteHouse(@PathVariable Integer houseId){
        houseService.delete(houseId);
        return BaseController.REDIRECT_HOME_PAGE;
    }

}
