package com.example.salesforcegcp.entity;

import lombok.*;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrowserHistory {
    @Id
    private Long id;

    private String name;

    private String url;

}
