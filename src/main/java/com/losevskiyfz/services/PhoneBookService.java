package com.losevskiyfz.services;

import java.util.Optional;

public interface PhoneBookService {
    Optional<String> findByName(String name);

    String getByName(String name);

    String getServiceContact();

    void logServiceContact();
}
