package com.example.salesforcegcp.entity;

import com.example.salesforcegcp.model.ItemAttributes;
import lombok.*;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;


@Entity
@Getter
@Setter
public class SalesforceRowDataEntity {

    @org.springframework.data.annotation.Id
    private Long Id;
    private String IsDeleted;
    private String MasterRecordId;
    private String Name;

}
