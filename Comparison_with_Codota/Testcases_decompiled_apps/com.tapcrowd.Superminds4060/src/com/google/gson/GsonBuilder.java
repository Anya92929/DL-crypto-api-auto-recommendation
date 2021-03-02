package com.google.gson;

import com.google.gson.DefaultTypeAdapters;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class GsonBuilder {
    private static final ExposeAnnotationDeserializationExclusionStrategy exposeAnnotationDeserializationExclusionStrategy = new ExposeAnnotationDeserializationExclusionStrategy();
    private static final ExposeAnnotationSerializationExclusionStrategy exposeAnnotationSerializationExclusionStrategy = new ExposeAnnotationSerializationExclusionStrategy();
    private static final InnerClassExclusionStrategy innerClassExclusionStrategy = new InnerClassExclusionStrategy();
    private String datePattern;
    private int dateStyle;
    private final ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers;
    private boolean escapeHtmlChars;
    private boolean excludeFieldsWithoutExposeAnnotation;
    private final Collection<ExclusionStrategy> exclusionStrategies = new HashSet();
    private FieldNamingStrategy2 fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private double ignoreVersionsAfter;
    private final ParameterizedTypeHandlerMap<InstanceCreator<?>> instanceCreators;
    private LongSerializationPolicy longSerializationPolicy;
    private ModifierBasedExclusionStrategy modifierBasedExclusionStrategy;
    private boolean prettyPrinting;
    private boolean serializeInnerClasses;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private final ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers;
    private int timeStyle;

    public GsonBuilder() {
        this.exclusionStrategies.add(Gson.DEFAULT_ANON_LOCAL_CLASS_EXCLUSION_STRATEGY);
        this.exclusionStrategies.add(Gson.DEFAULT_SYNTHETIC_FIELD_EXCLUSION_STRATEGY);
        this.ignoreVersionsAfter = -1.0d;
        this.serializeInnerClasses = true;
        this.prettyPrinting = false;
        this.escapeHtmlChars = true;
        this.modifierBasedExclusionStrategy = Gson.DEFAULT_MODIFIER_BASED_EXCLUSION_STRATEGY;
        this.excludeFieldsWithoutExposeAnnotation = false;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = Gson.DEFAULT_NAMING_POLICY;
        this.instanceCreators = new ParameterizedTypeHandlerMap<>();
        this.serializers = new ParameterizedTypeHandlerMap<>();
        this.deserializers = new ParameterizedTypeHandlerMap<>();
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.serializeSpecialFloatingPointValues = false;
        this.generateNonExecutableJson = false;
    }

    public GsonBuilder setVersion(double ignoreVersionsAfter2) {
        this.ignoreVersionsAfter = ignoreVersionsAfter2;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... modifiers) {
        this.modifierBasedExclusionStrategy = new ModifierBasedExclusionStrategy(modifiers);
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excludeFieldsWithoutExposeAnnotation = true;
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.serializeInnerClasses = false;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy serializationPolicy) {
        this.longSerializationPolicy = serializationPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy namingConvention) {
        return setFieldNamingStrategy(namingConvention.getFieldNamingPolicy());
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        return setFieldNamingStrategy((FieldNamingStrategy2) new FieldNamingStrategy2Adapter(fieldNamingStrategy));
    }

    /* access modifiers changed from: package-private */
    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy2 fieldNamingStrategy) {
        this.fieldNamingPolicy = new SerializedNameAnnotationInterceptingNamingPolicy(fieldNamingStrategy);
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... strategies) {
        for (ExclusionStrategy strategy : strategies) {
            this.exclusionStrategies.add(strategy);
        }
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder setDateFormat(String pattern) {
        this.datePattern = pattern;
        return this;
    }

    public GsonBuilder setDateFormat(int style) {
        this.dateStyle = style;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int dateStyle2, int timeStyle2) {
        this.dateStyle = dateStyle2;
        this.timeStyle = timeStyle2;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object typeAdapter) {
        Preconditions.checkArgument((typeAdapter instanceof JsonSerializer) || (typeAdapter instanceof JsonDeserializer) || (typeAdapter instanceof InstanceCreator));
        if (typeAdapter instanceof InstanceCreator) {
            registerInstanceCreator(type, (InstanceCreator) typeAdapter);
        }
        if (typeAdapter instanceof JsonSerializer) {
            registerSerializer(type, (JsonSerializer) typeAdapter);
        }
        if (typeAdapter instanceof JsonDeserializer) {
            registerDeserializer(type, (JsonDeserializer) typeAdapter);
        }
        return this;
    }

    private <T> GsonBuilder registerInstanceCreator(Type typeOfT, InstanceCreator<? extends T> instanceCreator) {
        this.instanceCreators.register(typeOfT, instanceCreator);
        return this;
    }

    private <T> GsonBuilder registerSerializer(Type typeOfT, JsonSerializer<T> serializer) {
        this.serializers.register(typeOfT, serializer);
        return this;
    }

    private <T> GsonBuilder registerDeserializer(Type typeOfT, JsonDeserializer<T> deserializer) {
        this.deserializers.register(typeOfT, new JsonDeserializerExceptionWrapper(deserializer));
        return this;
    }

    /* access modifiers changed from: package-private */
    public GsonBuilder registerTypeHierarchyAdapter(Class<?> baseType, Object typeAdapter) {
        Preconditions.checkArgument((typeAdapter instanceof JsonSerializer) || (typeAdapter instanceof JsonDeserializer) || (typeAdapter instanceof InstanceCreator));
        if (typeAdapter instanceof InstanceCreator) {
            registerInstanceCreatorForTypeHierarchy(baseType, (InstanceCreator) typeAdapter);
        }
        if (typeAdapter instanceof JsonSerializer) {
            registerSerializerForTypeHierarchy(baseType, (JsonSerializer) typeAdapter);
        }
        if (typeAdapter instanceof JsonDeserializer) {
            registerDeserializerForTypeHierarchy(baseType, (JsonDeserializer) typeAdapter);
        }
        return this;
    }

    private <T> GsonBuilder registerInstanceCreatorForTypeHierarchy(Class<?> classOfT, InstanceCreator<? extends T> instanceCreator) {
        this.instanceCreators.registerForTypeHierarchy(classOfT, instanceCreator);
        return this;
    }

    private <T> GsonBuilder registerSerializerForTypeHierarchy(Class<?> classOfT, JsonSerializer<T> serializer) {
        this.serializers.registerForTypeHierarchy(classOfT, serializer);
        return this;
    }

    private <T> GsonBuilder registerDeserializerForTypeHierarchy(Class<?> classOfT, JsonDeserializer<T> deserializer) {
        this.deserializers.registerForTypeHierarchy(classOfT, new JsonDeserializerExceptionWrapper(deserializer));
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public Gson create() {
        List<ExclusionStrategy> serializationStrategies = new LinkedList<>(this.exclusionStrategies);
        List<ExclusionStrategy> deserializationStrategies = new LinkedList<>(this.exclusionStrategies);
        serializationStrategies.add(this.modifierBasedExclusionStrategy);
        deserializationStrategies.add(this.modifierBasedExclusionStrategy);
        if (!this.serializeInnerClasses) {
            serializationStrategies.add(innerClassExclusionStrategy);
            deserializationStrategies.add(innerClassExclusionStrategy);
        }
        if (this.ignoreVersionsAfter != -1.0d) {
            serializationStrategies.add(new VersionExclusionStrategy(this.ignoreVersionsAfter));
            deserializationStrategies.add(new VersionExclusionStrategy(this.ignoreVersionsAfter));
        }
        if (this.excludeFieldsWithoutExposeAnnotation) {
            serializationStrategies.add(exposeAnnotationSerializationExclusionStrategy);
            deserializationStrategies.add(exposeAnnotationDeserializationExclusionStrategy);
        }
        ExclusionStrategy serializationExclusionStrategy = new DisjunctionExclusionStrategy(serializationStrategies);
        ExclusionStrategy deserializationExclusionStrategy = new DisjunctionExclusionStrategy(deserializationStrategies);
        ParameterizedTypeHandlerMap<JsonSerializer<?>> customSerializers = this.serializers.copyOf();
        ParameterizedTypeHandlerMap<JsonDeserializer<?>> customDeserializers = this.deserializers.copyOf();
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, customSerializers, customDeserializers);
        customSerializers.registerIfAbsent(DefaultTypeAdapters.getDefaultSerializers(this.serializeSpecialFloatingPointValues, this.longSerializationPolicy));
        customDeserializers.registerIfAbsent(DefaultTypeAdapters.getDefaultDeserializers());
        ParameterizedTypeHandlerMap<InstanceCreator<?>> customInstanceCreators = this.instanceCreators.copyOf();
        customInstanceCreators.registerIfAbsent(DefaultTypeAdapters.getDefaultInstanceCreators());
        customSerializers.makeUnmodifiable();
        customDeserializers.makeUnmodifiable();
        this.instanceCreators.makeUnmodifiable();
        return new Gson(serializationExclusionStrategy, deserializationExclusionStrategy, this.fieldNamingPolicy, new MappedObjectConstructor(customInstanceCreators), this.serializeNulls, customSerializers, customDeserializers, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting);
    }

    private static void addTypeAdaptersForDate(String datePattern2, int dateStyle2, int timeStyle2, ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers2, ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers2) {
        DefaultTypeAdapters.DefaultDateTypeAdapter dateTypeAdapter = null;
        if (datePattern2 != null && !"".equals(datePattern2.trim())) {
            dateTypeAdapter = new DefaultTypeAdapters.DefaultDateTypeAdapter(datePattern2);
        } else if (!(dateStyle2 == 2 || timeStyle2 == 2)) {
            dateTypeAdapter = new DefaultTypeAdapters.DefaultDateTypeAdapter(dateStyle2, timeStyle2);
        }
        if (dateTypeAdapter != null) {
            if (!serializers2.hasSpecificHandlerFor(Date.class)) {
                serializers2.register(Date.class, dateTypeAdapter);
            }
            if (!deserializers2.hasSpecificHandlerFor(Date.class)) {
                deserializers2.register(Date.class, dateTypeAdapter);
            }
        }
    }
}
