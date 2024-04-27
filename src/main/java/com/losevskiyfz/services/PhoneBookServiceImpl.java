package com.losevskiyfz.services;

import com.losevskiyfz.repositories.PhoneBookRepository;
import com.losevskiyfz.repositories.PhoneBookRepositoryImpl;

import java.util.NoSuchElementException;
import java.util.Optional;

public class PhoneBookServiceImpl implements PhoneBookService {

    private final PhoneBookRepository phoneBookRepository = new PhoneBookRepositoryImpl();

    @Override
    public Optional<String> findByName(String name) {
        return phoneBookRepository.findByName(name);
    }

    @Override
    public String getByName(String name) {
        return findByName(name).orElseThrow(
                () -> new NoSuchElementException("There is no contact with name " + name)
        );
    }

    @Override
    public String getServiceContact() {
        return findByName("Service").orElse("123456789");
    }

    @Override
    public void logServiceContact() {
        findByName("Service").ifPresentOrElse(
                serviceContact -> System.out.println("Service contact: " + serviceContact),
                () -> System.out.println("No service contact")
        );
    }

}
