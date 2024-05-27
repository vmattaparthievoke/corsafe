package com.nti.corsafe.consigner;


import com.nti.corsafe.carrier.Carrier;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
@Data
public class Consignor {

    @Id
    private String id;
    private String name;
    private String category;
    @Relationship(type = "carrier")
    private List<Carrier> carriers;

}
