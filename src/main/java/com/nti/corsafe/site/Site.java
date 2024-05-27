package com.nti.corsafe.site;

import com.nti.corsafe.member.Member;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Data
@Node
public class Site {

    @Id
    private String id;
    @Relationship(type = "located-at")
    private Address address;
    private String name;
    private boolean headOffice;
    private List<String> functions = new ArrayList<>();
    @Relationship(type = "owner")
    private Member siteOwner;
    @Relationship(type = "driver")
    private List<Member> drivers = new ArrayList<>();
    @Relationship(type = "manager")
    private List<Member> siteManagers = new ArrayList<>();
    @Relationship(type = "siteInspector")
    private List<Member> siteInspectors = new ArrayList<>();

}
