package io.samancore.hierarchy.model;

import java.util.Objects;

public record RelationshipModel(String id,
                                String name,
                                EntityModel source,
                                EntityModel target,
                                Cardinality cardinalitySource,
                                Cardinality cardinalityTarget) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipModel that = (RelationshipModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
