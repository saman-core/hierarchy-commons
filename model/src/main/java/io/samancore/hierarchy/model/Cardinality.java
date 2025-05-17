package io.samancore.hierarchy.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Cardinality {
    ONE_MANDATORY("ONE_MANDATORY"),
    ONE_OPTIONAL("ONE_OPTIONAL"),
    MANY_MANDATORY("MANY_MANDATORY"),
    MANY_OPTIONAL("MANY_OPTIONAL");

    private final String value;

    Cardinality(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

