package com.nti.corsafe.consignee;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public  interface ConsigneeRepository extends Neo4jRepository<Consignee,String> {
    Consignee findByName(String name);
}
