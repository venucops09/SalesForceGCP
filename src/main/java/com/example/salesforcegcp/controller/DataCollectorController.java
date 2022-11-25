package com.example.salesforcegcp.controller;

import com.example.salesforcegcp.model.SalesForceColumnNames;
import com.example.salesforcegcp.model.SalesforceRowData;
import com.example.salesforcegcp.service.DataCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/from")
public class DataCollectorController {

    @Autowired
    private DataCollectorService dataCollectorService;

    @GetMapping("/salesforce/{schemaName}/tables")
    public List<String> getTableNamesFromSalesforce(@PathVariable String schemaName) {
        return dataCollectorService.getTableDetailsFromSalesforce(schemaName);
    }

    @GetMapping(value = "/salesforce/{tableName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SalesForceColumnNames getColumnNamesFromSalesforce(@PathVariable String tableName) {
        return dataCollectorService.getColumnDetails(tableName);
    }

    @GetMapping(value = "/salesforce/data/{tableName}/{rowId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SalesforceRowData getAllDataFromSalesforce(@PathVariable String tableName, @PathVariable String rowId) {
        return dataCollectorService.getAllDataFromTable(tableName, rowId);
    }
}
