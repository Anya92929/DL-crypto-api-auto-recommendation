package com.google.gson;

final class CircularReferenceException extends RuntimeException {
    private static final long serialVersionUID = 7444343294106513081L;
    private final Object offendingNode;

    CircularReferenceException(Object offendingNode2) {
        super("circular reference error");
        this.offendingNode = offendingNode2;
    }

    public IllegalStateException createDetailedException(FieldAttributes offendingField) {
        StringBuilder msg = new StringBuilder(getMessage());
        if (offendingField != null) {
            msg.append("\n  ").append("Offending field: ").append(offendingField.getName() + "\n");
        }
        if (this.offendingNode != null) {
            msg.append("\n  ").append("Offending object: ").append(this.offendingNode);
        }
        return new IllegalStateException(msg.toString(), this);
    }
}
