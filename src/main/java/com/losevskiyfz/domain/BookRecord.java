package com.losevskiyfz.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookRecord {
    private String name;
    private String phoneNumber;
}
