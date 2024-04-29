package com.losevskiyfz.repository;

import java.util.Optional;

public interface PhoneBookRepository {
    Optional<String> findByName(String name);
}
