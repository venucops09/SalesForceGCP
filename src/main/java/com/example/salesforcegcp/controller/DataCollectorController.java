package com.example.salesforcegcp.controller;

import com.example.salesforcegcp.service.DataCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<String> getTableDataFromSalesforce(@PathVariable String schemaName) {
        return dataCollectorService.getTableDetailsFromSalesforce(schemaName);
    }

    @GetMapping("/salesforce/{tableName}")
    public List<String> getColumnDataFromSalesforce(@PathVariable String tableName) {
        return dataCollectorService.getColumnDetails(tableName);
    }
}
