package com.exa.pesa.core.enums;

public enum TicketType {
    CHECKPOINT("Garita"),
    INPUT("Ingreso");

    private String value;

    TicketType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
