package com.example.salesforcegcp.repository;

import com.example.salesforcegcp.entity.SalesforceRowDataEntity;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface BrowserHistoryRepo extends DatastoreRepository<SalesforceRowDataEntity,Long> {
}
