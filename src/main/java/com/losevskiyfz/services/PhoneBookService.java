package com.losevskiyfz.services;

import com.losevskiyfz.repositories.PhoneBookRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

public class PhoneBookService {

    private final PhoneBookRepository phoneBookRepository = new PhoneBookRepository();

    public Optional<String> findByName(String name) {
        return phoneBookRepository.findByName(name);
    }

    public String getByName(String name) throws NoSuchElementException {
        return findByName(name).orElseThrow(
                () -> new NoSuchElementException("There is no contact with name " + name)
        );
    }

    public String getServiceContact() {
        return findByName("Service").orElse("123456789");
    }

    public void logServiceContact() {
        findByName("Service").ifPresentOrElse(
                serviceContact -> System.out.println("Service contact: " + serviceContact),
                () -> System.out.println("No service contact")
        );
    }

}
