package com.nti.corsafe.site;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class Address {

    @Id
    private String id;
    private String addressLine1;
    private String addressLine2;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;

}
