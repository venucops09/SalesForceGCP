package com.example.salesforcegcp.service;

import com.example.salesforcegcp.repository.SalesforceDataCollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataCollectorService {

    @Autowired
    private SalesforceDataCollectorRepository salesforceDataCollectorRepository;

    public List<String> getTableDetailsFromSalesforce(String schemaName) {
        return salesforceDataCollectorRepository.getTableDetails(schemaName);
    }

    public List<String> getColumnDetails(String tableName) {
        return salesforceDataCollectorRepository.getColumnDetails(tableName);
    }
}
