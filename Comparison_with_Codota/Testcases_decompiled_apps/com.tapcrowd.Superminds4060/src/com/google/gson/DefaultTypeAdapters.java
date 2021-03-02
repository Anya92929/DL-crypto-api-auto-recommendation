package com.google.gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.UUID;

final class DefaultTypeAdapters {
    private static final BigDecimalTypeAdapter BIG_DECIMAL_TYPE_ADAPTER = new BigDecimalTypeAdapter();
    private static final BigIntegerTypeAdapter BIG_INTEGER_TYPE_ADAPTER = new BigIntegerTypeAdapter();
    private static final BooleanTypeAdapter BOOLEAN_TYPE_ADAPTER = new BooleanTypeAdapter();
    private static final ByteTypeAdapter BYTE_TYPE_ADAPTER = new ByteTypeAdapter();
    private static final CharacterTypeAdapter CHARACTER_TYPE_ADAPTER = new CharacterTypeAdapter();
    private static final CollectionTypeAdapter COLLECTION_TYPE_ADAPTER = new CollectionTypeAdapter();
    private static final DefaultDateTypeAdapter DATE_TYPE_ADAPTER = new DefaultDateTypeAdapter();
    private static final ParameterizedTypeHandlerMap<JsonDeserializer<?>> DEFAULT_DESERIALIZERS = createDefaultDeserializers();
    private static final ParameterizedTypeHandlerMap<InstanceCreator<?>> DEFAULT_INSTANCE_CREATORS = createDefaultInstanceCreators();
    private static final ParameterizedTypeHandlerMap<JsonSerializer<?>> DEFAULT_SERIALIZERS = createDefaultSerializers();
    private static final DoubleDeserializer DOUBLE_TYPE_ADAPTER = new DoubleDeserializer();
    private static final EnumTypeAdapter ENUM_TYPE_ADAPTER = new EnumTypeAdapter();
    private static final FloatDeserializer FLOAT_TYPE_ADAPTER = new FloatDeserializer();
    private static final GregorianCalendarTypeAdapter GREGORIAN_CALENDAR_TYPE_ADAPTER = new GregorianCalendarTypeAdapter();
    private static final HashSetCreator HASH_SET_CREATOR = new HashSetCreator();
    private static final IntegerTypeAdapter INTEGER_TYPE_ADAPTER = new IntegerTypeAdapter();
    private static final DefaultJavaSqlDateTypeAdapter JAVA_SQL_DATE_TYPE_ADAPTER = new DefaultJavaSqlDateTypeAdapter();
    private static final LocaleTypeAdapter LOCALE_TYPE_ADAPTER = new LocaleTypeAdapter();
    private static final LongDeserializer LONG_DESERIALIZER = new LongDeserializer();
    private static final MapTypeAdapter MAP_TYPE_ADAPTER = new MapTypeAdapter();
    private static final NumberTypeAdapter NUMBER_TYPE_ADAPTER = new NumberTypeAdapter();
    private static final PropertiesCreator PROPERTIES_CREATOR = new PropertiesCreator();
    private static final ShortTypeAdapter SHORT_TYPE_ADAPTER = new ShortTypeAdapter();
    private static final StringTypeAdapter STRING_TYPE_ADAPTER = new StringTypeAdapter();
    private static final DefaultTimestampDeserializer TIMESTAMP_DESERIALIZER = new DefaultTimestampDeserializer();
    private static final DefaultTimeTypeAdapter TIME_TYPE_ADAPTER = new DefaultTimeTypeAdapter();
    private static final TreeSetCreator TREE_SET_CREATOR = new TreeSetCreator();
    private static final UriTypeAdapter URI_TYPE_ADAPTER = new UriTypeAdapter();
    private static final UrlTypeAdapter URL_TYPE_ADAPTER = new UrlTypeAdapter();
    private static final UuidTypeAdapter UUUID_TYPE_ADAPTER = new UuidTypeAdapter();

    DefaultTypeAdapters() {
    }

