package com.example.salesforcegcp.service;

import com.example.salesforcegcp.model.SalesForceColumnNames;
import com.example.salesforcegcp.model.SalesforceRowData;
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

    public SalesForceColumnNames getColumnDetails(String tableName) {
        return salesforceDataCollectorRepository.getColumnDetails(tableName);
    }

    public SalesforceRowData getAllDataFromTable(String tableName, String rowId) {
        return salesforceDataCollectorRepository.getAllDataFromTable(tableName, rowId);
    }
}
