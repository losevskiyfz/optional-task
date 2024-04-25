package com.losevskiyfz.repositories;

import com.losevskiyfz.domain.BookRecord;

import java.util.HashMap;
import java.util.Optional;

public class PhoneBookRepository {

    private final HashMap<String, String> bookRecordsStorage = new HashMap<>();

    public PhoneBookRepository() {
        initializeStorage();
    }

    private void initializeStorage() {
        BookRecord[] initRecords = new BookRecord[]{
                BookRecord.builder().name("Alex").phoneNumber("2-11-98").build(),
                BookRecord.builder().name("Bob").phoneNumber("2-73-95").build(),
                BookRecord.builder().name("Jack").phoneNumber("2-43-11").build(),
                BookRecord.builder().name("John").phoneNumber("2-73-32").build(),
                BookRecord.builder().name("Jack").phoneNumber("2-35-68").build(),
        };
        for (BookRecord bookRecord : initRecords) {
            bookRecordsStorage.put(bookRecord.getName(), bookRecord.getPhoneNumber());
        }
    }

    public Optional<String> findByName(String name) {
        return Optional.ofNullable(bookRecordsStorage.get(name));
    }

}
