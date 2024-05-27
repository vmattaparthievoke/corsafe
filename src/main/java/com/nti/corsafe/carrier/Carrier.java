package com.nti.corsafe.carrier;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class Carrier {

    @Id
    private String id;
    private String category;
    private String name;

}