    private static ParameterizedTypeHandlerMap<JsonSerializer<?>> createDefaultSerializers() {
        ParameterizedTypeHandlerMap<JsonSerializer<?>> map = new ParameterizedTypeHandlerMap<>();
        map.registerForTypeHierarchy(Enum.class, ENUM_TYPE_ADAPTER);
        map.register(URL.class, URL_TYPE_ADAPTER);
        map.register(URI.class, URI_TYPE_ADAPTER);
        map.register(UUID.class, UUUID_TYPE_ADAPTER);
        map.register(Locale.class, LOCALE_TYPE_ADAPTER);
        map.registerForTypeHierarchy(Collection.class, COLLECTION_TYPE_ADAPTER);
        map.registerForTypeHierarchy(Map.class, MAP_TYPE_ADAPTER);
        map.register(Date.class, DATE_TYPE_ADAPTER);
        map.register(java.sql.Date.class, JAVA_SQL_DATE_TYPE_ADAPTER);
        map.register(Timestamp.class, DATE_TYPE_ADAPTER);
        map.register(Time.class, TIME_TYPE_ADAPTER);
        map.register(Calendar.class, GREGORIAN_CALENDAR_TYPE_ADAPTER);
        map.register(GregorianCalendar.class, GREGORIAN_CALENDAR_TYPE_ADAPTER);
        map.register(BigDecimal.class, BIG_DECIMAL_TYPE_ADAPTER);
        map.register(BigInteger.class, BIG_INTEGER_TYPE_ADAPTER);
        map.register(Boolean.class, BOOLEAN_TYPE_ADAPTER);
        map.register(Boolean.TYPE, BOOLEAN_TYPE_ADAPTER);
        map.register(Byte.class, BYTE_TYPE_ADAPTER);
        map.register(Byte.TYPE, BYTE_TYPE_ADAPTER);
        map.register(Character.class, CHARACTER_TYPE_ADAPTER);
        map.register(Character.TYPE, CHARACTER_TYPE_ADAPTER);
        map.register(Integer.class, INTEGER_TYPE_ADAPTER);
        map.register(Integer.TYPE, INTEGER_TYPE_ADAPTER);
        map.register(Number.class, NUMBER_TYPE_ADAPTER);
        map.register(Short.class, SHORT_TYPE_ADAPTER);
        map.register(Short.TYPE, SHORT_TYPE_ADAPTER);
        map.register(String.class, STRING_TYPE_ADAPTER);
        map.makeUnmodifiable();
        return map;
    }

    private static ParameterizedTypeHandlerMap<JsonDeserializer<?>> createDefaultDeserializers() {
        ParameterizedTypeHandlerMap<JsonDeserializer<?>> map = new ParameterizedTypeHandlerMap<>();
        map.registerForTypeHierarchy(Enum.class, wrapDeserializer(ENUM_TYPE_ADAPTER));
        map.register(URL.class, wrapDeserializer(URL_TYPE_ADAPTER));
        map.register(URI.class, wrapDeserializer(URI_TYPE_ADAPTER));
        map.register(UUID.class, wrapDeserializer(UUUID_TYPE_ADAPTER));
        map.register(Locale.class, wrapDeserializer(LOCALE_TYPE_ADAPTER));
        map.registerForTypeHierarchy(Collection.class, wrapDeserializer(COLLECTION_TYPE_ADAPTER));
        map.registerForTypeHierarchy(Map.class, wrapDeserializer(MAP_TYPE_ADAPTER));
        map.register(Date.class, wrapDeserializer(DATE_TYPE_ADAPTER));
        map.register(java.sql.Date.class, wrapDeserializer(JAVA_SQL_DATE_TYPE_ADAPTER));
        map.register(Timestamp.class, wrapDeserializer(TIMESTAMP_DESERIALIZER));
        map.register(Time.class, wrapDeserializer(TIME_TYPE_ADAPTER));
        map.register(Calendar.class, GREGORIAN_CALENDAR_TYPE_ADAPTER);
        map.register(GregorianCalendar.class, GREGORIAN_CALENDAR_TYPE_ADAPTER);
        map.register(BigDecimal.class, wrapDeserializer(BIG_DECIMAL_TYPE_ADAPTER));
        map.register(BigInteger.class, wrapDeserializer(BIG_INTEGER_TYPE_ADAPTER));
        map.register(Boolean.class, wrapDeserializer(BOOLEAN_TYPE_ADAPTER));
        map.register(Boolean.TYPE, wrapDeserializer(BOOLEAN_TYPE_ADAPTER));
        map.register(Byte.class, wrapDeserializer(BYTE_TYPE_ADAPTER));
        map.register(Byte.TYPE, wrapDeserializer(BYTE_TYPE_ADAPTER));
        map.register(Character.class, wrapDeserializer(CHARACTER_TYPE_ADAPTER));
        map.register(Character.TYPE, wrapDeserializer(CHARACTER_TYPE_ADAPTER));
        map.register(Double.class, wrapDeserializer(DOUBLE_TYPE_ADAPTER));
        map.register(Double.TYPE, wrapDeserializer(DOUBLE_TYPE_ADAPTER));
        map.register(Float.class, wrapDeserializer(FLOAT_TYPE_ADAPTER));
        map.register(Float.TYPE, wrapDeserializer(FLOAT_TYPE_ADAPTER));
        map.register(Integer.class, wrapDeserializer(INTEGER_TYPE_ADAPTER));
        map.register(Integer.TYPE, wrapDeserializer(INTEGER_TYPE_ADAPTER));
        map.register(Long.class, wrapDeserializer(LONG_DESERIALIZER));
        map.register(Long.TYPE, wrapDeserializer(LONG_DESERIALIZER));
        map.register(Number.class, wrapDeserializer(NUMBER_TYPE_ADAPTER));
        map.register(Short.class, wrapDeserializer(SHORT_TYPE_ADAPTER));
        map.register(Short.TYPE, wrapDeserializer(SHORT_TYPE_ADAPTER));
        map.register(String.class, wrapDeserializer(STRING_TYPE_ADAPTER));
        map.makeUnmodifiable();
        return map;
    }

