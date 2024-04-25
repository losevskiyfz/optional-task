package com.losevskiyfz.controllers;

import com.losevskiyfz.services.PhoneBookService;

import java.util.NoSuchElementException;

public class PhoneBookController {

    private final PhoneBookService phoneBookService = new PhoneBookService();

    public String getByName(String name) throws NoSuchElementException {
        return phoneBookService.getByName(name);
    }

    public String getServiceContact() {
        phoneBookService.logServiceContact();
        return phoneBookService.getServiceContact();
    }

}
