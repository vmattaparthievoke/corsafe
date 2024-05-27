package com.nti.corsafe.consigner;


import com.nti.corsafe.carrier.Carrier;
import com.nti.corsafe.site.Site;
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
    private String website;
    private String email;
    private String helplineNumber;
    @Relationship(type = "carrier")
    private List<Carrier> carriers;
    private List<Site> sites;

}
