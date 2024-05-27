package com.nti.corsafe.consigner;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface ConsignorRepository extends Neo4jRepository<Consignor, String> {

    Consignor findByName(String name);

    List<Consignor> findByCategory(String category);
}
