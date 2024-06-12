package com.nti.corsafe.common.model;

import org.neo4j.driver.Value;
import org.neo4j.driver.Values;
import org.springframework.data.neo4j.core.convert.Neo4jConversionService;
import org.springframework.data.neo4j.core.convert.Neo4jPersistentPropertyToMapConverter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public class AddressConverter implements Neo4jPersistentPropertyToMapConverter<String, Address> {

    @NonNull
    @Override
    public Map<String, Value> decompose(@Nullable Address property, Neo4jConversionService conversionService) {

        final HashMap<String, Value> decomposed = new HashMap<>();
        if (property == null) {
            decomposed.put("addressLine1", Values.NULL);
            decomposed.put("addressLine2", Values.NULL);
            decomposed.put("street", Values.NULL);
            decomposed.put("city", Values.NULL);
            decomposed.put("state", Values.NULL);
            decomposed.put("country", Values.NULL);
            decomposed.put("zip", Values.NULL);
        } else {
            decomposed.put("addressLine1", Values.value(property.getAddressLine1()));
            decomposed.put("addressLine2", Values.value(property.getAddressLine2()));
            decomposed.put("street", Values.value(property.getStreet()));
            decomposed.put("city", Values.value(property.getCity()));
            decomposed.put("state", Values.value(property.getState()));
            decomposed.put("country", Values.value(property.getCountry()));
            decomposed.put("zip", Values.value(property.getZip()));
        }
        return decomposed;
    }

    @Override
    public Address compose(Map<String, Value> source, Neo4jConversionService conversionService) {
        return source.isEmpty() ?
                null :
                new Address(
                        source.get("addressLine1").asString(),
                        source.get("addressLine2").asString(),
                        source.get("street").asString(),
                        source.get("city").asString(),
                        source.get("state").asString(),
                        source.get("country").asString(),
                        source.get("zip").asString()
                );
    }
}