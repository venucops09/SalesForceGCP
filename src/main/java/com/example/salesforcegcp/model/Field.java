package com.example.salesforcegcp.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Field {

    private String name;
}
