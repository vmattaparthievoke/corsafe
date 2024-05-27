package com.nti.corsafe.member;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MemberRepository extends Neo4jRepository<Member, String> {
}
