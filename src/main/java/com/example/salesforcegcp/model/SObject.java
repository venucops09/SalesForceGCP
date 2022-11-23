package com.example.salesforcegcp.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class SObject {
    private String name;
}
