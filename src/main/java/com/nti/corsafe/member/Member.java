package com.nti.corsafe.member;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nti.corsafe.common.model.Address;
import com.nti.corsafe.common.model.AddressConverter;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;
    @CompositeProperty(prefix = "address", converter = AddressConverter.class)
    private Address address;
}
