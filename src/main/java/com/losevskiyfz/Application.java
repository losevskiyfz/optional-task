package com.losevskiyfz;

import com.losevskiyfz.clientapp.ClientApp;
import com.losevskiyfz.controllers.PhoneBookControllerImpl;
import com.losevskiyfz.repositories.PhoneBookHashMapRepository;
import com.losevskiyfz.services.PhoneBookServiceImpl;

public class Application {

    public static void main(String[] args) {
        new ClientApp(
                new PhoneBookControllerImpl(
                        new PhoneBookServiceImpl(
                                new PhoneBookHashMapRepository()
                        )
                )
        ).run();
    }

}
