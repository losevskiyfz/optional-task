package com.losevskiyfz.service;

import com.losevskiyfz.repository.PhoneBookRepository;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
public class PhoneBookServiceImpl implements PhoneBookService {

    private final PhoneBookRepository phoneBookRepository;

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
