package com.nti.corsafe.carrier;

import com.nti.corsafe.site.Site;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
public class Carrier {
    @Id
    private String id;
    private String name;
    private String category;
    private String website;
    private String email;
    private String helplineNumber;
    @Relationship(type="operating-at")
    private List<Site> sites = new ArrayList<>();

}