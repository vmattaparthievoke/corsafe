package com.nti.corsafe.member;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.ArrayList;
import java.util.List;

@Data
@Node
@Builder
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;
    private List<String> skills = new ArrayList<>();
}
