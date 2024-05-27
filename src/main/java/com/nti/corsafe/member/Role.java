package com.nti.corsafe.member;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class Role {

    private String id;
    private String name;
}
