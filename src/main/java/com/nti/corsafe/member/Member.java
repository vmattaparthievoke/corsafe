package com.nti.corsafe.member;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@Node
public class Member {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    @Relationship(type = "positioned-as")
    private List<Role> role;
}
