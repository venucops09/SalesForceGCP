package com.example.salesforcegcp.repository;

import com.example.salesforcegcp.entity.BrowserHistory;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface BrowserHistoryRepo extends DatastoreRepository<BrowserHistory,Long> {
}
