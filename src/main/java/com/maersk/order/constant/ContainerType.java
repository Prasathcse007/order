package com.maersk.order.constant;

public enum ContainerType {
    DRY("DRY"), REEFER("REEFER");

    private String value;

    private ContainerType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}