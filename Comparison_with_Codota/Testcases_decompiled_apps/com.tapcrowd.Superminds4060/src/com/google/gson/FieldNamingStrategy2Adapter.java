package com.google.gson;

final class FieldNamingStrategy2Adapter implements FieldNamingStrategy2 {
    private final FieldNamingStrategy adaptee;

    public FieldNamingStrategy2Adapter(FieldNamingStrategy adaptee2) {
        Preconditions.checkNotNull(adaptee2);
        this.adaptee = adaptee2;
    }

    public String translateName(FieldAttributes f) {
        return this.adaptee.translateName(f.getFieldObject());
    }
}
