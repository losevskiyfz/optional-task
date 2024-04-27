package com.losevskiyfz.controllers;

import com.losevskiyfz.services.PhoneBookService;
import com.losevskiyfz.services.PhoneBookServiceImpl;

import java.util.Optional;

public class PhoneBookControllerImpl implements PhoneBookController {

    private final PhoneBookService phoneBookService = new PhoneBookServiceImpl();

    @Override
    public String getByName(String name){
        Optional<String> optionalName = phoneBookService.findByName(name);
        return optionalName.orElse("Name " + name + " is not found");
    }

    @Override
    public String getServiceContact() {
        phoneBookService.logServiceContact();
        return phoneBookService.getServiceContact();
    }

}
