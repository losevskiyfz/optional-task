package com.losevskiyfz.controller;

import com.losevskiyfz.service.PhoneBookService;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class PhoneBookControllerImpl implements PhoneBookController {

    private final PhoneBookService phoneBookService;

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
