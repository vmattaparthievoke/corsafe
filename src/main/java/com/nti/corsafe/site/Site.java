package com.nti.corsafe.site;

import com.nti.corsafe.member.Member;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@Node
public class Site {
    @Relationship(type = "located-at")
    private Address address;
    private String name;
    private boolean headOffice;
    private List<String> functions;
    @Relationship(type = "owner")
    private Member siteOwner;
    @Relationship(type = "driver")
    private List<Member> drivers;
    @Relationship(type = "manager")
    private List<Member> siteManagers;
    @Relationship(type = "siteInspector")
    private List<Member> siteInspectors;




}
