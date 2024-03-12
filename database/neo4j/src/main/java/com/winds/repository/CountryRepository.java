package com.winds.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import com.winds.domain.node.Country;

@Repository
public interface CountryRepository extends Neo4jRepository<Country,Long> {
    Country findFirstByName(String name);
}
