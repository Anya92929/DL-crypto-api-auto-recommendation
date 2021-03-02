package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public final class Gson {
    static final AnonymousAndLocalClassExclusionStrategy DEFAULT_ANON_LOCAL_CLASS_EXCLUSION_STRATEGY = new AnonymousAndLocalClassExclusionStrategy();
    private static final ExclusionStrategy DEFAULT_EXCLUSION_STRATEGY = createExclusionStrategy(-1.0d);
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final ModifierBasedExclusionStrategy DEFAULT_MODIFIER_BASED_EXCLUSION_STRATEGY = new ModifierBasedExclusionStrategy(128, 8);
    static final FieldNamingStrategy2 DEFAULT_NAMING_POLICY = new SerializedNameAnnotationInterceptingNamingPolicy(new JavaFieldNamingPolicy());
    static final SyntheticFieldExclusionStrategy DEFAULT_SYNTHETIC_FIELD_EXCLUSION_STRATEGY = new SyntheticFieldExclusionStrategy(true);
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final String NULL_STRING = "null";
    private final ExclusionStrategy deserializationStrategy;
    private final ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers;
    private final FieldNamingStrategy2 fieldNamingPolicy;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final MappedObjectConstructor objectConstructor;
    private final boolean prettyPrinting;
    private final ExclusionStrategy serializationStrategy;
    private final boolean serializeNulls;
    private final ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers;

    public Gson() {
        this(DEFAULT_EXCLUSION_STRATEGY, DEFAULT_EXCLUSION_STRATEGY, DEFAULT_NAMING_POLICY, new MappedObjectConstructor(DefaultTypeAdapters.getDefaultInstanceCreators()), DEFAULT_JSON_NON_EXECUTABLE, DefaultTypeAdapters.getDefaultSerializers(), DefaultTypeAdapters.getDefaultDeserializers(), DEFAULT_JSON_NON_EXECUTABLE, true, DEFAULT_JSON_NON_EXECUTABLE);
    }

    Gson(ExclusionStrategy serializationStrategy2, ExclusionStrategy deserializationStrategy2, FieldNamingStrategy2 fieldNamingPolicy2, MappedObjectConstructor objectConstructor2, boolean serializeNulls2, ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers2, ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers2, boolean generateNonExecutableGson, boolean htmlSafe2, boolean prettyPrinting2) {
        this.serializationStrategy = serializationStrategy2;
        this.deserializationStrategy = deserializationStrategy2;
        this.fieldNamingPolicy = fieldNamingPolicy2;
        this.objectConstructor = objectConstructor2;
        this.serializeNulls = serializeNulls2;
        this.serializers = serializers2;
        this.deserializers = deserializers2;
        this.generateNonExecutableJson = generateNonExecutableGson;
        this.htmlSafe = htmlSafe2;
        this.prettyPrinting = prettyPrinting2;
    }

    private ObjectNavigatorFactory createDefaultObjectNavigatorFactory(ExclusionStrategy strategy) {
        return new ObjectNavigatorFactory(strategy, this.fieldNamingPolicy);
    }

    private static ExclusionStrategy createExclusionStrategy(double version) {
        List<ExclusionStrategy> strategies = new LinkedList<>();
        strategies.add(DEFAULT_ANON_LOCAL_CLASS_EXCLUSION_STRATEGY);
        strategies.add(DEFAULT_SYNTHETIC_FIELD_EXCLUSION_STRATEGY);
        strategies.add(DEFAULT_MODIFIER_BASED_EXCLUSION_STRATEGY);
        if (version != -1.0d) {
            strategies.add(new VersionExclusionStrategy(version));
        }
        return new DisjunctionExclusionStrategy(strategies);
    }

    public JsonElement toJsonTree(Object src) {
        if (src == null) {
            return JsonNull.createJsonNull();
        }
        return toJsonTree(src, src.getClass());
    }

    public JsonElement toJsonTree(Object src, Type typeOfSrc) {
        if (src == null) {
            return JsonNull.createJsonNull();
        }
        return new JsonSerializationContextDefault(createDefaultObjectNavigatorFactory(this.serializationStrategy), this.serializeNulls, this.serializers).serialize(src, typeOfSrc, true);
    }

    public String toJson(Object src) {
        if (src == null) {
            return this.serializeNulls ? NULL_STRING : "";
        }
        return toJson(src, (Type) src.getClass());
    }

    public String toJson(Object src, Type typeOfSrc) {
        StringWriter writer = new StringWriter();
        toJson(toJsonTree(src, typeOfSrc), (Appendable) writer);
        return writer.toString();
    }

    public void toJson(Object src, Appendable writer) throws JsonIOException {
        if (src != null) {
            try {
                toJson(src, (Type) src.getClass(), writer);
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        } else if (this.serializeNulls) {
            writeOutNullString(writer);
        }
    }

    public void toJson(Object src, Type typeOfSrc, Appendable writer) throws JsonIOException {
        toJson(toJsonTree(src, typeOfSrc), writer);
    }

    public void toJson(Object src, Type typeOfSrc, JsonWriter writer) throws JsonIOException {
        toJson(toJsonTree(src, typeOfSrc), writer);
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter writer = new StringWriter();
        toJson(jsonElement, (Appendable) writer);
        return writer.toString();
    }

    public void toJson(JsonElement jsonElement, Appendable writer) throws JsonIOException {
        try {
            if (this.generateNonExecutableJson) {
                writer.append(JSON_NON_EXECUTABLE_PREFIX);
            }
            JsonWriter jsonWriter = new JsonWriter(Streams.writerForAppendable(writer));
            if (this.prettyPrinting) {
                jsonWriter.setIndent("  ");
            }
            toJson(jsonElement, jsonWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void toJson(JsonElement jsonElement, JsonWriter writer) throws JsonIOException {
        boolean oldLenient = writer.isLenient();
        writer.setLenient(true);
        boolean oldHtmlSafe = writer.isHtmlSafe();
        writer.setHtmlSafe(this.htmlSafe);
        try {
            Streams.write(jsonElement, this.serializeNulls, writer);
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
        } catch (IOException e) {
            throw new JsonIOException((Throwable) e);
        } catch (Throwable th) {
            writer.setLenient(oldLenient);
            writer.setHtmlSafe(oldHtmlSafe);
            throw th;
        }
    }

    public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return Primitives.wrap(classOfT).cast(fromJson(json, (Type) classOfT));
    }

    public <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return fromJson((Reader) new StringReader(json), typeOfT);
    }

    public <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReader = new JsonReader(json);
        Object object = fromJson(jsonReader, (Type) classOfT);
        assertFullConsumption(object, jsonReader);
        return Primitives.wrap(classOfT).cast(object);
    }

    public <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        JsonReader jsonReader = new JsonReader(json);
        T object = fromJson(jsonReader, typeOfT);
        assertFullConsumption(object, jsonReader);
        return object;
    }

    private static void assertFullConsumption(Object obj, JsonReader reader) {
        if (obj != null) {
            try {
                if (reader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException((Throwable) e);
            } catch (IOException e2) {
                throw new JsonIOException((Throwable) e2);
            }
        }
    }

    public <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        boolean oldLenient = reader.isLenient();
        reader.setLenient(true);
        try {
            return fromJson(Streams.parse(reader), typeOfT);
        } finally {
            reader.setLenient(oldLenient);
        }
    }

    public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
        return Primitives.wrap(classOfT).cast(fromJson(json, (Type) classOfT));
    }

    public <T> T fromJson(JsonElement json, Type typeOfT) throws JsonSyntaxException {
        if (json == null) {
            return null;
        }
        return new JsonDeserializationContextDefault(createDefaultObjectNavigatorFactory(this.deserializationStrategy), this.deserializers, this.objectConstructor).deserialize(json, typeOfT);
    }

    private void writeOutNullString(Appendable writer) throws IOException {
        writer.append(NULL_STRING);
    }

    public String toString() {
        return "{" + "serializeNulls:" + this.serializeNulls + ",serializers:" + this.serializers + ",deserializers:" + this.deserializers + ",instanceCreators:" + this.objectConstructor + "}";
    }
}