    private static ParameterizedTypeHandlerMap<InstanceCreator<?>> createDefaultInstanceCreators() {
        ParameterizedTypeHandlerMap<InstanceCreator<?>> map = new ParameterizedTypeHandlerMap<>();
        map.registerForTypeHierarchy(Map.class, MAP_TYPE_ADAPTER);
        map.registerForTypeHierarchy(Collection.class, COLLECTION_TYPE_ADAPTER);
        map.registerForTypeHierarchy(Set.class, HASH_SET_CREATOR);
        map.registerForTypeHierarchy(SortedSet.class, TREE_SET_CREATOR);
        map.register(Properties.class, PROPERTIES_CREATOR);
        map.makeUnmodifiable();
        return map;
    }

    private static JsonDeserializer<?> wrapDeserializer(JsonDeserializer<?> deserializer) {
        return new JsonDeserializerExceptionWrapper(deserializer);
    }

    static ParameterizedTypeHandlerMap<JsonSerializer<?>> getDefaultSerializers() {
        return getDefaultSerializers(false, LongSerializationPolicy.DEFAULT);
    }

    static ParameterizedTypeHandlerMap<JsonSerializer<?>> getDefaultSerializers(boolean serializeSpecialFloatingPointValues, LongSerializationPolicy longSerializationPolicy) {
        ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers = new ParameterizedTypeHandlerMap<>();
        DoubleSerializer doubleSerializer = new DoubleSerializer(serializeSpecialFloatingPointValues);
        serializers.registerIfAbsent(Double.class, doubleSerializer);
        serializers.registerIfAbsent(Double.TYPE, doubleSerializer);
        FloatSerializer floatSerializer = new FloatSerializer(serializeSpecialFloatingPointValues);
        serializers.registerIfAbsent(Float.class, floatSerializer);
        serializers.registerIfAbsent(Float.TYPE, floatSerializer);
        LongSerializer longSerializer = new LongSerializer(longSerializationPolicy);
        serializers.registerIfAbsent(Long.class, longSerializer);
        serializers.registerIfAbsent(Long.TYPE, longSerializer);
        serializers.registerIfAbsent(DEFAULT_SERIALIZERS);
        return serializers;
    }

    static ParameterizedTypeHandlerMap<JsonDeserializer<?>> getDefaultDeserializers() {
        return DEFAULT_DESERIALIZERS;
    }

    static ParameterizedTypeHandlerMap<InstanceCreator<?>> getDefaultInstanceCreators() {
        return DEFAULT_INSTANCE_CREATORS;
    }

    static class DefaultDateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        private final DateFormat format;

        DefaultDateTypeAdapter() {
            this.format = DateFormat.getDateTimeInstance();
        }

        DefaultDateTypeAdapter(String datePattern) {
            this.format = new SimpleDateFormat(datePattern);
        }

