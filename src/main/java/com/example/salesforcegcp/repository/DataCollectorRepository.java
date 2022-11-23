package com.example.salesforcegcp.repository;

import java.util.List;

public interface DataCollectorRepository {
    List<String> getTableDetails(String schemaName);
}
