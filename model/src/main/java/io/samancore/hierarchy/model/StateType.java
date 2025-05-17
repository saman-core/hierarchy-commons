package io.samancore.hierarchy.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StateType {
    CDE("CDE"),
    OUTSOURCE("OUTSOURCE");

    private final String value;

    StateType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
