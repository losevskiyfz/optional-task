package com.losevskiyfz.repositories;

import java.util.Optional;

public interface PhoneBookRepository {
    Optional<String> findByName(String name);
}
