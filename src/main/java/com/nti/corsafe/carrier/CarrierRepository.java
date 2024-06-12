package com.nti.corsafe.carrier;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface CarrierRepository extends Neo4jRepository<Carrier, String> {

    Carrier findByName(String name);

    List<Carrier> findByFleetType(String fleetType);

    @Query("MATCH (c:Carrier)-[r]-() WHERE c.id = $id DELETE r, c")
    void deleteAlongWithRelationship(String id);
}
