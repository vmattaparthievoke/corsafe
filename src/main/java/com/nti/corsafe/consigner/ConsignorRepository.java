package com.nti.corsafe.consigner;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ConsignorRepository extends Neo4jRepository<Consignor, String> {

    Consignor findByName(String name);
}
