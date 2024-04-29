package com.losevskiyfz.repository;

import com.losevskiyfz.domain.BookRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBookHashMapRepository implements PhoneBookRepository {

    private Map<String,String> bookRecordsStorage;

    public PhoneBookHashMapRepository() {
        initializeStorage();
    }

    private void initializeStorage() {
        bookRecordsStorage = Stream.of(
                        BookRecord.builder().name("Alex").phoneNumber("2-44-18").build(),
                        BookRecord.builder().name("Bob").phoneNumber("2-73-95").build(),
                        BookRecord.builder().name("Jack").phoneNumber("2-43-11").build(),
                        BookRecord.builder().name("John").phoneNumber("2-73-32").build(),
                        BookRecord.builder().name("Josh").phoneNumber("2-35-68").build()
                )
                .collect(
                        Collectors.toMap(
                                BookRecord::getName,
                                BookRecord::getPhoneNumber,
                                (first, second) -> second,
                                HashMap::new
                        )
                );
    }

    @Override
    public Optional<String> findByName(String name) {
        return Optional.ofNullable(bookRecordsStorage.get(name));
    }

}
