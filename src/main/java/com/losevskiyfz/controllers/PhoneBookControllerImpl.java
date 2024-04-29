package com.losevskiyfz.controllers;

import com.losevskiyfz.services.PhoneBookService;

import java.util.Optional;

public class PhoneBookControllerImpl implements PhoneBookController {

    private final PhoneBookService phoneBookService;

    public PhoneBookControllerImpl(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

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
