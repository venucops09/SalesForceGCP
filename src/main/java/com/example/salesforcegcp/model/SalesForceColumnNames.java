package com.example.salesforcegcp.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class SalesForceColumnNames {

    private List<Field> fields;

}
