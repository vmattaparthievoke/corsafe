package com.nti.corsafe.carrier;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CarrierRepository extends Neo4jRepository<Carrier, String> {

    Carrier findByName(String name);

    List<Carrier> findByCategory(String category);
}
