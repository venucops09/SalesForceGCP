package com.example.salesforcegcp.mapper;

import com.example.salesforcegcp.entity.SalesforceRowDataEntity;
import com.example.salesforcegcp.model.SalesforceRowData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesforceEntityMapper {

    SalesforceEntityMapper INSTANCE = Mappers.getMapper(SalesforceEntityMapper.class);

    SalesforceRowDataEntity toEntity(SalesforceRowData salesforceRowData);
}
