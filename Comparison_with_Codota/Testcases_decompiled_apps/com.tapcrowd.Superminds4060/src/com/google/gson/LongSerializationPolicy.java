package com.google.gson;

public enum LongSerializationPolicy {
    DEFAULT(new DefaultStrategy()),
    STRING(new StringStrategy());
    
    private final Strategy strategy;

    private interface Strategy {
        JsonElement serialize(Long l);
    }

    private LongSerializationPolicy(Strategy strategy2) {
        this.strategy = strategy2;
    }

    public JsonElement serialize(Long value) {
        return this.strategy.serialize(value);
    }

    private static class DefaultStrategy implements Strategy {
        private DefaultStrategy() {
        }

        public JsonElement serialize(Long value) {
            return new JsonPrimitive((Number) value);
        }
    }

    private static class StringStrategy implements Strategy {
        private StringStrategy() {
        }

        public JsonElement serialize(Long value) {
            return new JsonPrimitive(String.valueOf(value));
        }
    }
}
