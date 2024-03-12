package com.winds.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import com.winds.domain.node.Ship;

@Repository
public interface ShipRepository extends Neo4jRepository<Ship,Long> {
}
