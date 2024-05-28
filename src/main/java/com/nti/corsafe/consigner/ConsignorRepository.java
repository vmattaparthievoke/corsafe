package com.nti.corsafe.consigner;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface ConsignorRepository extends Neo4jRepository<Consignor, String> {

    Consignor findByName(String name);
    @Query("MATCH (c:Consignor)-[r]-() WHERE c.id = $id DELETE r, c")
    void deleteConsignorAndRelations(String id);
}
