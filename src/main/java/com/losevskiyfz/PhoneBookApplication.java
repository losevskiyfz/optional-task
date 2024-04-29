package com.losevskiyfz;

import com.losevskiyfz.controller.PhoneBookController;
import com.losevskiyfz.repository.PhoneBookHashMapRepository;
import com.losevskiyfz.service.PhoneBookServiceImpl;

class PhoneBookApplication {
    public static void main(String[] args) {
        new PhoneBookController(
                new PhoneBookServiceImpl(
                        new PhoneBookHashMapRepository()
                )
        ).run();
    }
}
