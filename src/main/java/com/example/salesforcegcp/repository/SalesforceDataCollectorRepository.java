package com.example.salesforcegcp.repository;

import com.example.salesforcegcp.entity.BrowserHistory;
import com.example.salesforcegcp.entity.SalesforceRowDataEntity;
import com.example.salesforcegcp.mapper.SalesforceEntityMapper;
import com.example.salesforcegcp.model.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
@Log
public class SalesforceDataCollectorRepository {

    @Value("${salesforce.connection.url}")
    private String url;

    @Value("${salesforce.connection.client_id}")
    private String client_id;

    @Value("${salesforce.connection.client_secret}")
    private String client_secret;

    @Value("${salesforce.connection.username}")
    private String username;

    @Value("${salesforce.connection.password}")
    private String password;

    @Autowired
    BrowserHistoryRepo browserHistoryRepo;

    @Autowired
    SalesforceEntityMapper salesforceEntityMapper;

    public List<String> getTableDetails(String schemaName) {
        RestTemplate restTemplate = new RestTemplate();
        List<String> tableNames = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        SalesforceTokenResponse salesforceTokenResponse = getSalesforceTokenResponse();

        //CALLING ENDPOINT FOR RETRIEVING ALL THE TABLES
        headers.set("Authorization", "Bearer "+ salesforceTokenResponse.getAccess_token());
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<SalesForceTableNames> response = restTemplate.exchange(
                salesforceTokenResponse.getInstance_url()+"/services/data/v25.0/sobjects/", HttpMethod.GET, requestEntity, SalesForceTableNames.class);
        SalesForceTableNames salesForceTableNames = response.getBody();

        //GETTING THE TABLE NAMES FROM RESPONSE
        for(SObject sObject: salesForceTableNames.getSObjects()){
            tableNames.add(sObject.getName());
        }

        return tableNames;
    }

    private SalesforceTokenResponse getSalesforceTokenResponse() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("grant_type", "password");
        params.add("client_id", client_id);
        params.add("client_secret", client_secret);
        params.add("username", username);
        params.add("password", password);

        //TO GET THE TOKEN FOR ACCESSING SOBJECTS(TABLES)
        SalesforceTokenResponse salesforceTokenResponse = restTemplate.postForObject( url, params, SalesforceTokenResponse.class);
        return salesforceTokenResponse;
    }


    public SalesForceColumnNames getColumnDetails(String tableName) {
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        List<String> columnDetails = new ArrayList<>();
        SalesforceTokenResponse salesforceTokenResponse = getSalesforceTokenResponse();

        //CALLING ENDPOINT FOR RETRIEVING ALL THE TABLES
        headers.set("Authorization", "Bearer "+ salesforceTokenResponse.getAccess_token());
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<SalesForceColumnNames> response = restTemplate.exchange(
                salesforceTokenResponse.getInstance_url()+"/services/data/v25.0/sobjects/"+tableName, HttpMethod.GET, requestEntity, SalesForceColumnNames.class);
        SalesForceColumnNames salesForceColumnNames = response.getBody();

        System.out.println(salesForceColumnNames.toString());
        //GETTING THE TABLE NAMES FROM RESPONSE
        List<RecentItems> recentItems = salesForceColumnNames.getRecentItems();

        return salesForceColumnNames;
    }

    public SalesforceRowData getAllDataFromTable(String tableName, String rowId) {
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        List<String> tableDetails = new ArrayList<>();
        SalesforceTokenResponse salesforceTokenResponse = getSalesforceTokenResponse();

        //CALLING ENDPOINT FOR RETRIEVING ALL THE TABLES
        headers.set("Authorization", "Bearer "+ salesforceTokenResponse.getAccess_token());
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<SalesforceRowData> response = restTemplate.exchange(
                salesforceTokenResponse.getInstance_url()+"/services/data/v25.0/sobjects/"+tableName+ "/" +rowId, HttpMethod.GET, requestEntity, SalesforceRowData.class);
        SalesforceRowData salesforceRowData = response.getBody();

        System.out.println(salesforceRowData.toString());

        //Saving the record data into GCP
        browserHistoryRepo.save(salesforceEntityMapper.toEntity(salesforceRowData));

        System.out.println("SAVED TO new GCPssss");


        return salesforceRowData;
    }
}