        DefaultDateTypeAdapter(int style) {
            this.format = DateFormat.getDateInstance(style);
        }

        public DefaultDateTypeAdapter(int dateStyle, int timeStyle) {
            this.format = DateFormat.getDateTimeInstance(dateStyle, timeStyle);
        }

        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            JsonPrimitive jsonPrimitive;
            synchronized (this.format) {
                jsonPrimitive = new JsonPrimitive(this.format.format(src));
            }
            return jsonPrimitive;
        }

        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Date parse;
            if (!(json instanceof JsonPrimitive)) {
                throw new JsonParseException("The date should be a string value");
            }
            try {
                synchronized (this.format) {
                    parse = this.format.parse(json.getAsString());
                }
                return parse;
            } catch (ParseException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(DefaultDateTypeAdapter.class.getSimpleName());
            sb.append('(').append(this.format.getClass().getSimpleName()).append(')');
            return sb.toString();
        }
    }

    static class DefaultJavaSqlDateTypeAdapter implements JsonSerializer<java.sql.Date>, JsonDeserializer<java.sql.Date> {
        private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

        DefaultJavaSqlDateTypeAdapter() {
        }

        public JsonElement serialize(java.sql.Date src, Type typeOfSrc, JsonSerializationContext context) {
            JsonPrimitive jsonPrimitive;
            synchronized (this.format) {
                jsonPrimitive = new JsonPrimitive(this.format.format(src));
            }
            return jsonPrimitive;
        }

        public java.sql.Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            java.sql.Date date;
            if (!(json instanceof JsonPrimitive)) {
                throw new JsonParseException("The date should be a string value");
            }
            try {
                synchronized (this.format) {
                    date = new java.sql.Date(this.format.parse(json.getAsString()).getTime());
                }
                return date;
            } catch (ParseException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }
    }

    static class DefaultTimestampDeserializer implements JsonDeserializer<Timestamp> {
        DefaultTimestampDeserializer() {
        }

        public Timestamp deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return new Timestamp(((Date) context.deserialize(json, Date.class)).getTime());
        }
    }

    static class DefaultTimeTypeAdapter implements JsonSerializer<Time>, JsonDeserializer<Time> {
        private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

        DefaultTimeTypeAdapter() {
        }

        public JsonElement serialize(Time src, Type typeOfSrc, JsonSerializationContext context) {
            JsonPrimitive jsonPrimitive;
            synchronized (this.format) {
                jsonPrimitive = new JsonPrimitive(this.format.format(src));
            }
            return jsonPrimitive;
        }

        public Time deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Time time;
            if (!(json instanceof JsonPrimitive)) {
                throw new JsonParseException("The date should be a string value");
            }
            try {
                synchronized (this.format) {
                    time = new Time(this.format.parse(json.getAsString()).getTime());
                }
                return time;
            } catch (ParseException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }
    }

    private static class GregorianCalendarTypeAdapter implements JsonSerializer<GregorianCalendar>, JsonDeserializer<GregorianCalendar> {
        private static final String DAY_OF_MONTH = "dayOfMonth";
        private static final String HOUR_OF_DAY = "hourOfDay";
        private static final String MINUTE = "minute";
        private static final String MONTH = "month";
        private static final String SECOND = "second";
        private static final String YEAR = "year";

        private GregorianCalendarTypeAdapter() {
        }

        public JsonElement serialize(GregorianCalendar src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject obj = new JsonObject();
            obj.addProperty(YEAR, (Number) Integer.valueOf(src.get(1)));
            obj.addProperty(MONTH, (Number) Integer.valueOf(src.get(2)));
            obj.addProperty(DAY_OF_MONTH, (Number) Integer.valueOf(src.get(5)));
            obj.addProperty(HOUR_OF_DAY, (Number) Integer.valueOf(src.get(11)));
            obj.addProperty(MINUTE, (Number) Integer.valueOf(src.get(12)));
            obj.addProperty(SECOND, (Number) Integer.valueOf(src.get(13)));
            return obj;
        }

        public GregorianCalendar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            return new GregorianCalendar(obj.get(YEAR).getAsInt(), obj.get(MONTH).getAsInt(), obj.get(DAY_OF_MONTH).getAsInt(), obj.get(HOUR_OF_DAY).getAsInt(), obj.get(MINUTE).getAsInt(), obj.get(SECOND).getAsInt());
        }

        public String toString() {
            return GregorianCalendarTypeAdapter.class.getSimpleName();
        }
    }

    private static class EnumTypeAdapter<T extends Enum<T>> implements JsonSerializer<T>, JsonDeserializer<T> {
        private EnumTypeAdapter() {
        }

        public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.name());
        }

        public T deserialize(JsonElement json, Type classOfT, JsonDeserializationContext context) throws JsonParseException {
            return Enum.valueOf((Class) classOfT, json.getAsString());
        }

        public String toString() {
            return EnumTypeAdapter.class.getSimpleName();
        }
    }

    private static class UrlTypeAdapter implements JsonSerializer<URL>, JsonDeserializer<URL> {
        private UrlTypeAdapter() {
        }

        public JsonElement serialize(URL src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toExternalForm());
        }

        public URL deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            try {
                return new URL(json.getAsString());
            } catch (MalformedURLException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public String toString() {
            return UrlTypeAdapter.class.getSimpleName();
        }
    }

    private static class UriTypeAdapter implements JsonSerializer<URI>, JsonDeserializer<URI> {
        private UriTypeAdapter() {
        }

        public JsonElement serialize(URI src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toASCIIString());
        }

        public URI deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            try {
                return new URI(json.getAsString());
            } catch (URISyntaxException e) {
                throw new JsonSyntaxException((Throwable) e);
            }
        }

        public String toString() {
            return UriTypeAdapter.class.getSimpleName();
        }
    }

    private static class UuidTypeAdapter implements JsonSerializer<UUID>, JsonDeserializer<UUID> {
        private UuidTypeAdapter() {
        }

        public JsonElement serialize(UUID src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }

        public UUID deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return UUID.fromString(json.getAsString());
        }

        public String toString() {
            return UuidTypeAdapter.class.getSimpleName();
        }
    }

    private static class LocaleTypeAdapter implements JsonSerializer<Locale>, JsonDeserializer<Locale> {
        private LocaleTypeAdapter() {
        }

        public JsonElement serialize(Locale src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }

        public Locale deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            StringTokenizer tokenizer = new StringTokenizer(json.getAsString(), "_");
            String language = null;
            String country = null;
            String variant = null;
            if (tokenizer.hasMoreElements()) {
                language = tokenizer.nextToken();
            }
            if (tokenizer.hasMoreElements()) {
                country = tokenizer.nextToken();
            }
            if (tokenizer.hasMoreElements()) {
                variant = tokenizer.nextToken();
            }
            if (country == null && variant == null) {
                return new Locale(language);
            }
            if (variant == null) {
                return new Locale(language, country);
            }
            return new Locale(language, country, variant);
        }

        public String toString() {
            return LocaleTypeAdapter.class.getSimpleName();
        }
    }

    private static class CollectionTypeAdapter implements JsonSerializer<Collection>, JsonDeserializer<Collection>, InstanceCreator<Collection> {
        private CollectionTypeAdapter() {
        }

        public JsonElement serialize(Collection src, Type typeOfSrc, JsonSerializationContext context) {
            Type childType;
            if (src == null) {
                return JsonNull.createJsonNull();
            }
            JsonArray array = new JsonArray();
            Type childGenericType = null;
            if (typeOfSrc instanceof ParameterizedType) {
                childGenericType = new TypeInfoCollection(typeOfSrc).getElementType();
            }
            for (Object child : src) {
                if (child == null) {
                    array.add(JsonNull.createJsonNull());
                } else {
                    if (childGenericType == null || childGenericType == Object.class) {
                        childType = child.getClass();
                    } else {
                        childType = childGenericType;
                    }
                    array.add(context.serialize(child, childType));
                }
            }
            return array;
        }

        public Collection deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json.isJsonNull()) {
                return null;
            }
            Collection collection = constructCollectionType(typeOfT, context);
            Type childType = new TypeInfoCollection(typeOfT).getElementType();
            Iterator i$ = json.getAsJsonArray().iterator();
            while (i$.hasNext()) {
                JsonElement childElement = i$.next();
                if (childElement == null || childElement.isJsonNull()) {
                    collection.add((Object) null);
                } else {
                    collection.add(context.deserialize(childElement, childType));
                }
            }
            return collection;
        }

        private Collection constructCollectionType(Type collectionType, JsonDeserializationContext context) {
            return (Collection) ((JsonDeserializationContextDefault) context).getObjectConstructor().construct(collectionType);
        }

        public Collection createInstance(Type type) {
            return new LinkedList();
        }
    }

    private static class PropertiesCreator implements InstanceCreator<Properties> {
        private PropertiesCreator() {
        }

        public Properties createInstance(Type type) {
            return new Properties();
        }
    }

    static class MapTypeAdapter implements JsonSerializer<Map>, JsonDeserializer<Map>, InstanceCreator<Map> {
        MapTypeAdapter() {
        }

        public JsonElement serialize(Map src, Type typeOfSrc, JsonSerializationContext context) {
            Type childType;
            JsonElement valueElement;
            JsonObject map = new JsonObject();
            Type childGenericType = null;
            if (typeOfSrc instanceof ParameterizedType) {
                childGenericType = new TypeInfoMap(typeOfSrc).getValueType();
            }
            for (Map.Entry entry : src.entrySet()) {
                Object value = entry.getValue();
                if (value == null) {
                    valueElement = JsonNull.createJsonNull();
                } else {
                    if (childGenericType == null) {
                        childType = value.getClass();
                    } else {
                        childType = childGenericType;
                    }
                    valueElement = context.serialize(value, childType);
                }
                map.add(String.valueOf(entry.getKey()), valueElement);
            }
            return map;
        }

        public Map deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Map<Object, Object> map = constructMapType(typeOfT, context);
            TypeInfoMap mapTypeInfo = new TypeInfoMap(typeOfT);
            for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
                map.put(context.deserialize(new JsonPrimitive(entry.getKey()), mapTypeInfo.getKeyType()), context.deserialize(entry.getValue(), mapTypeInfo.getValueType()));
            }
            return map;
        }

        private Map constructMapType(Type mapType, JsonDeserializationContext context) {
            return (Map) ((JsonDeserializationContextDefault) context).getObjectConstructor().construct(mapType);
        }

        public Map createInstance(Type type) {
            return new LinkedHashMap();
        }

        public String toString() {
            return MapTypeAdapter.class.getSimpleName();
        }
    }

    private static class BigDecimalTypeAdapter implements JsonSerializer<BigDecimal>, JsonDeserializer<BigDecimal> {
        private BigDecimalTypeAdapter() {
        }

        public JsonElement serialize(BigDecimal src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive((Number) src);
        }

        public BigDecimal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return json.getAsBigDecimal();
        }

        public String toString() {
            return BigDecimalTypeAdapter.class.getSimpleName();
        }
    }

    private static class BigIntegerTypeAdapter implements JsonSerializer<BigInteger>, JsonDeserializer<BigInteger> {
        private BigIntegerTypeAdapter() {
        }

        public JsonElement serialize(BigInteger src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive((Number) src);
        }

        public BigInteger deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return json.getAsBigInteger();
        }

        public String toString() {
            return BigIntegerTypeAdapter.class.getSimpleName();
        }
    }

    private static class NumberTypeAdapter implements JsonSerializer<Number>, JsonDeserializer<Number> {
        private NumberTypeAdapter() {
        }

        public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src);
        }

        public Number deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return json.getAsNumber();
        }

        public String toString() {
            return NumberTypeAdapter.class.getSimpleName();
        }
    }

    private static class LongSerializer implements JsonSerializer<Long> {
        private final LongSerializationPolicy longSerializationPolicy;

        private LongSerializer(LongSerializationPolicy longSerializationPolicy2) {
            this.longSerializationPolicy = longSerializationPolicy2;
        }

        public JsonElement serialize(Long src, Type typeOfSrc, JsonSerializationContext context) {
            return this.longSerializationPolicy.serialize(src);
        }

        public String toString() {
            return LongSerializer.class.getSimpleName();
        }
    }

    private static class LongDeserializer implements JsonDeserializer<Long> {
        private LongDeserializer() {
        }

        public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Long.valueOf(json.getAsLong());
        }

        public String toString() {
            return LongDeserializer.class.getSimpleName();
        }
    }

    private static class IntegerTypeAdapter implements JsonSerializer<Integer>, JsonDeserializer<Integer> {
        private IntegerTypeAdapter() {
        }

        public JsonElement serialize(Integer src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive((Number) src);
        }

        public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Integer.valueOf(json.getAsInt());
        }

        public String toString() {
            return IntegerTypeAdapter.class.getSimpleName();
        }
    }

    private static class ShortTypeAdapter implements JsonSerializer<Short>, JsonDeserializer<Short> {
        private ShortTypeAdapter() {
        }

        public JsonElement serialize(Short src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive((Number) src);
        }

        public Short deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Short.valueOf(json.getAsShort());
        }

        public String toString() {
            return ShortTypeAdapter.class.getSimpleName();
        }
    }

    private static class ByteTypeAdapter implements JsonSerializer<Byte>, JsonDeserializer<Byte> {
        private ByteTypeAdapter() {
        }

        public JsonElement serialize(Byte src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive((Number) src);
        }

        public Byte deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Byte.valueOf(json.getAsByte());
        }

        public String toString() {
            return ByteTypeAdapter.class.getSimpleName();
        }
    }

    static class FloatSerializer implements JsonSerializer<Float> {
        private final boolean serializeSpecialFloatingPointValues;

        FloatSerializer(boolean serializeSpecialDoubleValues) {
            this.serializeSpecialFloatingPointValues = serializeSpecialDoubleValues;
        }

        public JsonElement serialize(Float src, Type typeOfSrc, JsonSerializationContext context) {
            if (this.serializeSpecialFloatingPointValues || (!Float.isNaN(src.floatValue()) && !Float.isInfinite(src.floatValue()))) {
                return new JsonPrimitive((Number) src);
            }
            throw new IllegalArgumentException(src + " is not a valid float value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static class FloatDeserializer implements JsonDeserializer<Float> {
        private FloatDeserializer() {
        }

        public Float deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Float.valueOf(json.getAsFloat());
        }

        public String toString() {
            return FloatDeserializer.class.getSimpleName();
        }
    }

    static class DoubleSerializer implements JsonSerializer<Double> {
        private final boolean serializeSpecialFloatingPointValues;

        DoubleSerializer(boolean serializeSpecialDoubleValues) {
            this.serializeSpecialFloatingPointValues = serializeSpecialDoubleValues;
        }

        public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
            if (this.serializeSpecialFloatingPointValues || (!Double.isNaN(src.doubleValue()) && !Double.isInfinite(src.doubleValue()))) {
                return new JsonPrimitive((Number) src);
            }
            throw new IllegalArgumentException(src + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialDoubleValues() method.");
        }
    }

    private static class DoubleDeserializer implements JsonDeserializer<Double> {
        private DoubleDeserializer() {
        }

        public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Double.valueOf(json.getAsDouble());
        }

        public String toString() {
            return DoubleDeserializer.class.getSimpleName();
        }
    }

    private static class CharacterTypeAdapter implements JsonSerializer<Character>, JsonDeserializer<Character> {
        private CharacterTypeAdapter() {
        }

        public JsonElement serialize(Character src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src);
        }

        public Character deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Character.valueOf(json.getAsCharacter());
        }

        public String toString() {
            return CharacterTypeAdapter.class.getSimpleName();
        }
    }

    private static class StringTypeAdapter implements JsonSerializer<String>, JsonDeserializer<String> {
        private StringTypeAdapter() {
        }

        public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src);
        }

        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return json.getAsString();
        }

        public String toString() {
            return StringTypeAdapter.class.getSimpleName();
        }
    }

    private static class BooleanTypeAdapter implements JsonSerializer<Boolean>, JsonDeserializer<Boolean> {
        private BooleanTypeAdapter() {
        }

        public JsonElement serialize(Boolean src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src);
        }

        public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Boolean.valueOf(json.getAsBoolean());
        }

        public String toString() {
            return BooleanTypeAdapter.class.getSimpleName();
        }
    }

    private static class TreeSetCreator implements InstanceCreator<TreeSet<?>> {
        private TreeSetCreator() {
        }

        public TreeSet<?> createInstance(Type type) {
            return new TreeSet<>();
        }

        public String toString() {
            return TreeSetCreator.class.getSimpleName();
        }
    }

    private static class HashSetCreator implements InstanceCreator<HashSet<?>> {
        private HashSetCreator() {
        }

        public HashSet<?> createInstance(Type type) {
            return new HashSet<>();
        }

        public String toString() {
            return HashSetCreator.class.getSimpleName();
        }
    }
}
