package com.example.salesforcegcp.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class SalesforceRowData {

    private ItemAttributes itemAttributes;
    private String Id;
    private String IsDeleted;
    private String MasterRecordId;
    private String Name;
    private String Type;
    private String ParentId;
    private String BillingStreet;
    private String BillingCity;
    private String BillingState;
    private String AccountNumber;

}
