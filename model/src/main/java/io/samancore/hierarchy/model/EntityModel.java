package io.samancore.hierarchy.model;

import java.util.Objects;

public record EntityModel(String id, String name) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityModel entityModel = (EntityModel) o;
        return Objects.equals(id, entityModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
