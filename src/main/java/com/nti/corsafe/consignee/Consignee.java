package com.nti.corsafe.consignee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nti.corsafe.carrier.Carrier;
import com.nti.corsafe.member.Member;
import com.nti.corsafe.site.Site;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Consignee {
    @Id
    private String id;
    private String name;
    private String website;
    private String email;
    private String helplineNumber;
    @Relationship(type = "COMPLIANCE_MANAGER")
    private Member complianceManager;
    @Relationship(type = "CARRIER", direction = Relationship.Direction.INCOMING)
    private List<Carrier> carriers = new ArrayList<>();
    @Relationship(type = "SITE")
    private List<Site> sites = new ArrayList<>();
}
