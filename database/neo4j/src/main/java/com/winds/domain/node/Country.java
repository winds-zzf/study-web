package com.winds.domain.node;

import org.springframework.data.neo4j.core.schema.*;
import com.winds.domain.relationship.BuildIn;

import java.util.List;

/**
 *
 */
@Node
public class Country {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name="name")
    private String name;

    @Relationship(type = "buildIn",direction = Relationship.Direction.INCOMING)
    private List<BuildIn> buildIns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BuildIn> getBuildIns() {
        return buildIns;
    }

    public void setBuildIns(List<BuildIn> buildIns) {
        this.buildIns = buildIns;
    }
}
